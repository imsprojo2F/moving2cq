/**   
* @Title: initDBDataController.java 
* @Package com.movingdt.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月25日 下午1:33:26 
* @version V1.0   
*/
package com.movingcq.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movingcq.quartz.QuartzJob;
import com.movingcq.service.ICarDeviceService;
import com.movingcq.service.ICarInfoService;
import com.movingcq.service.ILoadoMeterRecordService;
import com.movingcq.service.IParameterRecordService;
import com.movingcq.service.IRestInfoService;
import com.movingcq.service.IRfidInfoService;

/**
 * @ClassName: initDBDataController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月25日 下午1:33:26
 * 
 */
@RequestMapping("/admin")
@Controller
public class initDBDataController {

	@Autowired
	private IRfidInfoService rfidService;

	@Autowired
	private IRestInfoService restInfoService;

	@Autowired
	private IParameterRecordService parameterRecordService;

	@Autowired
	private ICarInfoService carInfoService;

	@Autowired
	private ICarDeviceService carDeviceService;

	@Autowired
	private ILoadoMeterRecordService loadoMeterRecordService;

	static boolean Result = false;
	static String msg = "失败";
	Map<String, Object> resultMap = new HashMap<String, Object>();

	@RequestMapping("/init")
	@ResponseBody
	public Object initData(Integer type) {

		if (type == 1) {
			// 获取RFID信息------------
			Result = QuartzJob.getRFID(1, rfidService);
		} else if (type == 2) {
			// 获取餐饮企业信息------------
			Result = QuartzJob.getRestInfo(1, restInfoService);
		} else if (type == 3) {
			// 获取参数信息------------
			Result = QuartzJob.getParameter(1, parameterRecordService);
		} else if (type == 4) {
			// 获取车辆信息------------
			Result = QuartzJob.getCarInfo(1, carInfoService);
		} else if (type == 5) {
			// 获取车载设备信息------------
			Result = QuartzJob.getDeviceInfo(1, carDeviceService);
		} else {
			// 获取地磅称重信息------------
			Result = QuartzJob.getloadoInfo(1, loadoMeterRecordService);
		}
		if (Result == true) {
			msg = "成功";
		}
		resultMap.put("isSuccess", Result);
		resultMap.put("msg", msg);

		return resultMap;
	}

	@RequestMapping("/toInit")
	public Object toInit() {
		return "initData";
	}

}
