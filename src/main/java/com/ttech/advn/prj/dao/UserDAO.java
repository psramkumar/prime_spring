package com.ttech.advn.prj.dao;

import java.util.List;

import com.ttech.advn.prj.dao.entity.User;

import org.hibernate.SessionFactory;

public class UserDAO implements IUserDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	@Override
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	@Override
	public User getUserById(int id) {
		@SuppressWarnings("unchecked")
		List<User> list = getSessionFactory()
				.getCurrentSession()
				.createQuery("from User where id=?")
				.setParameter(0, id).list();
		return (User)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return getSessionFactory().getCurrentSession().createQuery("from User").list();
	}

}
