/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author matthias
 */
@Remote
public interface AccessBeanRemote {
    
    void createTestUser();
    void addUser(String username, String password, Date dateOfBirth, String email);
    void addMessage(String title, String body);
    String getUsername();
    boolean login(String username, String password);
    int getUserID();
    boolean isLoggedIn();
    void logout();
}
