/**   
* @Title: GpsPointInfoController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午11:00:05 
* @version V1.0   
*/
package com.movingcq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movingcq.service.IGpsPointInfoService;

/**
 * @ClassName: GpsPointInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午11:00:05
 * 
 */
@Controller
@RequestMapping("/gpsPointInfo")
public class GpsPointInfoController {

	@Autowired
	private IGpsPointInfoService gpsPointInfoService;

}
