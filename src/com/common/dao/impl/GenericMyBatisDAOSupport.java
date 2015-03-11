package com.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.common.exception.CreateException;
import com.common.exception.DAOException;
import com.common.exception.DataNotFoundException;
import com.common.exception.DeleteException;
import com.common.exception.UpdateException;

public class GenericMyBatisDAOSupport<T, PK extends Serializable> extends SqlSessionDaoSupport {
	
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
		super.getSqlSession().insert(getClassName(entity) + ".save", entity);
	}
	
	/**
	 * 修改记录
	 */
	public void update(T entity) throws DAOException, UpdateException {
		super.getSqlSession().update(getClassName(entity) + ".update", entity);
	}
	
	/**
	 * 删除记录	
	 */
	public void delete(T entity) throws DAOException, DeleteException {
		super.getSqlSession().delete(getClassName(entity)  + ".delete", entity);
	}
	
	public T findByPK(PK pk) throws DAOException, DataNotFoundException {
		if (pk == null) {
			throw new DataNotFoundException(persistentClass + " pk is null.");
		}
		
		T result = (T) super.getSqlSession().selectOne("findByPK", pk);
		
		if (result == null) {
			throw new DataNotFoundException("Load " + persistentClass
					+ " data by PK(" + pk + ") not find.");
		}
		return result;
	}
	
	public List<T> getAllEntities() throws DAOException {
		return super.getSqlSession().selectList("all");
	}
	
	private String getClassName(T entity) {
		if (entity == null) return "";
		return entity.getClass().getSimpleName().toLowerCase();
	}
	
}
