/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.AccessBeanRemote;
import entities.LoginUser;
import entities.TempUser;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class LoginController {
    AccessBeanRemote accessBean = lookupAccessBeanRemote();
 
    @ModelAttribute("LoginUser")
    public LoginUser getLoginForm() {
        return new LoginUser();
    }
    
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String showForm(Map model) {
        System.out.println("login.htm GET");
        if(accessBean.isLoggedIn())
        {
            model.put("loggedIn", "Logged in as " + accessBean.getUsername());
            
            return "login";
        }
        return "login";
    }
 
    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String validateForm(
        
        @ModelAttribute("LoginUser") @Valid LoginUser myUser,
        BindingResult result, Map model) {

        System.out.println("login.htm POST");
 
        if (result.hasErrors()) {
            return "login";
        }
 
        accessBean.login(myUser.getUsername(), myUser.getPassword());
        
        if(!accessBean.isLoggedIn())
        {
            model.put("loginFailure", "Wrong username or password");
            
            return "login";
        }
        model.put("loggedIn", accessBean.getUsername());
        model.put("action", "Login");
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
