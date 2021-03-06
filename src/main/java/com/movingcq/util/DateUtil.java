/**   
* @Title: DateUtil.java 
* @Package com.movingcq.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2017年1月10日 下午1:43:28 
* @version V1.0   
*/
package com.movingcq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2017年1月10日 下午1:43:28
 * 
 */
public class DateUtil {

	public static String string2Date(String date, int i) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -i); // 设置为前一天
		d = calendar.getTime(); // 得到前一天的时间

		String defaultStartDate = sdf.format(d);

		return defaultStartDate;
	}

	public static String getStringDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(d);
		return dateNowStr;

	}

	public static String Mill2Time(long m) {

		Date date = new Date(m);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateStr = sdf.format(date);
		System.out.println("查询时间：" + dateStr + "------");
		return dateStr;
	}

	public static void main(String[] args) throws ParseException {
		Calendar now = Calendar.getInstance();
		System.out.println("年: " + now.get(Calendar.YEAR));
		System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
		System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
		System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
		System.out.println("分: " + now.get(Calendar.MINUTE));
		System.out.println("秒: " + now.get(Calendar.SECOND));
		System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
		System.out.println(now.getTime());

		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		System.out.println("格式化后的日期：" + dateNowStr);

		String str = "2012-1-13 17:26:33"; // 要跟上面sdf定义的格式一样
		Date today = sdf.parse(str);
		System.out.println("字符串转成日期：" + today);
	}
}
