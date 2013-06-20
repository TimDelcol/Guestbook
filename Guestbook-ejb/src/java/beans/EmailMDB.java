/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.EmailMessage;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Roel_Storms
 */
@MessageDriven(mappedName = "jms/EmailMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EmailMDB implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;
    
    @Resource(name = "mail")
    private Session mailSession;
    
    public EmailMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("onMessage in MDB");
        ObjectMessage msg;
        if (message instanceof ObjectMessage) {
            msg = (ObjectMessage) message;
            
            try { 
                EmailMessage emailMessage = (EmailMessage) msg.getObject();

                System.out.println(emailMessage.getAddress() + "\n" + emailMessage.getTitle()+ "\n" + emailMessage.getBody());
                // Create the message object
                javax.mail.Message mimeMessage = new MimeMessage(mailSession);
                
                // Adjust the recipients. Here we have only one
                // recipient. The recipient's address must be
                // an object of the InternetAddress class.
                mimeMessage.setRecipients(javax.mail.Message.RecipientType.TO,
                             InternetAddress.parse(emailMessage.getAddress(), false));

                // Set the message's subject
                //emessage.setSubject("It is " + new Date());
                mimeMessage.setSubject(emailMessage.getTitle());

                // Insert the message's body
                //emessage.setText("It is " + new Date());
                mimeMessage.setText(emailMessage.getBody());

                // This is not mandatory, however, it is a good
                // practice to indicate the software which
                // constructed the message.
                mimeMessage.setHeader("X-Mailer", "My Mailer");

                // Adjust the date of sending the message
                Date timeStamp = new Date();
                mimeMessage.setSentDate(timeStamp);

                // Use the 'send' static method of the Transport
                // class to send the message
                Transport.send(mimeMessage);     
            } catch (MessagingException ex) {
                Logger.getLogger(BirthdayTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (JMSException ex) {
                Logger.getLogger(EmailMDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
        

    }
}
