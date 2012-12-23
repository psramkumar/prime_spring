package com.ttech.advn.prj.dao;

import java.util.List;

import com.ttech.advn.prj.dao.entity.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public User getUserById(int id) {
		@SuppressWarnings("unchecked")
		List<User> list = sessionFactory
				.getCurrentSession()
				.createQuery("from User where id=?")
				.setParameter(0, id).list();
		return (User)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

}
