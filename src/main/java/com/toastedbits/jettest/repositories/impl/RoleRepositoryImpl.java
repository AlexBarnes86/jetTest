package com.toastedbits.jettest.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toastedbits.jettest.models.Role;
import com.toastedbits.jettest.repositories.RoleRepository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Role getRole(String role) {
		Query query = openSession().createQuery("FROM Role WHERE role = :role");
		query.setString("role", role);
		List<Role> roles = query.list();
		if(roles.size() > 0) {
			return roles.get(0);
		}
		else {
			return null;
		}
	}
	
	public void save(Role role) {
		openSession().save(role);
	}
}
