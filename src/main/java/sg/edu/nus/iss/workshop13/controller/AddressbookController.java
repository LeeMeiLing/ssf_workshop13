package sg.edu.nus.iss.workshop13.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.workshop13.model.Contact;
import sg.edu.nus.iss.workshop13.repository.ContactsRepo;

@Controller
@RequestMapping
public class AddressbookController {

    @Autowired
    private ContactsRepo ctcRepo;
    
    @GetMapping("/contact")
    public String showForm(Model model){

        model.addAttribute("contact", new Contact());
        return "/contact";
    }

    @PostMapping("/contact")
    public String saveContact(@ModelAttribute Contact ctc) throws IOException{

        ctcRepo.saveFile(ctc);
        return "/contact";
    }


}
