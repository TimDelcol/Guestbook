/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.PersonFacade;
import beans.UserdbFacade;
import entities.Userdb;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author matthias
 */
public class Main {
	
	//static UserdbFacade uf = new UserdbFacade();

	//static PersonFacade pf = new PersonFacade();
		
	public static void main(String args[]){
			
	System.out.println("program starting");
	//uf.createTestUser();
	
	//pf.addPerson();
	
	Userdb u = new Userdb();
	u.setEmail("blabla");
	u.setDateOfBirth(new Date(0));
	u.setFirstname("ikke");
	u.setLastname("mijnachternaam");
	u.setOnline(false);
	u.setPassword("pwd");
	u.setUsername("muahaha");
	
	EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("Guestbook-ejbPU");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	em.persist(u);
	em.getTransaction().commit();
	em.close();
	
	
	System.out.println("User added");
			
	}
}
