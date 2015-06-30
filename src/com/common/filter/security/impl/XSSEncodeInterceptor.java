package com.common.filter.security.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.filter.security.SecurityIntercepter;
import com.common.filter.security.SecurityRequestWrapper;
import com.common.filter.security.vo.WebContext;

/**
 * XSS跨站脚本攻击.
 */
public class XSSEncodeInterceptor implements SecurityIntercepter {
	private static final String REQUEST = "request";

	public boolean validate(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest secReq = new SecurityRequestWrapper(request);

		WebContext.put(WebContext.REQUEST, secReq);
		WebContext.put(WebContext.RESPONSE, response);

		String type = request.getHeader("Content-Type");
		
		if (request.getMethod().equals("POST")) {
			
			WebContext.put(REQUEST, request);
			
		} else if (type != null && type.startsWith("multipart/form-data")) {
			
			WebContext.put(REQUEST, request);
			
		} else {
			
			WebContext.put(REQUEST, request);
			
		}
		
		return true;
	}

}
