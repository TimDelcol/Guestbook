/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matthias
 */
@Entity
@Table(catalog ="a12_DA5", schema="dbo")
//@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
	@NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id"),
	@NamedQuery(name = "Message.findByTitle", query = "SELECT m FROM Message m WHERE m.title = :title"),
	@NamedQuery(name = "Message.findByBody", query = "SELECT m FROM Message m WHERE m.body = :body")})
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Size(max = 50)
        @Column(length = 50)
	private String title;
        @Column(length = 8000)
	private String body;
        
        /*
	@JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
        @ManyToOne(optional = false)
	private Userentity userId;
        */
         
	public Message() {
	}

	public Message(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

        /*
	public Userentity getUserId() {
		return userId;
	}

	public void setUserId(Userentity userId) {
		this.userId = userId;
	}
        */
        
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Message)) {
			return false;
		}
		Message other = (Message) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.Message[ id=" + id + " ]";
	}
	
}
