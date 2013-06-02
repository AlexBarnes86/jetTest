package com.toastedbits.jettest.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String login;
	private String password;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="UserRoleMap",
		joinColumns = {@JoinColumn(name="fkUser", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="fkRole", referencedColumnName="id")}
	)
	private Set<Role> roles;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
