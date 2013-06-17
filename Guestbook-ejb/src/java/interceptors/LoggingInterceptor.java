/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author matthias
 */
public class LoggingInterceptor implements Serializable{
	
	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());
	
	
	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception {
		logger.setLevel(Level.FINE);
		logger.log(Level.FINE, "{0}: {1}: <ENTRY>", new Object[]{ic.getTarget().toString(), ic.getMethod()});
		//logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
		
		try {
			return ic.proceed();
		}
		finally {
			logger.log(Level.FINE, "{0}: {1}: <RETURN>", new Object[]{ic.getTarget().toString(), ic.getMethod()});
			//logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
		}
	}
	
}
