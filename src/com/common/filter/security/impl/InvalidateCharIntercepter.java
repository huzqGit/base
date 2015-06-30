package com.common.filter.security.impl;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.common.filter.security.SecurityIntercepter;


/**
 * 非法字符.
 *
 */
public class InvalidateCharIntercepter implements SecurityIntercepter {
	private static final Log log = LogFactory.getLog(InvalidateCharIntercepter.class);
	private static Pattern pattern = Pattern.compile("(?i)((select)|(update)|(delete)|(insert)|(drop)|(create)|(order)|(union)|(truncate)|(trim)|(upper)|(lower)|(concat)|(char)|(pad)|(where)|(or)|(and)|(like)|(onclick)|(ondbclick)|(onhelp)|(onkeydown)|(onkeypress)|(onkeyup)|(onmousedown)|(onmousemove)|(onmouseout)|(onmouseover)|(onmouseup)|(alert\\w*))[+\\s%(]");

	public boolean validate(HttpServletRequest request,
			HttpServletResponse servletResponse, FilterChain chain)throws IOException {
		
		if (hasEncodeChar(request) || hasScript(request)) {
			throw new IOException("您发送请求中的参数中含有非法字符. " + request.getRequestURI() + "?" + request.getQueryString());
		}
		
		return true;
	}
	
	private boolean hasEncodeChar(HttpServletRequest req) {
		String str = req.getQueryString();
		if (str == null || str.trim().length()==0)
			return false;
		
		if (req.getRequestURI().endsWith("/servlet/upload") || req.getRequestURI().endsWith("/servlet/fieldfile"))
			return false;
		
//		str = str.replaceAll("%20", "");
		return str.matches(".*%[a-fA-F0-9][a-fA-F0-9].*") || str.matches(".*\\\\(?i)x[a-fA-F0-9][a-fA-F0-9].*") || str.matches(".*(([\\\\|/][.][.])|([.][.][\\\\|/])).*");
	}

	private static boolean hasScript(HttpServletRequest req) {
		String str = req.getQueryString();
		if (str == null || str.trim().length()==0)
			return false;
		
		Pattern pat = Pattern.compile("<[/ ]*(?i)script[ ]*>");  
		Matcher mat = pat.matcher(str);
		if(mat.find())
			return true;
		
		pat = Pattern.compile("(?i)alert[+\\s%(]");  
		mat = pat.matcher(str);
		if(mat.find())
			return true;
		
		pat = Pattern.compile("(?i)cookie[+\\s%(]");  
		mat = pat.matcher(str);
		if(mat.find())
			return true;
		
		pat = Pattern.compile("(?i)javascript");  
		mat = pat.matcher(str);
		if(mat.find())
			return true;
		
		pat = Pattern.compile("<[/ ]*(?i)iframe[ ]*>");  
		mat = pat.matcher(str);
		if(mat.find())
			return true;
		
		pat = Pattern.compile("<[ ]*(?i)img.+(?i)src.+(?i)"); 
		mat = pat.matcher(str);
		if(mat.find())
			return true;
		
		mat = pattern.matcher(str);
		if(mat.find())
			return true;
		
		return false;
	}
}
