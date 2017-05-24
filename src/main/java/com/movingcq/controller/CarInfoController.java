/**   
* @Title: CarInfoController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年4月11日 上午10:47:54 
* @version V1.0   
*/
package com.movingcq.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.movingcq.entity.Bucket2RfidInfo;
import com.movingcq.entity.BucketInfo;
import com.movingcq.entity.CarInfo;
import com.movingcq.entity.RfidInfo;
import com.movingcq.service.IBucketInfoService;
import com.movingcq.service.ICarInfoService;
import com.movingcq.service.IRfidInfoService;
import com.movingcq.util.ApiResult;
import com.movingcq.util.GetUID;

/**
 * @ClassName: CarInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年4月11日 上午10:47:54
 * 
 */
@Controller
@RequestMapping("/menu/carInfo")
public class CarInfoController {

	@Autowired
	private ICarInfoService carInfoService;

	private int isSucc = 0;
	Object rObject = null;

	Map<String, Object> qMap = new HashMap<String, Object>();
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
	Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

	@Autowired
	private IBucketInfoService bucketService;
	@Autowired
	private IRfidInfoService rfidService;

	// 验证是否已被使用
	@ResponseBody
	@RequestMapping("validate")
	public Object validate(String validateValue) {

		BucketInfo bucketInfo = null;
		bucketInfo = bucketService.selectByAcc(validateValue);
		if (bucketInfo == null) {
			rObject = new ApiResult("可用", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("不可用", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("addCar")
	public Object addBucket(CarInfo carInfo) {

		carInfo.setId(GetUID.getUUID());
		carInfo.setBeendeleted(0);
		carInfo.setStatus(0);
		carInfo.setCreatetime(new Date());
		carInfo.setLastchangetime(new Date());
		if ("".equals(carInfo.getDriverphone()) || carInfo.getDriverphone() == null) {
			carInfo.setDriverphone("暂未填写");
		}

		isSucc = carInfoService.insertSelective(carInfo);

		if (isSucc == 1) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}

		return rObject;
	}

	@ResponseBody
	@RequestMapping("deleteCar")
	public Object deleteUser(HttpServletRequest request) {

		CarInfo carInfo = new CarInfo();
		String id = request.getParameter("id");
		carInfo.setId(id);
		carInfo.setBeendeleted(1);
		carInfo.setDeletedtime(new Date());

		isSucc = carInfoService.updateByPrimaryKeySelective(carInfo);

		if (isSucc > 0) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("updateCar")
	public Object updateBucket(CarInfo carInfo, HttpSession session) {

		carInfo.setLastchangetime(new Date());
		int isSucc = carInfoService.updateByPrimaryKeySelective(carInfo);

		if (isSucc > 0) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("listAllCar")
	public Map<String, Object> listAllBucket(HttpServletRequest request) {

		List<CarInfo> allList1 = carInfoService.listAllCar(qMap);
		int recordsTotal = allList1.size();

		int pageSize = 10;
		int pageNow = 1;
		String size = request.getParameter("length");
		if (!"".equals(size) && size != null) {
			pageSize = Integer.parseInt(size);
		}
		String currentRecord = request.getParameter("start");
		if (!"".equals(currentRecord) && currentRecord != null) {
			pageNow = Integer.parseInt(currentRecord);
			// pageNow = (pageNow-1)*pageSize;
		}
		// For sortable
		String columnArray[] = { "", "id", "carCode", "carLoad", "driverPhone", "driver", "createTime",
				"lastChangeTime" };
		String sort = request.getParameter("order[0][column]");
		if (!"".equals(sort) && sort != null) {
			int index = Integer.parseInt(sort);
			sort = columnArray[index];
		}
		String dir = request.getParameter("order[0][dir]");

		// For search
		String key = request.getParameter("search[value]");

		qMap.put("key", key);
		qMap.put("sort", sort);
		qMap.put("dir", dir);
		qMap.put("pageNow", pageNow);
		qMap.put("pageSize", pageSize);

		// 获取rfid总记录数

		List<CarInfo> allList2 = carInfoService.listAllCar(qMap);
		int recordsFiltered = allList2.size();

		List<Map<String, Object>> carList = carInfoService.selectByPage(qMap);
		if (carList != null) {
			resultMap.put("draw", request.getParameter("draw"));
			resultMap.put("recordsTotal", recordsTotal);
			resultMap.put("recordsFiltered", recordsFiltered);
			resultMap.put("data", carList);
			return resultMap;
		}
		return null;

	}

	@ResponseBody
	@RequestMapping("getAllBucket")
	public Object getAllBucket() {

		List<Bucket2RfidInfo> allList = bucketService.getAllBucketInfo();

		return allList;
	}

	@ResponseBody
	@RequestMapping("addToSession")
	public Object addToSession(HttpSession session, String bucket_code, String rfid) {
		session.setAttribute(bucket_code, rfid);
		rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		return rObject;
	}

	@RequestMapping("/info")
	public ModelAndView index(String id, HttpServletRequest request, Model m) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> qMap = new HashMap<String, Object>();
		List<RfidInfo> allList = rfidService.listAllRfidInfo(qMap);
		request.setAttribute("rfidList", allList);
		mv.setViewName("user2company/bucketInfo");
		return mv;
	}

}
