package com.movingcq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentTime {

	static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/*
	 * 获取String类型当前时间
	 */
	public static String getNow() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
		String currentTime = dateFormat.format(now);
		return currentTime;
	}

	/*
	 * 获取Date类型当前时间
	 */
	public static Date getDateTime() {
		Date date = null;
		Date dt = new Date();
		String now = sdf.format(dt);

		try {
			date = sdf.parse(now);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(date);
		return date;
	}

	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
		String currentTime = dateFormat.format(now);
		System.out.println(currentTime);

	}

}
