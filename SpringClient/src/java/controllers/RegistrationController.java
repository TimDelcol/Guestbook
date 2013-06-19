/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.AccessBeanRemote;
import entities.TempUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      binder.registerCustomEditor(Date.class, new CustomDateEditor(
              dateFormat, false));
    }
    
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
 
    @ModelAttribute("TempUser")
    public TempUser getLoginForm() {
        return new TempUser();
    }
    
    @RequestMapping(value = "/registration.htm", method = RequestMethod.GET)
    public String showForm(Map model) {
        System.out.println("registration.htm GET");
        if(accessBean.isLoggedIn())
        {
            model.put("loggedIn", "Logged in as " + accessBean.getUsername());
        }
        return "registration";
    }
 
    @RequestMapping(value = "/registration.htm", method = RequestMethod.POST)
    public String validateForm(
        
        @ModelAttribute("TempUser") @Valid TempUser myUser,
        BindingResult result, Map model) {
        System.out.println("Username: " + myUser.getUsername());
        System.out.println("registration.htm POST");
        
        /*if(accessBean.isLoggedIn())
        {
            model.put("loggedIn", "Logged in as " + accessBean.getUsername());
            
            return "login";
        }*/
        
        if (result.hasErrors()) {
            return "registration";
        }
 
        accessBean.addUser(myUser.getUsername(), myUser.getPassword(), myUser.getDateOfBirth(), myUser.getEmail());
        model.put("action", "Registration");
    
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
