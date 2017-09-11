/**
 * 
 */
package com.movingcq.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String工具处理类
 *
 */
public class StringUtil {

	private static boolean flag = false;

	/*
	 * @判断字符串是否为空 param:String str return boolean
	 */
	public static boolean isEmpty(String str) {
		if ("".equals(str) || str == null) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static String getStringDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);

		return str;
	}

	// 将GBK字符转化为ISO码
	public static String parseGBK(String sIn) {
		if (sIn == null || sIn.equals(""))
			return sIn;
		try {
			return new String(sIn.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException usex) {
			return sIn;
		}
	}
}
