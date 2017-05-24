package com.movingcq.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSPReplace {

	public static void main(String[] args) {
		String mode = "zlc";
		String filePath = "D:\\movingdt\\source code\\webserver\\movingdt\\src\\main\\webapp\\includes\\nj\\menu_" + mode
				+ ".jsp";
		String newStr = mode + "_";
		String regex = mode + "_\\d+";
		BufferedReader reader = null;
		StringBuffer buf = new StringBuffer();
		BufferedWriter bw = null;
		Pattern p = Pattern.compile(regex);
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				Matcher m = p.matcher(line); // 获取 matcher 对象
				if (m.find()) {
					buf.append(line.replaceAll(regex, newStr + i));
					i++;
				} else {
					buf.append(line);
				}
				buf.append(System.getProperty("line.separator"));
			}
			System.out.println(buf.toString());
			reader.close();
			bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(buf.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
