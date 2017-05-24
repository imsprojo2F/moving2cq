/**   
* @Title: DriverInfoController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月14日 下午5:08:12 
* @version V1.0   
*/
package com.movingcq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.movingcq.entity.DriverInfo;
import com.movingcq.service.IDriverInfoService;
import com.movingcq.util.ApiResult;
import com.movingcq.util.GetCurrentTime;

/**
 * @ClassName: DriverInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月14日 下午5:08:12
 * 
 */

@Controller
@RequestMapping("/menu/driver")
public class DriverInfoController {

	public static int PAGE_NOW;
	public static int PAGE_SIZE;

	private int isSucc = 0;
	boolean isTrue = false;
	String key = "";
	String sortKey = "";
	String sortType = "";
	String spageNow = "";
	String spageSize = "";
	Object rObject = null;

	Map<String, Object> qMap = new HashMap<String, Object>();
	List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
	Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

	@Autowired
	private IDriverInfoService driverService;

	@ResponseBody
	@RequestMapping("addDriver")
	public Object addDriver(DriverInfo driverInfo) {

		driverInfo.create_time = GetCurrentTime.getNow();
		isSucc = driverService.addDriverInfo(driverInfo);

		if (isSucc == 1) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}

		return rObject;
	}

	@ResponseBody
	@RequestMapping("deleteDriver")
	public Object deleteDriver(HttpServletRequest request) {
		String idArr = request.getParameter("ids");

		String[] ids = idArr.split(",");

		isSucc = driverService.deleteById(ids);
		if (isSucc > 0) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("updateDriver")
	public Object updateDriver(DriverInfo driverInfo) {
		driverInfo.update_time = GetCurrentTime.getNow();
		int isSucc = driverService.updateById(driverInfo);

		if (isSucc > 0) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("updateByCode")
	public Object updateByCode(DriverInfo driverInfo) {
		driverInfo.update_time = GetCurrentTime.getNow();
		int isSucc = driverService.updateByCode(driverInfo);

		if (isSucc > 0) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("listAllDriver")
	public Map<String, Object> listAllDriver(HttpServletRequest request) {

		List<DriverInfo> allList1 = driverService.listAllDriverInfo(qMap);
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
		String columnArray[] = { "", "id", "bucket_code", "rfid", "bucket_mode", "volume", "is_binding", "create_time",
				"update_time" };
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

		// 获取账号总记录数

		List<DriverInfo> allList = driverService.listAllDriverInfo(qMap);
		int recordsFiltered = allList.size();

		List<Map<String, String>> driverList = driverService.selectByPage(qMap);
		if (driverList != null) {
			resultMap.put("draw", request.getParameter("draw"));
			resultMap.put("recordsTotal", recordsTotal);
			resultMap.put("recordsFiltered", recordsFiltered);
			resultMap.put("data", driverList);
			return resultMap;
		}
		return null;

	}

	@RequestMapping("/info")
	public ModelAndView index(String id, HttpServletRequest request, Model m) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("user2company/driverInfo");
		return mv;
	}

}
