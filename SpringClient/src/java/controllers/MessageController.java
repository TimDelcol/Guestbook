/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.MessageClass;
import entities.User;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Roel_Storms
 */
@Controller
public class MessageController {
    
    
    @ModelAttribute("MessageClass")
    public MessageClass getLoginForm() {
        return new MessageClass();
    }
    
    @RequestMapping(value = "/newmessage.htm", method = RequestMethod.GET)
    public String showForm(Map model) {
        System.out.println("registration.htm GET");
        return "newmessageform";
    }
 
 
    
    @RequestMapping(value = "/newmessage.htm", method = RequestMethod.POST)
    public String validateForm(
        
        @ModelAttribute("MessageClass") @Valid MessageClass myMessage,
        BindingResult result, Map model) {
        System.out.println("newmessage.htm POST");
 
        if (result.hasErrors()) {
            return "newmessageform";
        }
 
        // TODO : put new message in the DB
        //accessBean.addUser(myUser.getUsername(), myUser.getPassword(), myUser.getDateOfBirth(), myUser.getEmail());
        model.put("action", "New message");
 
        return "registrationsuccess";
    }
}
