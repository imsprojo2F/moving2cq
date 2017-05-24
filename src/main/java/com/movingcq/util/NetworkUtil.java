package com.movingcq.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class NetworkUtil {

	public static String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/** 获取网卡所有内网ip */
	public static List<String> getSiteLocalAddress() {
		List<String> ips = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> netInterfaces;
			netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
				Enumeration<InetAddress> niIps = ni.getInetAddresses();
				while (niIps.hasMoreElements()) {
					InetAddress ip = (InetAddress) niIps.nextElement();
					if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
						ips.add(ip.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return ips;
	}

	public static boolean checkIp(String ips) {
		List<String> localIp = NetworkUtil.getSiteLocalAddress();
		for (String ip : localIp) {
			if (ips.contains(ip)) {
				return true;
			}
		}
		return false;
	}
}
