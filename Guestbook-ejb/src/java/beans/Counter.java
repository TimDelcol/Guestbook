/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import interceptors.LoggingInterceptor;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.interceptor.Interceptors;

/**
 *
 * @author BJORN
 */
@Stateful
@LocalBean
@Interceptors(LoggingInterceptor.class)
public class Counter {
    
    private int counter = 0;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String getCounter() {
        return ""+counter;
    }
    
    public void incrementCounter() {
        counter++;
    }

}
