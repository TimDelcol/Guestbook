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
        if(user != null)
            return user.getUsername();
        return "No name";
    }

    @Override
    public void setUser(Userentity user) {
        this.user = user;
    }

    @Override
    public int getID() {
        if(user != null)
            return user.getId();
        return 0;
    }

    @Override
    public boolean isLoggedIn() {
        if (user == null)
            return false;
        return true;
    }
    
    
}
