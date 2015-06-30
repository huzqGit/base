package com.common.filter.security.vo;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebContext {

	private static ThreadLocal tl = new ThreadLocal();
	public static final String REQUEST = "request-001";
	public static final String RESPONSE = "response-001";
	public static final String APPLICATION = "application-001";
	
	public static void put(String key, Object value) {
		HashMap map = (HashMap) tl.get();
		if(map == null) {
			map = new HashMap();
			tl.set(map);
		}
		map.put(key, value);
	}
	
	public static Object get(String key) {
		HashMap map = (HashMap) tl.get();
		if(map == null)
			return null;
		return map.get(key);
	}
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) get(REQUEST);
	}
	
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) get(RESPONSE);
	}
	
	public static String getParameter(String key) {
		HttpServletRequest request = getRequest();
		if(request == null)
			return null;
		return request.getParameter(key);
	}
	
	public static String getSysParameter(String key) {
		String keyParam = getParameter("sys_tv_key");
		String valueParam = getParameter("sys_tv_value");
		if(keyParam == null || valueParam == null)
			return null;
		String[] arrKey = keyParam.split(";");
		String[] arrValue = valueParam.split(";");
		for(int i=0; i<arrKey.length; i++)
			if(arrKey[i].equals(key)) 
				return arrValue[i];
		return null;
	}
	
	public static ServletContext getApplication() {
		ServletContext sc = (ServletContext) get(APPLICATION);
		if(sc == null) {
			HttpServletRequest request = getRequest();
			if(request != null) {
				sc = request.getSession().getServletContext();
			}
		}
		return sc;
	}
}