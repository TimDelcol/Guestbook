/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.UserdbFacade;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matthias
 */
public class Main {
	
	@EJB
	private static UserdbFacade uf = new UserdbFacade();
		
	public static void main(String args[]){
			
	System.out.println("program starting");
	uf.createTestUser();
	System.out.println("User added");
			
	}
}
