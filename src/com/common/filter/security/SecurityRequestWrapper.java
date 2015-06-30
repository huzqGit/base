package com.common.filter.security;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 防XSS攻击和SQL注入
 * 
 * @author liuhy
 *
 */
public class SecurityRequestWrapper extends HttpServletRequestWrapper {
	
	private static Logger logger = LoggerFactory.getLogger(SecurityRequestWrapper.class);

	public SecurityRequestWrapper(HttpServletRequest req) throws IOException {
		super(req);
	}

	/**
	 * 重写
	 * @author Administrator
	 */
	public String[] getParameterValues(String name) {
		if(SecurityCfg.ignoreName(name))
			return super.getParameterValues(name);
		
		
		String[] values = super.getParameterValues(xssEncode(name));
		if (values != null) {
			for(int i=0; i<values.length; i++)
				values[i] = xssEncode(values[i]);
		}
		return values;
	}

	/**
	 * 重写
	 * @author Administrator
	 */
	public Map getParameterMap() {
		Map<String, String[]> map = new HashMap<String, String[]>();
		Enumeration iter = super.getParameterNames();
		while (iter.hasMoreElements()) {
			String name = (String) iter.nextElement();
			map.put(name, this.getParameterValues(name));
		}
		return map;
	}
	
	/**
	 * 重写
	 * @author Administrator
	 */
	public String getParameter(String name) {
		if(SecurityCfg.ignoreName(name))
			return super.getParameter(name);
		
		String value = super.getParameter(xssEncode(name));
		if (value != null) {
			value = xssEncode(value);
		}
		return value;
	}
	
	private String xssEncode(String s) {
		if (StringUtils.isEmpty(s) || except()) {
			return s;
		}
		
		String str = SecurityCfg.securityReplace(s);
		if(!s.equals(str))
			logger.info("SQL注入拦截提示，链接[" + getRequestURI() + "]参数被置换，源参数：" + s + ", 目标参数：" + str);
		return str;
	}

	private boolean except() {
		String uri = getRequestURI();
		if(uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".jpg") || uri.endsWith(".png") || uri.endsWith(".gif"))
			return true;
		return false;
	}

}
