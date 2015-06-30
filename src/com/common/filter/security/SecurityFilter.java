package com.common.filter.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.common.filter.security.impl.InvalidateCharIntercepter;
import com.common.filter.security.impl.SQLEncodeIntercepter;
import com.common.filter.security.impl.XSSEncodeInterceptor;
import com.common.filter.security.vo.WebContext;

public  class SecurityFilter implements Filter {
	private static final Log log = LogFactory.getLog(SecurityFilter.class);
	private static final String REQUEST = "request";
	private List<SecurityIntercepter> securityIntercepter = new ArrayList<SecurityIntercepter>();
	
	public void init(FilterConfig config) throws ServletException {
		securityIntercepter.add(new InvalidateCharIntercepter());
		securityIntercepter.add(new SQLEncodeIntercepter());
		securityIntercepter.add(new XSSEncodeInterceptor());
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		if (servletRequest.getCharacterEncoding() == null 
		        || servletRequest.getCharacterEncoding().equals(""))
		    servletRequest.setCharacterEncoding("GBK");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse res = (HttpServletResponse) servletResponse;
		
		WebContext.put(REQUEST, request);
		
		for (SecurityIntercepter intercepter : securityIntercepter) {
			
			intercepter.validate(request, res, chain);
			
		}
		
		chain.doFilter((HttpServletRequest)WebContext.get(REQUEST), res);
	}
	
	public void destroy() {

	}

}
