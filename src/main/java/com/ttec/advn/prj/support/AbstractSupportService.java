package com.ttec.advn.prj.support;
/**
 * 
 */


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttec.advn.prj.support.AbstractSupportDAOIFace;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 3, 2013 
 */
@Service
@Transactional
public abstract class AbstractSupportService<T> implements AbstractSupportServiceIFace<T> {

	private AbstractSupportDAOIFace<T> abstractDAO;
	
	private final Logger log = Logger.getLogger(getClass());
	
	public abstract void setDependants();
	
	public void setAbstractDAO(AbstractSupportDAOIFace<T> absDao){
		this.abstractDAO = absDao;
	}
	
	@Override
	public List<T> getResultSet() {
		return abstractDAO.resultSet();
	}
	
	@Override public void save(final T instance){
		abstractDAO.save(instance);
		log.debug(String.format("The Instance of %s Entity,  Successfully Saved ", instance.getClass().getCanonicalName()));
		log.debug(String.format("Domain Information : %s", instance.toString()));
	}
	
	@Override public T update(final T instance){
		log.debug(String.format("Updating Domain Information : %s", instance.toString()));
		return abstractDAO.update(instance);
	}
	
	@Override public void delete(final T instance){
		abstractDAO.delete(instance);
		log.debug(String.format("Successfully Deleted Domain Information : %s", instance.toString()));
	}

	@Override public T findById(final Integer id){
		return abstractDAO.findById(id);
	}
	
}
