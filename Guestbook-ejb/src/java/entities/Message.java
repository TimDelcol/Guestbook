/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author matthias
 */
@Entity
@Table(catalog ="a12_DA5", schema="dbo")
@NamedQueries({
	@NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
	@NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id"),
	@NamedQuery(name = "Message.findByTitle", query = "SELECT m FROM Message m WHERE m.title = :title"),
	@NamedQuery(name = "Message.findByBody", query = "SELECT m FROM Message m WHERE m.body = :body")})
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
        @NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
        @Column(length = 50)
	private String title;
	
        @Column(columnDefinition = "text", length = 20000)
	private String body;
	
	@ManyToMany
	@JoinTable(name = "USER_MSG_LIKES", joinColumns = @JoinColumn(name = "MSG_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	private Collection<Userentity> likedBy;

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

	public Collection<Userentity> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(Collection<Userentity> likedBy) {
		this.likedBy = likedBy;
	}
              
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
