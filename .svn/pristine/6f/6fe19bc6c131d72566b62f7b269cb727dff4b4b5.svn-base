/**   
* @Title: TestQuartz.java 
* @Package com.movingcq.quartz 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 下午1:33:34 
* @version V1.0   
*/
package com.movingcq.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: TestQuartz
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 下午1:33:34
 * 
 */
public class TestQuartz {

	public static void main(String[] arg) {
		System.out.println("TestQuartz start.");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-job.xml");
		// 如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
		// context.getBean("taskManager");
		System.out.print("TestQuartz end..");
	}

}
