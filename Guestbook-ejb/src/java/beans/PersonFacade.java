/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author matthias
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {
	@PersistenceContext(unitName = "Guestbook-ejbPU")
	private EntityManager em;
	
	

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PersonFacade() {
		super(Person.class);
	}
	
	public void addPerson(){
		Person p = new Person();
		p.setAddress("ergens");
		p.setName("iemand");
		
		em.persist(p);
	}

	public void persist(Object object) {
		em.persist(object);
	}
	
}
