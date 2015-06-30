package com.common.filter.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SecurityIntercepter {
	
	public boolean validate(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;
	
}
