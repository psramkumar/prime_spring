package com.ttec.advn.prj.support;

import java.util.List;

import org.hibernate.Session;

/**
 * @author Ramkumar Pillai
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since 01/01/2013 
 */

public abstract interface AbstractSupportDAOIFace<T> {

	public List<T> resultSet();
	
	public void save(final T instance);
	
	public T update(final T instance);
	
	public T merge(final T detachedInstance);

	public void delete(final T instance);

	public T findById(final Integer id);
	
	public List<T> findByField(final String fieldName, final String fieldValue);

	 /**
     * Flushes the changes in the cache to the database and clears the cache. If any stored
     * procedures or native sql code is used, this must be called first.
     */
	public void flushAndClear();

	/**
     * Flushes the changes in the cache to the database.
     * ALWAYS run before a stored procedure!
     */
	public void flush();

	public Session getSession();

}
