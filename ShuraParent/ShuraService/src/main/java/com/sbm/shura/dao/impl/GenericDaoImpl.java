package com.sbm.shura.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.GenericDao;

@Transactional
public class GenericDaoImpl<T> implements GenericDao<T>
{

	/** The entityManager. */
	@PersistenceContext
	protected EntityManager entityManager;

	/** The type. */
	private Class<T> type;

	/**
	 * Instantiates a new generic dao impl.
	 */
	public GenericDaoImpl()
	{
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#create(java.lang.Object)
	 */
	@Override
	public T persist(final T t) throws RespositoryException
	{
		try {
		this.entityManager.persist(t);
		//this.entityManager.refresh(t);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return t;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(long id) throws RespositoryException
	{
		try {
		T objBean = this.entityManager.find(type, id);
		if(objBean != null)
			this.entityManager.remove(objBean);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#find(java.lang.Object)
	 */
	@Override
	public T findById(final Object id) throws RespositoryException
	{
		T result;
		try {
		result = (T) this.entityManager.find(type, id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sbm.muras.daos.GenericDao#update(java.lang.Object)
	 */
	@Override
	public T update(final T t) throws RespositoryException
	{
		T result;
		try {
		result = this.entityManager.merge(t);
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return result;
	}

	

}
