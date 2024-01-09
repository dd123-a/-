package com.ping.homeschool.util;


public class StringTools {

	public static boolean isNullOrEmpty(String str) {
		return null == str || "".equals(str) || "null".equals(str);
	}

	public static boolean isNullOrEmpty(Object obj) {
		return null == obj || "".equals(obj);
	}

	/**
	 * 去除首尾指定字符
	 * @param str 字符串
	 * @param element 指定字符
	 */
	public static String trim(String str, String element){
		if (str == null || str.equals("")) return str;
		boolean beginIndexFlag = true;
		boolean endIndexFlag = true;
		do{
			int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
			int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
			str = str.substring(beginIndex, endIndex);
			beginIndexFlag = (str.indexOf(element) == 0);
			endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
		} while (beginIndexFlag || endIndexFlag);
		return str;
	}
}
