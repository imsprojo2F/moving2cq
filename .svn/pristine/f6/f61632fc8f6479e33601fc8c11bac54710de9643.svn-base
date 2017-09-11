/**   
* @Title: ToReturnJSON.java 
* @Package com.movingdt.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年9月6日 上午9:26:35 
* @version V1.0   
*/
package com.movingcq.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: ToReturnJSON 
* @Description: 用于增删改返回json状态码(这里用一句话描述这个类的作用) 
* @author IsProjo
* @date 2016年9月6日 上午9:26:35 
*  
*/
public class ToReturnJSON {
	static boolean isSucc = false;
	public static void toReturnJSON(boolean isSucc,HttpServletResponse response){
			response.setContentType("text/Xml;charset=gbk");  
	        PrintWriter out = null;
	        try {  
	            out = response.getWriter();
	            String json="{\"result\":"+isSucc+"}";
	            out.println(json);        
	        }  
	        catch (IOException ex1) {  
	            ex1.printStackTrace();  
	        }finally{  
	            out.close();  
	        }
		}
}
