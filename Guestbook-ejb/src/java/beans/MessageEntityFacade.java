/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.MessageEntity;
import interceptors.LoggingInterceptor;
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
public class MessageEntityFacade extends AbstractFacade<MessageEntity> implements MessageEntityFacadeLocal {
	@PersistenceContext(unitName = "Guestbook-ejbPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MessageEntityFacade() {
		super(MessageEntity.class);
	}
	
}
