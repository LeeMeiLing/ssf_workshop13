package sg.edu.nus.iss.workshop13.model;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

public class Contact {
    
    private String id;
    private String name;
    private String email;
    private String phoneNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday; // binding error from form input date if w/o @DateTimeFormat

    //private String birthday;  // if use String, form input date will pparse as String

    public Contact() {
        this.id = this.generateId(8);
    }

    
    public Contact(String id) {
        this.id = id;
    }

    public Contact(String name, String email, String phoneNum, Date birthday) {
        this.id = this.generateId(8);;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private synchronized String generateId(int numofChars) {

        Random r = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numofChars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0,numofChars);
    }
    
}
