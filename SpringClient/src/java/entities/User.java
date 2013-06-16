/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Roel_Storms
 */
public class User {
 
    @NotNull
    @Size(min=1,max=20)
    private String name;
 
    @Min(0)
    @Max(120)
    private int age;
 
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public User() {
        name = "";
        age = 0;
    }
 
    // Setters & Getters
 
}