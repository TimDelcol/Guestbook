/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Roel_Storms
 */
public class Message {
    @NotNull
    @Size(min=5,max=100)
    private String title;

    @NotNull
    @Size(min=5,max=20000)
    private String body;
        
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

   
    public Message(String title, String body) {
        this.title = title;
        this.body = body;
    }
 
    public Message() {
        title = "";
        body = "";
    }
}
