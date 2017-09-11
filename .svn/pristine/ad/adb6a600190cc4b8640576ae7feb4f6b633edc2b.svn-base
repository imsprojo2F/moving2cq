package com.movingcq.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class ICTKTokenUtil {

	private static byte[] key128Base64 = Base64.decodeBase64("zjiP4IWhjKSJK0KPMByGKw==");

	public static String encode(String userId, String account, Long timestamp) throws UnsupportedEncodingException {
		String v = userId + "|" + account + "|" + timestamp;
		byte[] bytes = CryptUtil.encryptAES(v.getBytes(), key128Base64);
		String encStr = Base58.encode(bytes);

		return encStr;
	}

	public static String decode(String encStr) throws UnsupportedEncodingException {
		byte[] v = Base58.decode(encStr);
		byte[] bytes = CryptUtil.decryptAES(v, key128Base64);
		return new String(bytes);
	}

}
