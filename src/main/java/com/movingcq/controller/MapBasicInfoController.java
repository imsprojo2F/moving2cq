/**   
* @Title: MapBasicInfoController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2017年2月20日 上午11:42:33 
* @version V1.0   
*/
package com.movingcq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movingcq.entity.MapBasicInfo;
import com.movingcq.service.IMapBasicInfoService;
import com.movingcq.util.ApiResult;
import com.movingcq.util.GetCurrentTime;

/**
 * @ClassName: MapBasicInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2017年2月20日 上午11:42:33
 * 
 */
@Controller
@RequestMapping("/map")
public class MapBasicInfoController {

	private int isSucc = 0;
	Object rObject = null;

	List<Map<Object, Object>> result = new ArrayList<Map<Object, Object>>();

	Map<String, String> qMap = new HashMap<String, String>();

	MapBasicInfo mapBasicInfo = new MapBasicInfo();

	@Autowired
	private IMapBasicInfoService mapBasicInfoService;

	@RequestMapping("add")
	@ResponseBody
	public Object add(MapBasicInfo mapBasicInfo, Integer order) {

		mapBasicInfo.setCreateTime(GetCurrentTime.getNow());
		mapBasicInfo.setOrderNum(order);
		isSucc = mapBasicInfoService.insertSelective(mapBasicInfo);
		if (isSucc > 0) {
			rObject = new ApiResult("添加成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("添加失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@RequestMapping("update")
	@ResponseBody
	public Object update(MapBasicInfo mapBasicInfo) {

		isSucc = mapBasicInfoService.updateByPrimaryKeySelective(mapBasicInfo);
		if (isSucc > 0) {
			rObject = new ApiResult("更新成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("更新失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@RequestMapping("setRoute")
	@ResponseBody
	public Object setRoute(String car_id, HttpServletRequest request) {
		String lngs = request.getParameter("lngs");
		System.err.println(car_id + "--" + lngs);
		String[] orders = lngs.split(",");
		System.err.println(orders);
		int num = orders.length;
		int succs = 0;
		for (int i = 0; i < num; i++) {
			qMap.put("car_id", car_id);
			qMap.put("order", String.valueOf(i + 1));
			qMap.put("lng", orders[i]);
			isSucc = mapBasicInfoService.updateByLng(qMap);
			if (isSucc > 0) {
				succs++;
			}
		}
		if (succs == num) {
			rObject = new ApiResult("更新成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("更新失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@RequestMapping("updateRoute")
	@ResponseBody
	public Object updateRoute(String car_id) {
		qMap.put("car_id", car_id);
		isSucc = mapBasicInfoService.updateByCarId(qMap);
		if (isSucc > 0) {
			rObject = new ApiResult("更新成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("更新失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@RequestMapping("getStartPoint")
	@ResponseBody
	public Object getStartPoint() {

		result = mapBasicInfoService.getStartPoint(qMap);
		return result;
	}

	@RequestMapping("updateStart")
	@ResponseBody
	public Object updateStart(String lng, String lat) {
		qMap.put("lng", lng);
		qMap.put("lat", lat);
		isSucc = mapBasicInfoService.updateStart(qMap);
		if (isSucc > 0) {
			rObject = new ApiResult("更新成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("更新失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@RequestMapping("selectByKey")
	@ResponseBody
	public Object selectByKey(String car_id) {

		qMap.put("car_id", car_id);
		result = mapBasicInfoService.selectByKey(qMap);
		return result;
	}

	@RequestMapping("getCanSet")
	@ResponseBody
	public Object getCanSet() {
		String ids[] = null;
		// 获取所有已被设置路线的车辆
		result = mapBasicInfoService.getCarId(qMap);
		int num = result.size();
		if (num > 0) {
			ids = new String[num];
			for (int i = 0; i < num; i++) {
				ids[i] = String.valueOf(result.get(i).get("car_id"));
				System.err.println(ids[i]);
			}
		}
		result = mapBasicInfoService.selectByIds(ids);
		return result;
	}

	@RequestMapping("getCanReset")
	@ResponseBody
	public Object getCanReset() {
		String ids[] = null;
		// 获取所有已被设置路线的车辆
		result = mapBasicInfoService.getCarId(qMap);
		int num = result.size();
		if (num > 0) {
			ids = new String[num];
			for (int i = 0; i < num; i++) {
				ids[i] = String.valueOf(result.get(i).get("car_id"));
				System.err.println(ids[i]);
			}
		}
		result = mapBasicInfoService.selectByCarIds(ids);
		return result;
	}

	@RequestMapping("toMap")
	public String toMap(HttpServletRequest request) {
		String to = "mapInfo";
		result = mapBasicInfoService.getStartPoint(qMap);
		if (result.size() < 1) {
			to = "startPoint";
		}
		return to;
	}

}
