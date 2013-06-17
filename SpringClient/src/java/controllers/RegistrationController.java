/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RegistrationController {
    
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
 
    @ModelAttribute("User")
    public User getLoginForm() {
        return new User();
    }
    
    @RequestMapping(value = "/registration.htm", method = RequestMethod.GET)
    public String showForm(Map model) {
        System.out.println("registration.htm GET");
        return "registration";
    }
 
    @RequestMapping(value = "/registration.htm", method = RequestMethod.POST)
    public String validateForm(
        
        @ModelAttribute("User") @Valid User myUser,
        BindingResult result, Map model) {
        System.out.println("Username: " + myUser.getUsername());
        System.out.println("registration.htm POST");
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        model.put("User", myUser);
 
        return "registrationsuccess";
 
    }
}
