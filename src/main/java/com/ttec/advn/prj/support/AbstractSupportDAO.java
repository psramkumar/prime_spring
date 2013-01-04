/**
 * 
 */
package com.ttec.advn.prj.support;

import java.util.List;

import lombok.Setter;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ramkumar Pillai
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since 01/01/2013 
 */

public abstract class AbstractSupportDAO<T> implements AbstractSupportDAOIFace<T> {

	protected final Logger log = Logger.getLogger(getClass());
	
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractSupportDAO() {
		this.entityClass = (Class<T>) getClass();
	}
	
	@SuppressWarnings("unchecked")
	public AbstractSupportDAO(final String entityName){
		try {
			this.entityClass = (Class<T>) Class.forName(entityName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public AbstractSupportDAO(final Class<T> entityClass){
		this.entityClass = entityClass;
	}

	@Autowired @Setter SessionFactory sessionFactory;
	
	
	@Override @SuppressWarnings("unchecked")
	public List<T> resultSet() {
		log.debug("About to find all instance for " + entityClass);
		try {
			return getSession().createCriteria(entityClass).list();
		} catch (final RuntimeException re) {
			log.error("Failed to find all instance for " + entityClass, re);
			throw re;
		}
	}

	@Override
	public void save(final T instance) {
		log.debug("About to save object of type " + entityClass);
		try {
			getSession().save(instance);
			log.debug("Saved");
		} catch (final RuntimeException re) {
			log.error("Failed to save object of type " + entityClass, re);
			throw re;
		}
	}

	@Override
	public T update(final T instance) {
		log.debug("Updating instance of type " + entityClass);
		return merge(instance);
	}
	
	@Override @SuppressWarnings("unchecked")
	public T merge(final T detachedInstance) {
		log.debug("Merging instance of type " + entityClass);
		try {
			return (T) getSession().merge(detachedInstance);
		} catch (final RuntimeException re) {
			log.error("Merge of instance type " + entityClass + " failed", re);
			throw re;
		}
	}

	@Override
	public void delete(final T instance) {
		log.debug("About to delete instance of " + entityClass);
		try {
			getSession().delete(instance);
			log.debug("Delete successful");
		} catch (final RuntimeException re) {
			log.error("Failed to delete instance of " + entityClass, re);
			throw re;
		}
	}

	@Override
	public T findById(final Integer id) {
		log.debug(String.format("About to find instance of %s with id: %s", entityClass, id));
		try {
			Object obj = getSession().get(entityClass, id);
			if (obj == null)
				return null;
			@SuppressWarnings("unchecked")
			final T result = (T) getSession().get(entityClass, id);
			log.debug("Retired by Id  succesfully");
			return result;
		} catch (final RuntimeException re) {
			log.error(String.format("Failed to find instance of %s  with id: %s", entityClass, id), re);
			throw re;
		}
	}

	
	@Override @SuppressWarnings("unchecked")
	public List<T> findByField(String fieldName, String fieldValue) {
		log.debug(String.format("About to find instance for %s with field Name : %s  and Value : %s", entityClass, fieldName, fieldValue));
		try {
			return getSession().createCriteria(entityClass).add(Restrictions.eq(fieldName, fieldValue)).list();
		} catch (final RuntimeException re) {
			log.error(String.format("Failed to find instance for %s with field Name : %s  and Value : %s", entityClass, fieldName, fieldValue), re);
			throw re;
		}
	}

	@Override
	public void flushAndClear() {
		try {
			flush();
			this.getSession().clear();
		} catch (final RuntimeException re) {
			log.error("Failed to flush and clear the cache", re);
			throw re;
		}
	}

	@Override
	public void flush() {
		try {
			this.getSession().flush();
		} catch (final RuntimeException re) {
			log.error("Failed to flush the cache", re);
			throw re;
		}
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
