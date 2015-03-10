package com.common.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;
import com.common.tools.page.QueryResult;

public interface GenericDAO<T, PK extends Serializable> {

	void save(String value, T entity) throws DAOException, CreateException;

	void update(String value, T entity) throws DAOException, UpdateException,
			DataNotFoundException;

	void delete(String value, T entity) throws DAOException, DeleteException,
			DataNotFoundException;
	
	/**
	 * 查询单个记录
	 * @param value 需要执行的语句名称
	 * @param entity   需要传入的参数对象
	 * @return      Object
	 */
	public T queryObject(String value, T entity) throws DAOException;
	
	/**
	 * 查询列表【用于条件查询】
	 * 
	 * @param value 需要执行的语句名称
	 * @param entity   需要传入的参数对象
	 * @return      List
	 */
	public List queryObjects(String value, T entity) throws DAOException;
	
	/**
	 * 查询列表【用于无条件查询】
	 * 
	 * @param value 需要执行的语句名称
	 * @return      List
	 */
	public List queryObjects(String value) throws DAOException;
}
