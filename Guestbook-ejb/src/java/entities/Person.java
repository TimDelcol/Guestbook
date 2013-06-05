/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
	@NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
	@NamedQuery(name = "Person.findByAddress", query = "SELECT p FROM Person p WHERE p.address = :address"),
	@NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name")})
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id;
	@Size(max = 255)
        @Column(name = "ADDRESS")
	private String address;
	@Size(max = 255)
        @Column(name = "NAME")
	private String name;

	public Person() {
	}

	public Person(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		if (!(object instanceof Person)) {
			return false;
		}
		Person other = (Person) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.Person[ id=" + id + " ]";
	}
	
}
