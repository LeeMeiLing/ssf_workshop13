package sg.edu.nus.iss.workshop13.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.workshop13.model.Contact;
import sg.edu.nus.iss.workshop13.repository.ContactsRepo;

@Controller
@RequestMapping
public class AddressbookController {

    @Autowired
    private ContactsRepo ctcRepo;

    @Value("${dataDir}")
    String dataDir;
    
    @GetMapping("/contact")
    public String showForm(Model model){

        model.addAttribute("contact", new Contact());
        return "/contact";
    }

    @GetMapping("/contact/{id}")
    public String showContact(@PathVariable String id, Model model) throws IOException, ParseException{

        // File file = new File("C:", File.separator + dataDir + File.separator + id);
        File file = new File(dataDir + File.separator + id);
        if (file.exists()){

            // retrieve contact from file & store to contact
            
            BufferedReader br = new BufferedReader(new FileReader(file));

            Contact contact = new Contact(br.readLine());
            contact.setName(br.readLine());
            contact.setEmail(br.readLine());
            contact.setPhoneNum(br.readLine());

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            contact.setBirthday(formatter.parse(br.readLine()));
        
            model.addAttribute("contact", contact);
            return "/contact";

        }else{
            System.out.println("File not found");
            return "/fileNotFound";
        }
        
    }

    @PostMapping("/contact")
    public String saveContact(@ModelAttribute(name="contact") Contact ctc) throws IOException{

        ctcRepo.saveFile(ctc);
    
        return "redirect:/contact/" + ctc.getId();
    }


}
