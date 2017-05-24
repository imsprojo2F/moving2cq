/**   
* @Title: DailyReportController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年5月17日 下午1:17:01 
* @version V1.0   
*/
package com.movingcq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movingcq.service.IDailyReportService;

/**
 * @ClassName: DailyReportController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年5月17日 下午1:17:01
 * 
 */
@RequestMapping("/dailyReport")
public class DailyReportController {

	@Autowired
	private IDailyReportService dailyReportService;

}
