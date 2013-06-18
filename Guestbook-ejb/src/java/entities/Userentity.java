/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author matthias
 */
@Entity
@Table(catalog ="a12_DA5", schema="dbo")
@NamedQueries({
	@NamedQuery(name = "Userentity.findAll", query = "SELECT u FROM Userentity u"),
	@NamedQuery(name = "Userentity.findById", query = "SELECT u FROM Userentity u WHERE u.id = :id"),
	@NamedQuery(name = "Userentity.findByUsername", query = "SELECT u FROM Userentity u WHERE u.username = :username"),
	@NamedQuery(name = "Userentity.findByEmail", query = "SELECT u FROM Userentity u WHERE u.email = :email"),
	@NamedQuery(name = "Userentity.findByDateofbirth", query = "SELECT u FROM Userentity u WHERE u.dateofbirth = :dateofbirth"),
	@NamedQuery(name = "Userentity.findByPassword", query = "SELECT u FROM Userentity u WHERE u.password = :password"),
	@NamedQuery(name = "Userentity.findByRights", query = "SELECT u FROM Userentity u WHERE u.rights = :rights"),
	@NamedQuery(name = "Userentity.findBirthdays", query = "SELECT u FROM Userentity u WHERE FUNC('MONTH', u.dateofbirth) = :month AND FUNC('DAY', u.dateofbirth) = :day")
})
public class Userentity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
        @NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
        @NotNull
        @Column(length = 50)
	private String username;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid e-mail address")
        @NotNull
        @Column(length = 50)
	private String email;
	
        @NotNull
        @Temporal(TemporalType.DATE)
	private Date dateofbirth;
	
        @NotNull
        @Column(length = 50)
	private String password;
	
        @NotNull
        @Column(length = 50)
	@Enumerated(EnumType.STRING)
	private Rights rights;
        
	@OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "USER_ID")
	private Collection<MessageEntity> ownMessages;
	
	@ManyToMany(mappedBy = "likedBy")
	private Collection<MessageEntity> likedMessages;

	

        public Userentity()
        {
            
        }
        
	public Userentity(Integer id) {
		this.id = id;
	}

	/**
     *
     * @param id
     * @param username
     * @param email
     * @param dateofbirth
     * @param password
     */
    public Userentity(String username, String email, Date dateofbirth, String password, Rights rights) {
		this.username = username;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.password = password;
		this.rights = rights;
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

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rights getRights() {
		return rights;
	}

	public void setRights(Rights rights) {
		this.rights = rights;
	}

	public Collection<MessageEntity> getOwnMessages() {
		return ownMessages;
	}

	public void setOwnMessages(Collection<MessageEntity> ownMessages) {
		this.ownMessages = ownMessages;
    }
	
	public Collection<MessageEntity> getLikedMessages() {
		return likedMessages;
	}

	public void setLikedMessages(Collection<MessageEntity> likedMessages) {
		this.likedMessages = likedMessages;
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
