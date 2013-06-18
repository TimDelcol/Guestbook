/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Userentity;
import javax.ejb.Local;

/**
 *
 * @author Roel_Storms
 */
@Local
public interface SessionLocal {
        String getUsername();
        void setUser(Userentity user);
        int getID();

    public boolean isLoggedIn();
}
