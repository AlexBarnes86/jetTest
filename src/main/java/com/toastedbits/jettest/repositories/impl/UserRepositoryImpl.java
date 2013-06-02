package com.toastedbits.jettest.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.toastedbits.jettest.models.User;
import com.toastedbits.jettest.repositories.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from User u where u.login = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0) {
			return userList.get(0);
		}
		else {
			return null;
		}
	}
	
	public void save(User user) {
		openSession().save(user);
	}
}
