/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.MessageEntity;
import entities.Userentity;
import interceptors.LoggingInterceptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matthias
 */
@Stateless
@Interceptors(LoggingInterceptor.class)
public class UserentityFacade extends AbstractFacade<Userentity> implements UserentityFacadeLocal {
	@PersistenceContext(unitName = "Guestbook-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UserentityFacade() {
		super(Userentity.class);
	}

	@Override
	public List<Userentity> getBirthdaysToday() {
	
		Calendar cal = Calendar.getInstance();
		return (List<Userentity>)em.createNamedQuery("Userentity.findBirthdays")
			.setParameter("month", cal.get(Calendar.MONTH)+1)//calendar months go from 0-11 so +1 is needed
			.setParameter("day", cal.get(Calendar.DAY_OF_MONTH))
			.getResultList();
		
	}
	
	@Override
	public void createTestUser() {
            /*
                MessageEntity m = new MessageEntity();
                m.setBody("body");
                m.setTitle("Title");
                em.persist(m);
              */  
		Userentity u = new Userentity();
		u.setDateofbirth(new Date(0));
		u.setEmail("roelstorms@hotmail.com");
		u.setPassword("password");
		u.setUsername("username");
                Date date;
                date = new Date();
                u.setDateofbirth(date);
		
                ArrayList<MessageEntity> collection = new ArrayList<MessageEntity>();
		ArrayList<Userentity> usersLiked = new ArrayList<Userentity>();
		
                MessageEntity m = new MessageEntity();
                m.setTitle("Message title");
                m.setBody("Message body");
		usersLiked.add(u);
		m.setLikedBy(usersLiked);
                em.persist(m);
		
                collection.add(m);
                u.setOwnMessages(collection);
		u.setRights(entities.Rights.ADMIN);
		
		em.persist(u);
                
	}

    @Override
    public Userentity login(String username, String password) {
	
	    List<Userentity> users = (List<Userentity>)em.createNamedQuery("Userentity.checkLogin")
			.setParameter("username", username)
			.setParameter("password", password)
			.getResultList();
	    
	    if(users.isEmpty())
		    return null;
	    
	    return users.get(0);
    }
	
}
