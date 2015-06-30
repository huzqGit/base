package com.common.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.common.SysConstants;

//Platform
public class SystemConfig{
	private static final Log log = LogFactory.getLog(SystemConfig.class);
	private static final String SYS_CONFIG = SysConstants.getWebRootDir() + File.separator + "WEB-INF" +File.separator + "sys-config.xml";
	private static List<Node> entryList;
	private static String filterContent = "";
	private static boolean isLoad = false;
	private static SystemConfig xmlConfig = null;
	static {
		if (!isLoad) {
			try {
				Document doc = new SAXReader().read(SYS_CONFIG);
				entryList = doc.selectNodes("//entry");
				isLoad = true;
				
				initFilterContent(doc);
				
			} catch (DocumentException e) {
				log.error("读取sys-config.xml文件发生异常，请检查文件目录和文件名是否存在！", e);
			}
		}
	}
	
	public String getString(String str) { 
		for (Node n : entryList) {
			if (n.valueOf("@key").equals(str)) {
				return n.valueOf("@value");
			}
		}
		return "";
	}

	public boolean getBoolean(String str) {
		for (Node n : entryList) {
			if (n.valueOf("@key").equals(str)) {
				return Boolean.valueOf(n.valueOf("@value"));
			}
		}
		return false;
	}

	public int getInt(String str) {
		for (Node n : entryList) {
			if (n.valueOf("@key").equals(str)) {
				return Integer.parseInt(n.valueOf("@value"));
			}
		}
		return -1;
	}
	
	public List getList(String key) {
		List result = new ArrayList();
		for (Node n : entryList) {
			if (n.valueOf("@key").equals(key)) {
				result.add(n.valueOf("@value"));
			}
		}
		return result;
	}
	
	private static void initFilterContent(Document doc) {
		List<Node> filterNodes = doc.selectNodes("//input-filter/filter/input");
		if (!filterNodes.isEmpty()) {
			for (Node filterNode : filterNodes) {
				String str = filterNode.getText().replaceAll("\\t|\r|\n", "");
				if (StringUtils.isEmpty(filterContent))
					filterContent = str;
				else
					filterContent = filterContent + ";" + str;
			}
		}
	}
	
	public String getFilterContent() {
		return filterContent;
	}
	
	public static SystemConfig getSystemConfig() {
		return new SystemConfig();
	}
}
