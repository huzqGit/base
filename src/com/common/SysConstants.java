package com.common;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysConstants {
	private static final Log LOG = LogFactory.getLog(SysConstants.class);
	
	private static String WEBROOT_DIR = null;
	
	public static String getWebRootDir() {
		if (WEBROOT_DIR == null)
			throw new RuntimeException("没有设置系统WEB根目录");
		return WEBROOT_DIR;
	}

	public static void setWebRootDir(ServletContext context) {
		String root = context.getRealPath("/");
		WEBROOT_DIR = root;
		LOG.info("系统WEB根目录路径为: " + WEBROOT_DIR);
	}

}
