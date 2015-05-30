package com.common.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.common.SysConstants;

public class SystemConfigContextListener implements ServletContextListener {
	private static final Log LOG = LogFactory.getLog(SystemConfigContextListener.class);
	
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	public void contextInitialized(ServletContextEvent event) {
		LOG.info(this.getClass().getName() + " contextInitialized.");
		ServletContext context = event.getServletContext();
		
		SysConstants.setWebRootDir(context);
		
	}
	
}
