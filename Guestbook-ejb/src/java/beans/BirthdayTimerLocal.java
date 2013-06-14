/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;

/**
 *
 * @author Roel_Storms
 */
@Local
public interface BirthdayTimerLocal {
    
    public void myTimer();
}
