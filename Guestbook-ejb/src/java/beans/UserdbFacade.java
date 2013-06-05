/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Userdb;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matthias
 */
@Stateless
public class UserdbFacade extends AbstractFacade<Userdb> {
	
	@PersistenceContext(unitName="Guestbook-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UserdbFacade() {
		super(Userdb.class);
	}
	
	public void createTestUser(){
			
	Userdb u = new Userdb();
	
	u.setFirstname("Matthias");
	u.setLastname("Van Parys");
	u.setUsername("mvp");
	u.setPassword("mvp");
	u.setDateOfBirth(new Date(System.currentTimeMillis()));
	
	if(getEntityManager()==null)
		System.out.println("null, null everywhere");
	else
		getEntityManager().persist(u);
	}
	
}
