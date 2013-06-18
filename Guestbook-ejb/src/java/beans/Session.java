/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Rights;
import entities.Userentity;
import java.util.concurrent.TimeUnit;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 *
 * @author Roel_Storms
 */
@Stateful
@StatefulTimeout(value = 20, unit = TimeUnit.SECONDS)
public class Session implements SessionLocal {

    private Userentity user;

    public Session() {
        this.user = null;
    }

    
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public void setUser(Userentity user) {
        this.user = user;
    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLoggedIn() {
        if (user == null)
            return false;
        return true;
    }
    
    
}
