package com.common.tools;

import java.io.IOException;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
	static HashMap transformCharMap = new HashMap();
	static {
		transformCharMap.put("\b", "\\b");
		transformCharMap.put("\f", "\\f");
		transformCharMap.put("\n", "\\n");
		transformCharMap.put("\r", "\\r");
		transformCharMap.put("\t", "\\t");
		transformCharMap.put("\'", "\\\'");
		transformCharMap.put("\"", "\\\"");
		transformCharMap.put("\\", "\\\\");

	}

	private StringUtil() {
	}

	public static final String DEFAULT_DELIM = ";";

	/**
	 * 计算指定字符串中指定字符的个数。
	 * 
	 * @param str
	 * @param placeholder
	 * @return
	 */
	public static int countPlaceholders(String str, char placeholder) {
		int count = 0;

		for (int i = 0; str != null && i < str.length(); i++) {
			if (str.charAt(i) == placeholder)
				count++;
		}
		return count;
	}

	/**
	 * 计算指定字符串中某子串的数目。
	 * 
	 * @param s
	 * @param sub
	 * @return
	 */
	public static int countOccurrencesOf(String s, String sub) {
		if (s == null || sub == null || "".equals(sub))
			return 0;
		int count = 0, pos = 0, idx = 0;
		while ((idx = s.indexOf(sub, pos)) != -1) {
			++count;
			pos = idx + sub.length();
		}
		return count;
	}

	/**
	 * 此方法将给出的字符串source使用delim划分为字符串数组。
	 * 
	 * @param source
	 *            需要进行划分的原字符串
	 * @param delim
	 *            字符串的分隔字符串
	 * @param trimTokens
	 *            去掉每个分隔字符串空格
	 * @param ignoreEmptyTokens
	 *            忽略空的分隔字符串空格
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组， 如果delim为null则使用 ,
	 *         作为分隔字符串。
	 */
	public static String[] tokenize(String source, String delimiters,
		boolean trimTokens, boolean ignoreEmptyTokens) {
		List tokens = new ArrayList();

		if (source == null) {
			return new String[0];
		}
		if (delimiters == null) {
			delimiters = ",";
		}

		StringTokenizer st = new StringTokenizer(source, delimiters);

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!(ignoreEmptyTokens && token.length() == 0)) {
				tokens.add(token);
			}
		}
		return (String[]) tokens.toArray(new String[tokens.size()]);
	}

	/**
	 * 此方法将给出的字符串source使用delim划分为字符串数组。
	 * 
	 * @param source
	 *            需要进行划分的原字符串
	 * @param delim
	 *            字符串的分隔字符串
	 * @param trimTokens
	 *            去掉每个分隔字符串空格
	 * @param ignoreEmptyTokens
	 *            忽略空的分隔字符串空格
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组， 如果delim为null则使用 ,
	 *         作为分隔字符串。
	 */
	public static String[] tokenize1(String source, String delimiters,
		boolean trimTokens, boolean ignoreEmptyTokens) {
		List tokens = new ArrayList();

		if (source == null) {
			return new String[0];
		}
		if (delimiters == null) {
			delimiters = ",";
		}

		StringTokenizer st = new StringTokenizer(source, delimiters, true);
		int i = 0;
		String sPrevToken = "         ";
		String token;
		while (st.hasMoreTokens()) {
			token = st.nextToken();
			if (token.equals(delimiters)) {
				if (i == 0) {
					tokens.add("");
				}
				if (!st.hasMoreTokens()) {
					tokens.add("");
				}
				if (token.equals(sPrevToken)) {
					tokens.add("");
				}

			} else {
				if (trimTokens) {
					token = token.trim();
				}
				if (!(ignoreEmptyTokens && token.length() == 0)) {
					tokens.add(token);
				} else
					tokens.add("");

			}
			sPrevToken = token;
			i++;
		}
		return (String[]) tokens.toArray(new String[tokens.size()]);
	}

	/**
	 * 将字符串数组使用指定的分隔符合并成一个字符串。
	 * 
	 * @param array
	 *            字符串数组
	 * @param delim
	 *            分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return 合并后的字符串
	 */
	public static String combineStringArray(String[] array, String delim) {
		int length = array.length - 1;
		if (delim == null) {
			delim = "";
		}
		StringBuffer result = new StringBuffer(length * 8);
		for (int i = 0; i < length; i++) {
			result.append(array[i]);
			result.append(delim);
		}
		result.append(array[length]);
		return result.toString();
	}

	/**
	 * scans a string and replaces all occurances of a given pattern with a
	 * replacement string. Thus replacePattern("hello world!", "o w", "o/w");
	 * result in "hello/world".
	 */
	public static String replace(String inString, String oldPattern,
		String newPattern) {
		if (inString == null)
			return null;
		if (oldPattern == null || newPattern == null)
			return inString;

		StringBuffer sbuf = new StringBuffer();
		int pos = 0;
		int index = inString.indexOf(oldPattern);
		int patLen = oldPattern.length();
		while (index >= 0) {
			sbuf.append(inString.substring(pos, index));
			sbuf.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}
		sbuf.append(inString.substring(pos));
		return sbuf.toString();
	}

	/**
	 * 删除指定字符串中所有匹配的部分
	 * 
	 * @param inString
	 *            需要删除的原字符串
	 * @param pattern
	 *            需要删除的部分
	 * @return
	 */
	public static String delete(String inString, String pattern) {
		return replace(inString, pattern, "");
	}

	/**
	 * 字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @param caseSensitive
	 *            是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean contains(String[] strings, String string,
		boolean caseSensitive) {
		for (int i = 0; i < strings.length; i++) {
			if (caseSensitive == true) {
				if (strings[i].equals(string)) {
					return true;
				}
			} else {
				if (strings[i].equalsIgnoreCase(string)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 根据转义列表对字符串进行转义。
	 * 
	 * @param source
	 *            待转义的字符串
	 * @param escapeCharMap
	 *            转义列表
	 * @return 转义后的字符串
	 */
	public static String transformCharacter(String source, HashMap escapeCharMap) {
		if (source == null || source.length() == 0)
			return source;
		if (escapeCharMap.size() == 0)
			return source;
		StringBuffer sb = new StringBuffer();
		StringCharacterIterator sci = new StringCharacterIterator(source);
		for (char c = sci.first(); c != StringCharacterIterator.DONE; c = sci
			.next()) {
			String character = String.valueOf(c);
			if (escapeCharMap.containsKey(character))
				character = (String) escapeCharMap.get(character);
			sb.append(character);
		}
		return sb.toString();
	}

	public static String transformCharacter(String source) {

		if (source == null || source.length() == 0)
			return source;
		if (transformCharMap.size() == 0)
			return source;
		StringBuffer sb = new StringBuffer();
		StringCharacterIterator sci = new StringCharacterIterator(source);
		for (char c = sci.first(); c != StringCharacterIterator.DONE; c = sci
			.next()) {
			String character = String.valueOf(c);
			if (transformCharMap.containsKey(character))
				character = (String) transformCharMap.get(character);
			sb.append(character);
		}
		return sb.toString();
	}

	/**
	 * 得到字符串的字节长度 , 中文为一个字 2 字节
	 * 
	 * @param source
	 *            字符串
	 * @return 字符串的字节长度
	 */
	public static int getByteLength(String source) {
		int len = 0;
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			int highByte = c >>> 8;
			len += highByte == 0 ? 1 : 2;
		}
		return len;
	}

	/**
	 * 把字符串数组连接成一个字符串。 默认的连接 ；
	 * 
	 * @param list
	 * @return
	 */
	public static String join(String[] list) {
		return join(list, DEFAULT_DELIM);
	}

	/**
	 * 把字符串数组连接成一个字符串。
	 * 
	 * @param str
	 * @param delim
	 *            指定的连接
	 * @return
	 */
	public static String join(String[] str, String delim) {
		final int length = str.length;
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buf.append(str[i]);
			if (i != length - 1) {
				buf.append(delim);
			}
		}
		return new String(buf);
	}

	/**
	 * MD5的算法在RFC1321 中定义 在RFC 1321中，给出了Test suite用来检验你的实现是否正确： MD5 ("") =
	 * d41d8cd98f00b204e9800998ecf8427e MD5 ("a") =
	 * 0cc175b9c0f1b6a831c399e269772661 MD5 ("abc") =
	 * 900150983cd24fb0d6963f7d28e17f72 MD5 ("message digest") =
	 * f96b697d7cb7938d525a2f31aaf161d0 MD5 ("abcdefghijklmnopqrstuvwxyz") =
	 * c3fcd3d76192e4007dfb496cca67e13b
	 * 
	 * @author haogj
	 * 
	 * 传入参数：明文（字符串） 传出参数：MD5结果字符串
	 */
	public static String getMD5(String originalCode) {
		byte[] source = originalCode.getBytes();

		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest
				.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 判断字符串是否为整形
	 * 
	 * @param str
	 * @return add by dengyu in 2008-6-30
	 */
	public static boolean isNum(String str) {

		Pattern p = Pattern.compile("(-?[0-9]+|[0-9]*)?");
		Matcher m = p.matcher(str.trim());

		return m.matches();
	}

	/**
	 * 截取字符串的前targetCount个字符
	 * 
	 * @param str
	 *            被处理字符串
	 * @param targetCount
	 *            截取长度
	 * @return String
	 */
	public static String subContentStringOrialBytes(String str, int targetCount) {
		return subContentStringOrialBytes(str, targetCount, "...");
	}

	/**
	 * 获取指定长度字符串的字节长
	 * 
	 * @param str
	 *            被处理字符串
	 * @param maxlength
	 *            截取长度
	 * @return String
	 */
	private static long getStringByteLength(String str, int maxlength) {
		if (str == null)
			return 0;
		int tmp_len = maxlength;

		if (str.length() < maxlength)
			tmp_len = str.length();
		else if (str.length() > maxlength * 2)
			tmp_len = maxlength * 2;

		char[] tempchar = str.substring(0, tmp_len).toCharArray();

		int intVariable = 0;
		String s1 = null;
		for (int i = 0; i < tempchar.length && intVariable <= maxlength; i++) {
			s1 = String.valueOf(tempchar[i]);
			intVariable += s1.getBytes().length;
		}
		s1 = null;
		tempchar = null;
		return intVariable;
	}

	/**
	 * 截取指定长度的字符串,基于bytes,即是中文的长度为2,英文为1
	 * 
	 * @param str
	 *            被处理字符串
	 * @param targetCount
	 *            截取长度
	 * @param more
	 *            后缀字符串
	 * @return
	 */
	public static String subContentStringOrialBytes(String str,
		int targetCount, String more) {
		if (str == null)
			return "";
		int initVariable = 0;
		StringBuffer restr = new StringBuffer();
		if (getStringByteLength(str, targetCount) <= targetCount)
			return str;

		String s1 = null;
		byte[] b;
		char[] tempchar = str.toCharArray();
		for (int i = 0; (i < tempchar.length && targetCount > initVariable); i++) {
			s1 = String.valueOf(tempchar[i]);
			b = s1.getBytes();
			initVariable += b.length;
			restr.append(tempchar[i]);
		}

		if (targetCount == initVariable || (targetCount == initVariable - 1)) {
			restr.append(more);
		}
		return restr.toString();
	}
	
	/**
	 * 截取sql,获取所有的tableName
	 * 
	 * @param str
	 *            被处理sql
	 * @return tableName
	 */
	public static String findTableNameBySql(String sql) {
		if(!sql.toUpperCase().contains(" UNION ")){
			int startLocal = sql.toUpperCase().indexOf(" FROM ") + 5;
			if(!sql.toUpperCase().contains(" WHERE "))
		    	sql = sql.substring(startLocal).trim();
			else
				sql = sql.substring(startLocal,sql.toUpperCase().indexOf(" WHERE ")).trim();
			if(sql.contains(",")){
				String sqls[] = sql.split(",");
				String returnSQL="";
				for (String str : sqls) {
					returnSQL += subChildTableName(str);
					returnSQL = returnSQL +",";
				}
				return returnSQL.toUpperCase();
			} else {
				return subChildTableName(sql).toUpperCase();
			}
		} else {
			String[] strs = sql.toUpperCase().split("UNION");
			String sql1 = "";
			for (String string : strs) {
				sql1 += findTableNameBySql(string);
			}
			return sql1;
		}
	}
	
	public static String subChildTableName(String sql){
		sql = sql.trim();
		if(!sql.contains(" ") && !sql.contains(";"))
			return sql;
		else if(!sql.contains(" ") && sql.contains(";"))
			return sql.substring(0,sql.indexOf(";"));
		else if(sql.contains(" "))
			return sql.substring(0,sql.indexOf(" "));
		return "";
	}
	
	/**
	 * Encode a string using Base64 encoding. Used when storing passwords as
	 * cookies.
	 * 
	 * This is weak encoding in that anyone can use the decodeString routine to
	 * reverse the encoding.
	 * 
	 * @param str
	 * @return String
	 * @throws IOException
	 */
	public static String encodeString(String str) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		String encodedStr = new String(encoder.encodeBuffer(str.getBytes()));

		return encodedStr.trim();
	}

	/**
	 * Decode a string using Base64 encoding.
	 * 
	 * @param str
	 * @return String
	 * @throws IOException
	 */
	public static String decodeString(String str) {
		String value = "";
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		try {
			value = new String(dec.decodeBuffer(str));
		} catch (IOException e) {

		}

		return value;
	}

	/**
	 * 字符串是否为空
	 * @param str
	 * @return
	 */
	public static final boolean isBlank(Object str){
		return (str==null || "".equals(str));
	}
	
	
	public static final String normalizePath(String path) {
		String normalized = path;
		if (normalized.indexOf('\\') >= 0) {
			normalized = normalized.replace('\\', '/');
		}

		if (!normalized.startsWith("/")) {
			normalized = "/" + normalized;
		}

		while (true) {
			int index = normalized.indexOf("//");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index)
					+ normalized.substring(index + 1);
		}

		while (true) {
			int index = normalized.indexOf("%20");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index) + " "
					+ normalized.substring(index + 3);
		}

		while (true) {
			int index = normalized.indexOf("/./");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index)
					+ normalized.substring(index + 2);
		}

		while (true) {
			int index = normalized.indexOf("/../");
			if (index < 0)
				break;
			if (index == 0)
				return null;
			int index2 = normalized.lastIndexOf('/', index - 1);
			normalized = normalized.substring(0, index2)
					+ normalized.substring(index + 3);
		}

		return normalized;
	}
	
	public static final String getString(Object obj,String defaultStr){
		if(isBlank(obj)){
			return defaultStr;
		}
		return obj.toString();
	}
	
	/**
     * jdk里的replaceAll等替换子串的方法中必须是正则表达式
     * 该方法用于替换任意子串
     * @param content 执行子串替换的字符串
     * @param expression 被替换掉的子串
     * @param replacement 用来替换的子串
     * @return
     */
    public static String replaceAll(String content, String expression, String replacement){
        if(isBlank(content)){
        	return "";
        }
    	StringBuffer sb = new StringBuffer();
        int begin = 0;
        int end = content.indexOf(expression);
        int len = expression.length();
        while(end >= 0){
            sb.append(content.substring(begin,end));
            sb.append(replacement);
            begin = end + len;
            end = content.indexOf(expression, begin);
        }
        sb.append(content.substring(begin));
        return sb.toString();
    }
    
    public static String replaceAll(String content,Map par,String startS,String endS){
    	StringBuffer result = new StringBuffer();
        StringBuffer strBuffer = new StringBuffer(content);
        int slen = startS.length();
        int elen = endS.length();
        int startindex = 0;
        int endindex = 0;
        
        //取出变量
        do {
            startindex = strBuffer.indexOf(startS, endindex);
            if (startindex >= 0) {
            	String preStr = strBuffer.substring(endindex, startindex);
            	result.append(preStr);
                endindex = strBuffer.indexOf(endS, startindex) + endS.length();
                String str = strBuffer.substring(startindex+slen, endindex-elen);
                if(par.containsKey(str)){
                	result.append(par.get(str));
                }
            }
        }
        while (startindex >= 0);
        
        result.append(strBuffer.substring(endindex));
        return result.toString();
    }
    
    /**
	 * 字符串用分隔符连接
	 * @param parent 
	 * @param child
	 * @param split
	 * @return a,b,c,d,e,f
	 * 2008-6-10
	 */
	public static final String connectBySplit(String parent,String child,String split){
		if(isBlank(parent)){
			parent = child;
		}else{
			parent = parent+split+child;
		}
		return parent;
	}
	
	/**
	 * 得到非空值
	 * @param obj
	 * @return
	 */
	public static final String getNotNullString(Object obj){
		if(obj == null){
			return "";
		}
		return obj.toString();
	}
	
	public static void main(String[] args) {
		String a="a;b;";
		String[] cc=StringUtil.tokenize1(a, ";", true, true);
		System.out.println(cc[2]);
	}
	

	
	/**
	 * 首字母转小写
	 * @author zkongbai
	 * @date 2015年6月7日  下午3:46:14
	 * @version 1.0
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s){
		if(s == null) return "";
    	s=s.trim();
    	if(s.length()<=0) return "";
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    /**
     * 首字母转大写
     * @author zkongbai
     * @date 2015年6月7日  下午3:46:21
     * @version 1.0
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s){
    	if(s == null) return "";
    	s=s.trim();
    	if(s.length()<=0) return "";
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
