/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matthias
 */
@Entity
@XmlRootElement
@Table(name = "USERDB")
public class Userdb implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="ID")
        @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(name="USERNAME")
	private String username;
	
	@NotNull
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@NotNull
	@Column(name="LASTNAME")
	private String lastname;
	
	@NotNull
	@Column(name="PASSWORD")
	private String password;
	
	@NotNull
	@Column(name="EMAIL")
	private String email;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@NotNull
	@Column(name="DATEOFBIRTH")
	private Date dateOfBirth;
		
	@Temporal(javax.persistence.TemporalType.DATE)
	@NotNull
	@Column(name="LASTONLINE")
	private Date lastOnline = new Date(0);
		
	private boolean online = false;	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getLastOnline() {
		return lastOnline;
	}

	public void setLastOnline(Date lastOnline) {
		this.lastOnline = lastOnline;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		if (!(object instanceof Userdb)) {
			return false;
		}
		Userdb other = (Userdb) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Id:" + id + "Name: " + firstname + " " + lastname;
	}
	
}
