/**
 * 
 */
package com.ttec.advn.prj.support;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

/**
 * @author Ramkumar
 * @copyrights  Code written, Owned, and Licensed by TRIADIC Technologies, Inc
 * @since Jan 4, 2013 
 *
 */
public abstract class AbstractSupportController<T> {

	@Setter @Getter protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractSupportController() {
		Type superType = getClass().getGenericSuperclass();
		if ( superType instanceof Class) {
			// this may happen when proxies are being instantiated by container, like in case of ejbs
			superType = ((Class<?>) superType).getGenericSuperclass();
		}
		ParameterizedType genericSuperclass = (ParameterizedType) superType;
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Setter  private T instance;
	
	public T getInstance() {if (instance == null) {newInstance();}return instance;}

	@SneakyThrows public T newInstance(){return instance = getEntityClass().newInstance();}
}
