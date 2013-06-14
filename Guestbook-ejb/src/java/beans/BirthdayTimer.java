/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import interceptors.LoggingInterceptor;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Roel_Storms
 */
@Stateless
@Interceptors(LoggingInterceptor.class)
public class BirthdayTimer implements BirthdayTimerLocal {

    @Resource(name = "mail")
    private Session mailSession;
     
    @Schedule(minute = "1", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "1", dayOfWeek = "*")
    @Override
    public void myTimer() {
        try {
            System.out.println("Timer event: " + new Date());
            // Create the message object
         Message message = new MimeMessage(mailSession);

         // Adjust the recipients. Here we have only one
         // recipient. The recipient's address must be
         // an object of the InternetAddress class.
         message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("bjornderaeve@hotmail.com", false));

         // Set the message's subject
         message.setSubject("It is " + new Date());

         // Insert the message's body
         message.setText("It is " + new Date());

         // This is not mandatory, however, it is a good
         // practice to indicate the software which
         // constructed the message.
         message.setHeader("X-Mailer", "My Mailer");

         // Adjust the date of sending the message
         Date timeStamp = new Date();
         message.setSentDate(timeStamp);

         // Use the 'send' static method of the Transport
         // class to send the message
         Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(BirthdayTimer.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
