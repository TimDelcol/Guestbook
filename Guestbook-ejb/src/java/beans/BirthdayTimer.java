/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Userentity;
import java.util.Collection;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.InvalidDestinationException;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import org.jboss.weld.context.ejb.Ejb;

/**
 *
 * @author Roel_Storms
 */
@Stateless
public class BirthdayTimer implements BirthdayTimerLocal {
    @Ejb
    private UserentityFacade userEntityFacade;
    
    @Resource(mappedName="jms/EmailMDBFactory")
    private  ConnectionFactory connectionFactory;

    @Resource(mappedName="jms/EmailMDB")
    private  Queue queue;
    
    
    /**
     *  myTimer is called every minute and checks the database for everyone who has his birthday today.
     *  An email is sent to each birthday boy or girl. Sending an e-mail happens in the EmailMDB.
     *  An EmailMessage is created and put onto the queue to the MDB where the e-mail is sent.
     */
    // TODO : Changed to definitive scheduel after testing.
    @Schedule(minute = "*", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "*", dayOfWeek = "*")   // Test schedule: Every minute
    //@Schedule(minute = "1", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "0", dayOfWeek = "*")   // Definitive schedule: Every day
    @Override
    public void myTimer() {
        
        System.out.println("Timer event: " + new Date());

        Collection<Userentity> birthdayPeople = null;   // TODO: Should be assigned to UserentityFacade.getBirthdaysToday(Date date)
        
        try {
            Connection connection = connectionFactory.createConnection();
            
            
            /*  
             *  Session is not transacted (false)
             * 
             *  AUTO_ACKNOWLEDGE 
             *  With this acknowledgment mode, the session automatically acknowledges a client's receipt of a 
             *  message either when the session has successfully returned from a call to receive or when the 
             *  message listener the session has called to process the message successfully returns.
             */
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer messageProducer = session.createProducer(queue);
            
            EmailMessage emailMessage;
            
            for(Userentity user : birthdayPeople)
            {
                ObjectMessage message = session.createObjectMessage();
                // here we create NewsEntity, that will be sent in JMS message
                String title = "Happy birthday " + user.getUsername();
                String body = "<br>Hello " +  user.getUsername() + ",<br> <br> The Java EE 6 guestbook team wishes you a happy birthday. <br> <br> Kind regards,<br>Java EE6 guestbook team";

                emailMessage = new EmailMessage(title, body, user.getEmail());

                message.setObject(emailMessage);                
                messageProducer.send(message);
            }
                    
            
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
