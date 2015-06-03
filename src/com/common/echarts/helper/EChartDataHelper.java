package com.common.echarts.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.common.echarts.dao.IEchartDao;
import com.common.echarts.data.NamedData;
import com.common.echarts.utils.ListUtils;

public final class EChartDataHelper {
	private static IEchartDao echartDao;

	/**
	 * 注意这里SQL需要规范格式 Select columnName from tables; 必须要写明所要查找的字段，否则会获取不到对应的数据
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static List<Object> queryForList(String sql) {
		try {
			List<Object> list = new ArrayList<Object>();
			List<Map<String, Object>> results = echartDao.queryForList(sql);
			if (ListUtils.isNotEmpty(results)) {
				for (Map map : results) {
					list.add(getOnlyOneMapValue(map));
				}
			}
			return list;

		} catch (Exception e) {
			return null;
		}
	}

	public static List<Object> queryForList(String sql, Object[] parameters) {
		try {
			List<Object> list = new ArrayList<Object>();
			List<Map<String, Object>> results = echartDao.queryForList(sql,
					parameters);
			if (ListUtils.isNotEmpty(results)) {
				for (Map map : results) {
					list.add(getOnlyOneMapValue(map));
				}
			}
			return list;

		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static Object[] queryForArray(String sql) {
		try {
			return convertList2Array(queryForList(sql));
		} catch (Exception e) {
			return null;
		}
	}

	public static Object[] queryForArray(String sql, Object[] parameters) {
		try {
			return convertList2Array(queryForList(sql, parameters));

		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	public static Object queryForObject(String sql) {
		try {
			Map<String, Object> results = echartDao.queryForMap(sql);
			return getOnlyOneMapValue(results);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static Object queryForObject(String sql, Object[] parameters) {
		try {
			Map<String, Object> results = echartDao.queryForMap(sql,parameters);
			return getOnlyOneMapValue(results);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	

	public static Object getOnlyOneMapValue(Map map) {
		for (Object obj : map.entrySet()) {
			Entry entry = (Entry) obj;
//			String key = (String) entry.getKey();
			Object value = (Object) entry.getValue();
			return value;
		}
		return null;
	}

	public static NamedData consrtctedNamedData(String sql4Name, List<Object> lst) {
		NamedData namedDta = new NamedData();
		namedDta.setName(sql4Name);
		namedDta.setDataLst(lst);
		return namedDta;
	}

	public static List<NamedData> consrtctedNamedDataList(NamedData... datas) {
		List<NamedData> results = new ArrayList<NamedData>();
		for (NamedData data : datas) {
			results.add(data);
		}
		return results;
	}

	public static Object[] convertList2Array(List<Object> list) {
		final int size = list.size();
		Object[] arr = (Object[]) list.toArray(new Object[size]);
		return arr;

	}

	public static IEchartDao getEchartDao() {
		return echartDao;
	}

	public static void setEchartDao(IEchartDao echartDao) {
		EChartDataHelper.echartDao = echartDao;
	}

	
	

}
