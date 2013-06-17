/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import interceptors.LoggingInterceptor;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

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
	MessageFacadeLocal mf;
	

}
