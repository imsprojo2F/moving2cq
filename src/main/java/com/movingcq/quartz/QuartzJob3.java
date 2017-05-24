/**   
* @Title: QuartzJob2.java 
* @Package com.movingcq.quartz 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月21日 下午1:38:16 
* @version V1.0   
*/
package com.movingcq.quartz;

import org.springframework.beans.factory.annotation.Autowired;

import com.movingcq.entity.CarWeigh;
import com.movingcq.service.IDailyReportService;

/**
 * @ClassName: QuartzJob2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月21日 下午1:38:16
 * 
 */
public class QuartzJob3 {

	@Autowired
	private IDailyReportService dailyReportService;

	static CarWeigh carWeigh = new CarWeigh();

	public void execute() {

		System.out.println("------每日凌晨1点轮循任务开始执行------");
		getDailyReport();

	}

	public static void getDailyReport() {

	}

}
