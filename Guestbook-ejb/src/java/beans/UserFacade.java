/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matthias
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
	@PersistenceContext(unitName = "Guestbook-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UserFacade() {
		super(User.class);
	}
	
}
