/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author matthias
 */
@Entity
@Table(catalog = "a12_DA5", schema = "dbo")
@XmlRootElement
/*@NamedQueries({
	@NamedQuery(name = "Userentity.findAll", query = "SELECT u FROM Userentity u"),
	@NamedQuery(name = "Userentity.findById", query = "SELECT u FROM Userentity u WHERE u.id = :id"),
	@NamedQuery(name = "Userentity.findByUsername", query = "SELECT u FROM Userentity u WHERE u.username = :username"),
	@NamedQuery(name = "Userentity.findByEmail", query = "SELECT u FROM Userentity u WHERE u.email = :email"),
	@NamedQuery(name = "Userentity.findByDateofbirth", query = "SELECT u FROM Userentity u WHERE u.dateofbirth = :dateofbirth"),
	@NamedQuery(name = "Userentity.findByPassword", query = "SELECT u FROM Userentity u WHERE u.password = :password"),
	@NamedQuery(name = "Userentity.findByRights", query = "SELECT u FROM Userentity u WHERE u.rights = :rights")})
*/
public class Userentity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 50)
        @Column(nullable = false, length = 50)
	private String username;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 50)
        @Column(nullable = false, length = 50)
	private String email;
	/*
	@Basic(optional = false)
        @NotNull
        @Column(nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;
	*/
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 50)
        @Column(nullable = false, length = 50)
	private String password;
	/*
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 50)
        @Column(nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private Rights rights;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userId")
	private Collection<Message> messageCollection;
	*/
	public Userentity() {
	}

	public Userentity(Integer id) {
		this.id = id;
	}

	public Userentity(Integer id, String username, String email, /*Date dateofbirth, */String password/*, Rights rights*/) {
		this.id = id;
		this.username = username;
		this.email = email;
		//this.dateofbirth = dateofbirth;
		this.password = password;
		//this.rights = rights;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
*/
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/*
	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	@XmlTransient
	public Collection<Message> getMessageCollection() {
		return messageCollection;
	}

	public void setMessageCollection(Collection<Message> messageCollection) {
		this.messageCollection = messageCollection;
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
		if (!(object instanceof Userentity)) {
			return false;
		}
		Userentity other = (Userentity) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.Userentity[ id=" + id + " ]";
	}
	
}
