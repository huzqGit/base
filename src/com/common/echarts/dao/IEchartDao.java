package com.common.echarts.dao;

import java.util.List;
import java.util.Map;

public interface IEchartDao {
	
	public List queryForList(String sql) ;

	public List queryForList(String sql, Object[] parameters);

	public Map<String, Object> queryForMap(String sql, Object[] parameters) ;
	
	
	public Map<String, Object> queryForMap(String sql);

}
