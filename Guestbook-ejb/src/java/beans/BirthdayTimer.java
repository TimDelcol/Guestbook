/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author Roel_Storms
 */
@Stateless
public class BirthdayTimer implements BirthdayTimerLocal {
    
    @Resource(mappedName="jms/EmailMDBFactory")
    private  ConnectionFactory connectionFactory;

    @Resource(mappedName="jms/EmailMDB")
    private  Queue queue;
    
    
    @Schedule(minute = "*", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "*", dayOfWeek = "*")
    @Override
    public void myTimer() {
        
        System.out.println("Timer event: " + new Date());
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);

            ObjectMessage message = session.createObjectMessage();
            // here we create NewsEntity, that will be sent in JMS message
            EmailMessage emailMessage = new EmailMessage("Je mag Roel geen pijntjes doen", "Je mag Roel geen pijntjes doen", "fientjedewinter@hotmail.com");

            message.setObject(emailMessage);                
            messageProducer.send(message);
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
