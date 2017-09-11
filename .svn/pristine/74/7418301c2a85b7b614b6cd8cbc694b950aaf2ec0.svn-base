/**   
* @Title: GetUID.java 
* @Package com.movingcq.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年5月11日 下午2:44:13 
* @version V1.0   
*/
package com.movingcq.util;

import java.util.UUID;

/**
 * @ClassName: GetUID
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年5月11日 下午2:44:13
 * 
 */
public class GetUID {

	public GetUID() {
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		/*
		 * String temp = str.substring(0, 8) + str.substring(9, 13) +
		 * str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		 */
		return str;
	}

	// 获得指定数量的UUID
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

	public static void main(String[] args) {
		System.err.println(getUUID());
	}

}
