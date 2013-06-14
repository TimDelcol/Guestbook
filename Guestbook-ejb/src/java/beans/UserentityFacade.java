/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Userentity;
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
		Userentity u = new Userentity();
		//u.setDateofbirth(new Date(0));
		u.setEmail("mvp@mvp.com");
		u.setPassword("pwd");
		u.setUsername("mvp");
		//u.setRights(entities.Rights.ADMIN);
		
		em.persist(u);
	}
	
}
