package com.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class GenericMyBatisDAOSupport<T, PK extends Serializable> extends SqlSessionDaoSupport {
	@Resource(name="sqlSessionFactory")    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	/**
	 * 添加记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void save(String value,T entity)
	{
		super.getSqlSession().insert(value, entity);
	}
	
	/**
	 * 删除记录	
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void delete(String value, T entity)
	{
		super.getSqlSession().delete(value, entity);
	}
	
	/**
	 * 修改记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 */
	public void update(String value, T entity)
	{
		super.getSqlSession().update(value, entity);
	}
	
	/**
	 * 查询单条记录
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      Object
	 */
	public T queryObject(String value, T entity)
	{
		return super.getSqlSession().selectOne(value, entity);
	}
	
	/**
	 * 查询列表【用于条件查询】
	 * 
	 * @param value 需要执行的语句名称
	 * @param obj   需要传入的参数对象
	 * @return      List
	 */
	public List queryObjects(String value, T entity)
	{
		return super.getSqlSession().selectList(value, entity);
		
	}
	
	/**
	 * 查询列表【用于无条件查询】
	 * 
	 * @param value  需要执行的语句名称
	 * @return       List
	 */
	public List queryObjects(String value)
	{
		return super.getSqlSession().selectList(value);
	}
}
