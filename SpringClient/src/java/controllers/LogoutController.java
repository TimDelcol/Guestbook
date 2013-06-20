/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.AccessBeanRemote;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Roel_Storms
 */

@Controller
public class LogoutController {
    AccessBeanRemote accessBean = lookupAccessBeanRemote();
    
    @RequestMapping(value = "/logout.htm")
    public String showForm(Map model) {
        System.out.println("logout.htm ");
        if(accessBean.isLoggedIn())
        {
            model.put("loggedIn", "<font color='green'>Succesfully logged out</font>");
            accessBean.logout();
            return "index";
        }
        model.put("loggedIn", "<font color='red'>You were not logged in</font>");
        return "index";
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
