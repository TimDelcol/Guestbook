/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author Roel_Storms
 */
public class User {
 
    @NotNull
    @Size(min=5,max=20)
    private String username;

    @NotNull
    @Size(min=5,max=20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
 
    public User() {
        username = "";
        password = "";
    }
 
    // Setters & Getters
 
}