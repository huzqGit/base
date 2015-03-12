package com.common.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.common.dao.GenericDAO;
import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;
import com.common.service.GenericService;

public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {
	
	/**
	 * 获取数据访问层对象
	 */
	public abstract GenericDAO<T, PK> getGenericDAO();
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={DAOException.class, CreateException.class})
	public void save(T entity) throws DAOException, CreateException {
		this.getGenericDAO().save(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={DAOException.class, UpdateException.class, DataNotFoundException.class})
	public void update(T entity) throws DAOException, UpdateException,
			DataNotFoundException {
		this.getGenericDAO().update(entity);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={DAOException.class, DeleteException.class, DataNotFoundException.class})
	public void delete(PK pk) throws DAOException, DeleteException,
			DataNotFoundException {
		this.getGenericDAO().delete(pk);
	}
	
	public T findByPK(PK pk) throws DAOException, DataNotFoundException {
		return this.getGenericDAO().findByPK(pk);
	}
	
	public List<T> getAllEntities() throws DAOException {
		return this.getGenericDAO().getAllEntities();
	}

}
