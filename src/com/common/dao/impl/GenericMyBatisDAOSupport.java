package com.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

public class GenericMyBatisDAOSupport<T, PK extends Serializable> extends SqlSessionDaoSupport {
	private static Logger log = LoggerFactory.getLogger(GenericMyBatisDAOSupport.class);
	private static final String SQLID_SAVE = "save";
	private static final String SQLID_UPDATE = "update";
	private static final String SQLID_DELETE = "delete";
	private static final String SQLID_FINDBYPK = "findByPk";
	private static final String SQLID_ALL = "all";
	private static final String SQLID_PAGE = "pageing";
	private static final String DESC = "desc";
	private static final String ASC = "asc";
	
	@Resource(name="sqlSessionFactory")    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	/** 实体类 */
	private Class<T> persistentClass;
	
	protected GenericMyBatisDAOSupport() {
	    super();
	    this.persistentClass = (Class<T>)((ParameterizedType) getClass().
	                                       getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
	/**
	 * 添加记录
	 */
	public void save(T entity) throws DAOException, CreateException {
		super.getSqlSession().insert(SQLID_SAVE, entity);
	}
	
	/**
	 * 修改记录
	 */
	public void update(T entity) throws DAOException, UpdateException {
		super.getSqlSession().update(SQLID_UPDATE, entity);
	}
	
	/**
	 * 删除记录	
	 */
	public void delete(PK pk) throws DAOException, DeleteException {
		super.getSqlSession().delete(SQLID_DELETE, pk);
	}
	
	public T findByPK(PK pk) throws DAOException, DataNotFoundException {
		if (pk == null) {
			throw new DataNotFoundException(persistentClass + " pk is null.");
		}
		
		T result = (T) super.getSqlSession().selectOne(SQLID_FINDBYPK, pk);
		
		if (result == null) {
			throw new DataNotFoundException("Load " + persistentClass
					+ " data by PK(" + pk + ") not find.");
		}
		return result;
	}
	
	public List<T> getAllEntities() throws DAOException {
		return super.getSqlSession().selectList(SQLID_ALL);
	}
	
	public List<T> getPageingEntities(String key, int pageIndex, int pageSize,
			String sortField, String sortOrder) throws DAOException {
		int start = pageIndex * pageSize, end = start + pageSize;
		if (DESC.equals(sortOrder) == false) sortOrder = ASC;
		return getSqlSession().selectList(SQLID_PAGE, new Object[]{start, end, sortField, sortOrder});
	}
	
}
