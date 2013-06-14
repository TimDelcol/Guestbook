/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Message;
import entities.Userentity;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matthias
 */
@Stateless
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
	public void createTestUser() {
            /*
                Message m = new Message();
                m.setBody("body");
                m.setTitle("Title");
                em.persist(m);
              */  
		Userentity u = new Userentity();
		u.setDateofbirth(new Date(0));
		u.setEmail("mvp@mvp.com");
		u.setPassword("pwd");
		u.setUsername("mvp");
                Date date;
                date = new Date();
                u.setDateofbirth(date);
                ArrayList<Message> collection = new ArrayList<Message>();
                Message m = new Message();
                m.setTitle("Message title");
                m.setBody("Message body");
                em.persist(m);
                collection.add(m);
                u.setMessageCollection(collection);
		u.setRights(entities.Rights.ADMIN);
		
		em.persist(u);
                
	}
	
}
