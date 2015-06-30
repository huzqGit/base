package com.common.filter.security.impl;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.common.filter.security.SecurityIntercepter;

/**
 * SQL注入.
 *
 */
public class SQLEncodeIntercepter implements SecurityIntercepter {
	private static final Log log = LogFactory.getLog(SQLEncodeIntercepter.class);
	private static Pattern pattern = Pattern.compile("(?i)((select)|(update)|(delete)|(insert)|(drop)|(create)|(order)|(union)|(truncate)|(trim)|(upper)|(lower)|(concat)|(char)|(pad)|(where)|(or)|(and)|(like)|(onclick)|(ondbclick)|(onhelp)|(onkeydown)|(onkeypress)|(onkeyup)|(onmousedown)|(onmousemove)|(onmouseout)|(onmouseover)|(onmouseup)|(alert\\w*))[+\\s%(]");

	public boolean validate(HttpServletRequest request,
			HttpServletResponse servletResponse, FilterChain chain)throws IOException {
		
		// 获得所有请求参数名
		Enumeration params = request.getParameterNames();
		
		String sql = "";
		while (params.hasMoreElements()) {
			// 得到参数名
			String name = params.nextElement().toString();
			
			// 得到参数对应值
			String[] value = request.getParameterValues(name);
			for (int i = 0; i < value.length; i++) {
				sql = sql + "|" + value[i];
			}
		}

		if (sqlValidate(sql)) {
			throw new IOException("您发送请求中的参数中含有非法字符 : " + sql);
		}
		
		return true;
	}
	
	private static boolean sqlValidate(String str) {
		if (str.indexOf("--") >=0)
			return true;
		
		Matcher mat = pattern.matcher(str);
		if(mat.find())
			return true;
		
		return false;
	  }

}
