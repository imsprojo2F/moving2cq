package com.movingcq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 化验频率处理类
 *
 */
public class AssayFreqUtil {

	private static SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	/**
	 * 化验频率：一天两次 每天9:00到20:59:59 21:00到次日8:59:59
	 * 
	 * @return
	 */
	public static Map<String, String> twice1day(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		Map<String, String> result = new HashMap<String, String>();
		if (hour < 9) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			calendar.set(Calendar.HOUR_OF_DAY, 21);
		} else if (hour >= 9 && hour < 21) {
			calendar.set(Calendar.HOUR_OF_DAY, 9);
		} else {
			calendar.set(Calendar.HOUR_OF_DAY, 21);
		}
		calendar.set(Calendar.MINUTE, 0);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：一天两次 每天0:00到18:00，18:00到0:00
	 * 
	 * @return
	 */
	public static Map<String, String> twice1day1(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		Map<String, String> result = new HashMap<String, String>();
		if (hour >= 18) {
			calendar.set(Calendar.HOUR_OF_DAY, 18);
		} else {
			calendar.set(Calendar.HOUR_OF_DAY, 0);
		}
		calendar.set(Calendar.MINUTE, 0);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：一天一次 每天9:00:00到次日8:59:59
	 * 
	 * @return
	 */
	public static Map<String, String> once1day(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		Map<String, String> result = new HashMap<String, String>();
		if (hour < 9) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		} 
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：一天一次 每天21:00:00到次日20:59:59
	 * 
	 * @return
	 */
	public static Map<String, String> once1day1(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		Map<String, String> result = new HashMap<String, String>();
		if (hour < 21) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 21);
		calendar.set(Calendar.MINUTE, 0);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：一周一次 每周二9:00-到下周二8:59:59
	 * 
	 * @return
	 */
	public static Map<String, String> once1week(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		Map<String, String> result = new HashMap<String, String>();
		if (week < 2) {
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		} else if (week == 2) {
			if (hour < 9) {
				calendar.add(Calendar.WEEK_OF_YEAR, -1);
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			} else {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			}
		} else {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：一周两次 每周二、五9:00为区间
	 * 
	 * @return
	 */
	public static Map<String, String> twice1week(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		Map<String, String> result = new HashMap<String, String>();
		if (week < 2) {
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		} else if (week == 2) {
			if (hour < 9) {
				calendar.add(Calendar.WEEK_OF_YEAR, -1);
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			} else {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			}
		} else if (week < 5) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		} else if (week == 5) {
			if (hour < 9) {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			} else {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			}
		} else {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：每周一、三、五9:00为区间
	 * 
	 * @return
	 */
	public static Map<String, String> thrice1week(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		Map<String, String> result = new HashMap<String, String>();
		if (week < 1) {
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		} else if (week == 1) {
			if (hour < 9) {
				calendar.add(Calendar.WEEK_OF_YEAR, -1);
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			} else {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			}
		} else if (week < 3) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		} else if (week == 3) {
			if (hour < 9) {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			} else {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			}
		} else if (week < 5) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		} else if (week == 5) {
			if (hour < 9) {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			} else {
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			}
		} else {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		}
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：两周一次 每月1日至15日
	 * 
	 * @return
	 */
	public static Map<String, String> once2weeks(Date date) {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		Map<String, String> result = new HashMap<String, String>();
		if (day > 15) {
			calendar.set(Calendar.DAY_OF_MONTH, 16);
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, 1);
		}
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：一月两次 每月1日至15日
	 * 
	 * @return
	 */
	public static Map<String, String> twice1month(Date date) {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		Map<String, String> result = new HashMap<String, String>();
		if (day > 15) {
			calendar.set(Calendar.DAY_OF_MONTH, 16);
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, 1);
		}
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	/**
	 * 化验频率：一月一次 每月1日至月末
	 * 
	 * @return
	 */
	public static Map<String, String> once1month(Date date) {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Map<String, String> result = new HashMap<String, String>();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		result.put("startTime", dateFm.format(calendar.getTime()));
		return result;
	}

	public static String getStartTime(int freq) {
		Date dt = new Date();
		Map<String, String> result = new HashMap<String, String>();
		switch (freq) {
		case 1:
			result = once2weeks(dt);
			break;
		case 2:
			result = once1day(dt);
			break;
		case 3:
			result = once1day1(dt);
			break;
		case 4:
			result = once1month(dt);
			break;
		case 5:
			result = once1week(dt);
			break;
		case 6:
			result = twice1day1(dt);
			break;
		case 7:
			result = twice1day(dt);
			break;
		case 8:
			result = twice1month(dt);
			break;
		case 9:
			result = twice1week(dt);
			break;
		case 10:
			result = thrice1week(dt);
			break;
		default:
			return "";
		}
		return result.get("startTime");
	}

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date dt = dateFm.parse("2016-08-11 23:23");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		calendar.set(Calendar.HOUR_OF_DAY, 22);
		System.out.println(dateFm.format(calendar.getTime()));

		System.out.println("一天两次 每天9:00到20:59:59 21:00到次日8:59:59");
		dt = dateFm.parse("2016-08-11 8:59");
		System.out.println(JSON.toJSONString(twice1day(dt)));
		dt = dateFm.parse("2016-08-11 20:59");
		System.out.println(JSON.toJSONString(twice1day(dt)));
		dt = dateFm.parse("2016-08-12 00:01");
		System.out.println(JSON.toJSONString(twice1day(dt)));

		System.out.println("一天两次 每天0:00到18:00，18:00到0:00");
		dt = dateFm.parse("2016-08-11 17:59");
		System.out.println(JSON.toJSONString(twice1day1(dt)));
		dt = dateFm.parse("2016-08-11 18:00");
		System.out.println(JSON.toJSONString(twice1day1(dt)));
		dt = dateFm.parse("2016-08-11 23:59");
		System.out.println(JSON.toJSONString(twice1day1(dt)));
		dt = dateFm.parse("2016-08-12 00:00");
		System.out.println(JSON.toJSONString(twice1day1(dt)));

		System.out.println("一天一次 每天9:00:00到次日8:59:59");
		dt = dateFm.parse("2016-08-11 8:59");
		System.out.println(JSON.toJSONString(once1day(dt)));
		dt = dateFm.parse("2016-08-11 9:00");
		System.out.println(JSON.toJSONString(once1day(dt)));
		dt = dateFm.parse("2016-08-11 9:01");
		System.out.println(JSON.toJSONString(once1day(dt)));

		System.out.println("一天一次 每天21:00:00到次日20:59:59");
		dt = dateFm.parse("2016-08-11 8:59");
		System.out.println(JSON.toJSONString(once1day1(dt)));
		dt = dateFm.parse("2016-08-11 21:00");
		System.out.println(JSON.toJSONString(once1day1(dt)));
		dt = dateFm.parse("2016-08-11 23:01");
		System.out.println(JSON.toJSONString(once1day1(dt)));

		System.out.println("一周一次 每周二9:00-到下周二8:59:59");
		dt = dateFm.parse("2016-09-6 8:59");
		System.out.println(JSON.toJSONString(once1week(dt)));
		dt = dateFm.parse("2016-09-6 9:01");
		System.out.println(JSON.toJSONString(once1week(dt)));
		dt = dateFm.parse("2016-09-4 9:01");
		System.out.println(JSON.toJSONString(once1week(dt)));
		dt = dateFm.parse("2016-09-10 9:01");
		System.out.println(JSON.toJSONString(once1week(dt)));
		dt = dateFm.parse("2016-09-11 9:01");
		System.out.println(JSON.toJSONString(once1week(dt)));

		System.out.println("一周两次 每周二、五9:00为区间");
		dt = dateFm.parse("2016-09-4 8:59");
		System.out.println(JSON.toJSONString(twice1week(dt)));
		dt = dateFm.parse("2016-09-6 8:59");
		System.out.println(JSON.toJSONString(twice1week(dt)));
		dt = dateFm.parse("2016-09-6 9:01");
		System.out.println(JSON.toJSONString(twice1week(dt)));
		dt = dateFm.parse("2016-09-9 8:59");
		System.out.println(JSON.toJSONString(twice1week(dt)));
		dt = dateFm.parse("2016-09-9 9:01");
		System.out.println(JSON.toJSONString(twice1week(dt)));
		dt = dateFm.parse("2016-09-10 9:01");
		System.out.println(JSON.toJSONString(twice1week(dt)));

		System.out.println("一周三次 每周一、三、五9:00为区间");
		dt = dateFm.parse("2016-09-4 8:59");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-5 8:59");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-5 9:01");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-6 9:01");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-7 8:59");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-7 9:01");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-8 9:01");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-9 8:59");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-9 9:01");
		System.out.println(JSON.toJSONString(thrice1week(dt)));
		dt = dateFm.parse("2016-09-10 9:01");
		System.out.println(JSON.toJSONString(thrice1week(dt)));

		System.out.println("两周一次 每月1日至15日");
		dt = dateFm.parse("2016-08-11 23:23");
		System.out.println(JSON.toJSONString(once2weeks(dt)));
		dt = dateFm.parse("2016-08-16 23:23");
		System.out.println(JSON.toJSONString(once2weeks(dt)));

		System.out.println("每月两次 每月1日至15日");
		dt = dateFm.parse("2016-08-11 23:23");
		System.out.println(JSON.toJSONString(twice1month(dt)));
		dt = dateFm.parse("2016-08-16 23:23");
		System.out.println(JSON.toJSONString(twice1month(dt)));

		System.out.println("每月一次 每月1日至月末");
		dt = dateFm.parse("2016-08-16 23:23");
		System.out.println(JSON.toJSONString(once1month(dt)));

		dt = dateFm.parse("2016-09-4 23:23");
		calendar.setTime(dt);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(dateFm.format(calendar.getTime()));

		calendar.roll(Calendar.DAY_OF_MONTH, -1);
		System.out.println(dateFm.format(calendar.getTime()));
	}
}
