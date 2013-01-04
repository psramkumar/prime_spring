package com.ttec.advn.prj.support;
/**
 * 
 */


import java.util.List;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 3, 2013 
 */
public abstract interface AbstractSupportServiceIFace<T> {
	
	public List<T> getResultSet();
	
	public void setDependants();
	
	public void save(final T instance);
	
	public T update(final T instance);
	
	public void delete(final T instance);

	public T findById(final Integer id);

}
