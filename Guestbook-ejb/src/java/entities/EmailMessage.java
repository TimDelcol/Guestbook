/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Roel_Storms
 */
public class EmailMessage implements Serializable{
    
    private String title, body, address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmailMessage(String title, String body, String address) {
        this.title = title;
        this.body = body;
        this.address = address;
    }
    
    
}
