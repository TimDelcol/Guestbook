/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.MessageEntity;
import entities.Rights;
import interceptors.LoggingInterceptor;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import entities.Userentity;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author matthias
 */
@Stateless
@Interceptors(LoggingInterceptor.class)
public class AccessBean implements AccessBeanRemote {

   

    @EJB
    UserentityFacadeLocal uf;
    @EJB
    MessageEntityFacadeLocal mf;
    
    @Resource(mappedName = "jms/EmailMDBFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/EmailMDB")
    private Queue queue;

    private SessionLocal session;
    public AccessBean() {
        session = lookupSessionLocal();
    }

    @Override
    public void createTestUser() {
        System.out.println("createTestUser");
    }

    @Override
    public void addUser(String username, String password, Date dateOfBirth, String email) {
        Userentity ue = new Userentity(username, email, dateOfBirth, password, Rights.USER);
        uf.create(ue);


        try {
            Connection connection = connectionFactory.createConnection();

            /*  connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
             * 
             *  Session is not transacted (false)
             * 
             *  AUTO_ACKNOWLEDGE 
             *  With this acknowledgment mode, the session automatically acknowledges a client's receipt of a 
             *  message either when the session has successfully returned from a call to receive or when the 
             *  message listener the session has called to process the message successfully returns.
             */
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            entities.EmailMessage emailMessage;
            ObjectMessage message = session.createObjectMessage();
            // here we create NewsEntity, that will be sent in JMS message
            String title = "Guestbook registration success";
            String body = "\nHello " + username + ",\n \nThanks for registrating to the guestbook. \n \nKind regards,\nJava EE6 guestbook team";
            emailMessage = new entities.EmailMessage(title, body, email);
            message.setObject(emailMessage);
            messageProducer.send(message);
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            System.out.println("JMSException");
        }
    }

    @Override
    public void addMessage(String title, String body) {
        Userentity u = uf.find(session.getID());
	MessageEntity m = new MessageEntity();
	
	m.setTitle(title);
	m.setBody(body);
	mf.create(m);
	
	u.getOwnMessages().add(m);
	uf.edit(u);
		
    }

    @Override
    public String getUsername() {
        return session.getUsername();
    }

    @Override
    public boolean login(String username, String password) {
        Userentity user = uf.login(username, password);
        if(user != null)
        {
            session.setUser(user);
            return true;
        }
        return false;
    }

    @Override
    public int getUserID() {
        
        return session.getID();
    }
    
    @Override
    public void logout() {
	    session.setUser(null);
    }

    @Override
    public boolean isLoggedIn() {
        return session.isLoggedIn();
    }
    
    
        private SessionLocal lookupSessionLocal() {
        try {
            Context c = new InitialContext();
            return (SessionLocal) c.lookup("java:global/Guestbook/Guestbook-ejb/Session!beans.SessionLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
