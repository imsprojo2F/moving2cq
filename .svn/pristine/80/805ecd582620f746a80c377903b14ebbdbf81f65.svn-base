/**   
* @Title: HttpClientUtil.java 
* @Package com.movingcq.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月20日 上午10:38:50 
* @version V1.0   
*/
package com.movingcq.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: HttpClientUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月20日 上午10:38:50
 * 
 */
public class HttpClientUtil {

	public static String getData(String geturl, String parameter) {

		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(geturl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			JSONObject obj = new JSONObject();

			System.err.println(parameter);
			obj.put("parameter", parameter);
			out.writeBytes(obj.toString());
			out.flush();
			out.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sbf.append(lines);
			}
			reader.close();
			// 断开连接
			connection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbf.toString();
	}

	public static String loadData(String url, String method, String params) {

		int status = testWsdlConnection(url);

		if (status == 404) {
			return "";
		}

		StringBuffer bufferRes = new StringBuffer();
		url = url + "?" + params;
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 请求方式
			conn.setRequestMethod(method);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.connect();
			InputStream in = conn.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String valueString = null;
			while ((valueString = read.readLine()) != null) {
				bufferRes.append(valueString);
			}
			read.close();
			in.close();
			in = null;
			if (conn != null) {
				// 关闭连接
				conn.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bufferRes.toString();
	}

	public static String pullData(String url) {

		HttpURLConnection conn = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			conn = (HttpURLConnection) realUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setUseCaches(false);
			conn.setReadTimeout(8000);
			conn.setConnectTimeout(8000);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
			int code = conn.getResponseCode();
			if (code == 200) {
				InputStream is = conn.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				result = buffer.toString();
			}
		} catch (Exception e) {
		}

		return result;

	}

	public static int testWsdlConnection(String address) {
		int status = 404;
		try {
			URL urlObj = new URL(address);
			HttpURLConnection oc = (HttpURLConnection) urlObj.openConnection();
			oc.setUseCaches(false);
			oc.setConnectTimeout(3000); // 设置超时时间
			status = oc.getResponseCode();// 请求状态
			if (200 == status) {
				// 200是请求地址顺利连通。。
				return status;
			}
		} catch (Exception e) {
			System.err.println("url拒绝连接");
		}
		return status;
	}

	public static void main(String[] args) {

		Date date = new Date();
		long l = date.getTime();
		String geturl = "http://222.92.212.126:32633/vortexrest/api/czcc/data/rfidDataInsert";
		String query = "parameters={\"pageSize\":35" + ",\"pageNo\":" + 1 + "}";

		// System.err.println(getData(geturl, query));
		System.err.println(loadData(geturl, "POST", query));
		// System.err.println(pullData(geturl,query));
	}

}
