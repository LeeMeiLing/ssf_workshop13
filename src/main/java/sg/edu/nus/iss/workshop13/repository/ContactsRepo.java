package sg.edu.nus.iss.workshop13.repository;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop13.model.Contact;

@Repository
public class ContactsRepo {
    
    @Value("${dataDir}")
    String dataDir;
    
    public void saveFile(Contact ctc) throws IOException{
        
        //create file
        Path path = Paths.get(dataDir, File.separator, ctc.getId());
        System.out.println(path);
        File file = path.toFile();
        if(!file.exists()){
            file.createNewFile();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        //write to file
        try (PrintWriter pw = new PrintWriter(file)){
            pw.println(ctc.getId());
            pw.flush();
            pw.println(ctc.getName());
            pw.flush();
            pw.println(ctc.getEmail());
            pw.flush();
            pw.println(ctc.getPhoneNum());
            pw.flush();
            pw.println(formatter.format(ctc.getBirthday()));
            pw.flush();
            // pw.println(ctc.getBirthday().toString());
            // pw.flush();
        }

    }
}
