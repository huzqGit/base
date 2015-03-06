package com.common.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Title: base modular
 * </p>
 * <p>
 * Description: utilities for properties
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: pouchen group
 * </p>
 * 
 * @author
 * @version
 */
public class PropertiesUtils {
	private static Logger log = LoggerFactory.getLogger(PropertiesUtils.class);
	private final static ClassLoader LOADER;

	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader != null) {
			log.info("classloader is using context class loader");
			LOADER = loader;
		} else {
			log.info("current classloader is using normal class loader");
			LOADER = PropertiesUtils.class.getClassLoader();
		}
	}

	private PropertiesUtils() {
	}

	/**
	 * get properties object by class path
	 * 
	 * @param fileLocation
	 *          String
	 * @return Properties
	 */
	public static Properties getPropertiesFromClassPath(String fileLocation) {
		Properties properties = new Properties();
		URL url = getResource(fileLocation);
		if (url == null) {
			url = getResource(fileLocation);
			if (url == null) {
				String msg = "load properties file from " + fileLocation
						+ ", but not found";
				log.error(msg);
				throw new RuntimeException(msg);
			}
		} else {
			log.info("loaded properties from resource {}: {} ", fileLocation,
					properties);
			try {
				InputStream stream = url.openStream();
				properties.load(stream);
				stream.close();
			} catch (IOException ex) {
				throw new RuntimeException("problem loading properties from "
						+ fileLocation + "!", ex);
			} // end try-catch block
		} // end if-else
		log.info("load properties complete...");
		return properties;
	}

	public static Properties getProperties(String fileLocation, String baseName,
			Locale locale) throws FileNotFoundException, MalformedURLException {
		// get url
		log
				.info(
						"Get the specific resource bundle file...(folder:{}, baseName:{}, locale:{})",
						new Object[] { fileLocation, baseName, locale });
		String baseFile = fileLocation + "/" + baseName + "?.properties";
		log.debug(" + base file:{}", baseFile);
		String filePath = baseFile.replaceAll("\\?", "_" + locale.toString());
		log.debug(" + try get file!({})", filePath);
		URL url = new File(filePath).toURL();
		if (url == null) {
			filePath = baseFile.replaceAll("\\?", "_" + locale.getLanguage());
			log.debug(" + try get file!({})", filePath);
			url = new File(filePath).toURL();
			if (url == null) {
				filePath = baseFile.replaceAll("\\?", "");
				log.debug(" + try get file!({})", filePath);
				url = new File(filePath).toURL();
				if (url == null) {
					throw new FileNotFoundException(
							"The specific resource bundle file not found!(folder:"
									+ fileLocation + ", baseName:" + baseName + ", locale:"
									+ locale + ")");
				}
			}
		}
		// get properties
		Properties properties = new Properties();
		try {
			InputStream stream = url.openStream();
			properties.load(stream);
			stream.close();
		} catch (IOException ex) {
			throw new RuntimeException("problem loading properties from "
					+ fileLocation + "!", ex);
		}
		log.info("load properties complete...");
		return properties;
	}

	public static URL getPropertiesFileURL(String baseName, Locale locale)
			throws FileNotFoundException {
		if (baseName == null) {
			throw new NullPointerException("The specific baseName can't be null!");
		}
		log.info(
				"Get the specific resource bundle file...(baseName: {}, locale:{})",
				baseName, locale);
		String baseFile = baseName + "?.properties";
		log.debug(" + base file:{}", baseFile);
		String filePath = null;
		URL url = null;
		if (locale == null) {
			log.warn("The specific locale is null!");
			filePath = baseFile.replaceAll("\\?", "");
			url = getResource(filePath);
		} else {
			filePath = baseFile.replaceAll("\\?", "_" + locale.toString());
			url = getResource(filePath);
			if (url == null) {
				filePath = baseFile.replaceAll("\\?", "_" + locale.getLanguage());
				url = getResource(filePath);
				if (url == null) {
					filePath = baseFile.replaceAll("\\?", "");
					url = getResource(filePath);
				}
			}
		}
		if (url == null) {
			throw new FileNotFoundException(
					"The specific resource bundle file not found!(baseName:" + baseName
							+ ", locale:" + locale + ")");
		}
		log.info("get file:{}", url);
		return url;
	}

	/**
	 * getResource
	 * 
	 * @param filePath
	 *          String
	 * @return URL
	 */
	public static URL getResource(String filePath) {
		log
				.info("Get the specific resource bundle file....(filePath:{})",
						filePath);
		URL url = LOADER.getResource(filePath);
		if (url == null) {
			log.warn("No resource({}) get by classloader. Try by class.getResource.",
					filePath);
			url = Class.class.getResource(filePath);
		}
		return url;
	}

	/**
	 * getResource
	 * 
	 * @param filePath
	 *          String
	 * @return InputStream
	 */
	public static InputStream getResourceAsStream(String filePath) {
		log
				.info("Get the specific resource bundle file....(filePath:{})",
						filePath);
		return LOADER.getResourceAsStream(filePath);
	}
}
