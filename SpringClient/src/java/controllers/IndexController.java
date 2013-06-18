/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.MessageEntityFacadeLocal;
import entities.MessageEntity;
import java.util.List;
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
 * @author matthias
 */
@Controller
public class IndexController {
    //MessageEntityFacadeLocal messageEntityFacade = lookupMessageEntityFacadeLocal();
	
	@RequestMapping("/index.htm")
	public String home(Map<String, Object> map){
      /*      MessageEntity m = new MessageEntity();
            m.setBody("Test body");
            m.setTitle("Test title");
            messageEntityFacade.create(m);
            List<MessageEntity> messages = messageEntityFacade.findAll();
            
            String table = "<table>";
            for (MessageEntity message : messages)
            {
                table = table.concat("<tr>");
                table = table.concat("title");
                table = table.concat("</tr>");
                
                table = table.concat("<tr>");
                table = table.concat(message.getTitle());
                table = table.concat("</tr>");
                table = table.concat("<tr>");
                table = table.concat("Message");
                table = table.concat("</tr>");
                table = table.concat("<tr>");
                table = table.concat(message.getBody());
                table = table.concat("</tr>");
            }
            table = table.concat("</table>");
            
            map.put("messages", table);*/
            return "index";       
                
	}
/*
    private MessageEntityFacadeLocal lookupMessageEntityFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (MessageEntityFacadeLocal) c.lookup("java:global/Guestbook/Guestbook-ejb/MessageEntityFacade!beans.MessageEntityFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
*/
}
