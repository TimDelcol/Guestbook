/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;

/**
 *
 * @author matthias
 */
@Remote
public interface AccessBeanRemote {
    
    void createTestUser();
            
}
