package com.common.filter.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import com.common.config.SystemConfig;
import com.common.filter.security.vo.KeyValueObject;

public class SecurityCfg {
	private static HashSet<String> uploadLimits = new HashSet<String>();
	
	private static HashSet<String> ignoreNames = new HashSet<String>();
	private static ArrayList<KeyValueObject> replacer = new ArrayList<KeyValueObject>();
	
	private static String replaceStr;
	
	static {
		loadConfig();
	}
	
	public static void loadConfig() {
		//System.out.println("reloading security configuration." );
		uploadLimits.clear();
		ignoreNames.clear();
		replacer.clear();

		String str = SystemConfig.getSystemConfig().getString("security.fileupload.limits");
		if(str != null && str.length() > 0) {
			String[] arr = str.split(";");
			for(String s : arr) {
				s = s.trim();
				if(s.length() > 0) {
					uploadLimits.add(s.toUpperCase());
				}
			}
		}
		
		str = SystemConfig.getSystemConfig().getString("security.ignore.names");
		if(str != null && str.length() > 0) {
			String[] arr = str.split(",");
			for(String s : arr) {
				s = s.trim();
				if(s.length() > 0) {
					ignoreNames.add(s.toUpperCase());
				}
			}
		}
//		str = PlatformConfig.getPlatformConfig().getString("security.replacer");
		str = SystemConfig.getSystemConfig().getFilterContent();
		if(str != null && str.length() > 0) {
			String[] arr = str.split(";");
			for(String s : arr) {
				s = s.trim();
				int dx = s.indexOf('=');
				if(dx > 0) {
					String s1 = s.substring(0, dx);
					String s2 = s.substring(dx + 1);
					if( s1.trim().length() > 0 ) {
						replacer.add(new KeyValueObject(s1.trim(), s2.trim()));
					}
				}
			}
		}
		
	}
	
	public static boolean ignoreName( String name ) {
		if(name == null)
			return true;
		return ignoreNames.contains(name.toUpperCase());
	}
	
	public static String securityReplace(String str) {
		if(str == null)
			return null;
		
		for (Iterator iterator = replacer.iterator(); iterator.hasNext();) {
			KeyValueObject entry = (KeyValueObject) iterator.next();
			
			getReplaceStr(str, (String)entry.getKey(), (String)entry.getValue());
			
		}
		
		return replaceStr;
	}
	
	private static void getReplaceStr(String str, String key, String value) {
		replaceStr = str.replaceAll(key, value);
		if (replaceStr.contains(key)) {
			getReplaceStr(replaceStr, key, value);
		}
	}
	
	public static void main(String[] args) {
		HashMap<String,String> s = new HashMap<String,String>();
		s.put("note", "< iMg sRc=\"http://127.0.0.1/1.jsp\">");
		s.put("note1", "<iFrAme sRc=\"http://127.0.0.1/1.jsp\">");
		s.put("note2", "aLeRt ( 'avb23 fff ')");
		s.put("note3", "< JavaSCRipt src=\"http://127.0.0.1/1.jsp\">");
		s.put("note4", "</script><ScRipt>window.open('http://10.10.10.10/1.jsp');</script>");
		s.put("note5", "<frmeset><ScRipt>window.open('http://10.10.10.10/1.jsp\");</frmeset>");
		s.put("note6", "<a href=\"http://127.0.0.1/1.jsp\">");
		s.put("note7", "<table>");
		
		for(Map.Entry<String, String> entry : s.entrySet()) {
			if(!ignoreName(entry.getKey()))
				s.put(entry.getKey(), securityReplace(entry.getValue()));
		}
		
		System.out.println(s);
		
	}
	
	public static boolean uploadLimits(String subffix)
	  {
	    if (subffix == null)
	      return false;
	    return (uploadLimits.contains(subffix.toUpperCase()));
	  }
	
}
