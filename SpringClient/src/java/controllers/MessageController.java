/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.AccessBeanRemote;
import entities.TempMessage;
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
public class MessageController {
    AccessBeanRemote accessBean = lookupAccessBeanRemote();
    
    @ModelAttribute("TempMessage")
    public TempMessage getLoginForm() {
        return new TempMessage();
    }
    
    @RequestMapping(value = "/newmessage.htm", method = RequestMethod.GET)
    public String showForm(Map model) {
        System.out.println("newmessage.htm GET");
        if(accessBean.isLoggedIn())
        {
            model.put("loggedIn", "Logged in as " + accessBean.getUsername());
            return "newmessageform";
        }
        else
        {
            model.put("loggedIn", "<font color='red'>Failed, not logged in</font>");
            return "index";
        }
    }
 
 
    
    @RequestMapping(value = "/newmessage.htm", method = RequestMethod.POST)
    public String validateForm(
        
        @ModelAttribute("TempMessage") @Valid TempMessage myMessage,
        BindingResult result, Map model) {
        System.out.println("newmessage.htm POST");
        /*
        if(accessBean.isLoggedIn())
        {
            model.put("loggedIn", "Logged in as " + accessBean.getUsername());
        }
        */
        if (result.hasErrors()) {
            return "newmessageform";
        }
 
        // TODO : put new message in the DB
        accessBean.addMessage(myMessage.getTitle(), myMessage.getBody());
        model.put("action", "New message");
 
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
