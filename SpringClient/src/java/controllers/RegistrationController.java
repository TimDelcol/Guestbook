/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.AccessBeanRemote;
import entities.User;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
    AccessBeanRemote accessBean = lookupAccessBeanRemote();
    
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
        accessBean.createTestUser();
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

    private AccessBeanRemote lookupAccessBeanRemote() {
        try {
            Context c = new InitialContext();
            return (AccessBeanRemote) c.lookup("java:global/Guestbook/Guestbook-ejb/AccessBean!beans.AccessBeanRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
