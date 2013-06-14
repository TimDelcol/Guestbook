/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author BJORN
 */
@Stateful
@LocalBean
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
