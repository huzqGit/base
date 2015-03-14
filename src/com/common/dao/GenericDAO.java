package com.common.dao;

import java.io.Serializable;
import java.util.List;

import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

public interface GenericDAO<T, PK extends Serializable> {

	void save(T entity) throws DAOException, CreateException;

	void update(T entity) throws DAOException, UpdateException,
			DataNotFoundException;

	void delete(PK pk) throws DAOException, DeleteException,
			DataNotFoundException;
	
	T findByPK(PK pk) throws DAOException, DataNotFoundException;
	
	List<T> getAllEntities() throws DAOException;
	
	List<T> getPageingEntities(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder) throws DAOException;
	
}
