/**   
* @Title: VehicleInfoController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月14日 下午5:08:12 
* @version V1.0   
*/
package com.movingcq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.movingcq.entity.QueryParameters;
import com.movingcq.entity.VehicleInfo;
import com.movingcq.service.IVehicleInfoService;
import com.movingcq.util.ApiResult;
import com.movingcq.util.GetCurrentTime;

/**
 * @ClassName: VehicleInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月14日 下午5:08:12
 * 
 */

@Controller
@RequestMapping("/vehicle")
public class VehicleInfoController {

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

	@Autowired
	private IVehicleInfoService vehicleService;

	@ResponseBody
	@RequestMapping("addVehicle")
	public Object addVehicle(VehicleInfo vehicleInfo) {

		vehicleInfo.create_time = GetCurrentTime.getNow();
		isSucc = vehicleService.addVehicleInfo(vehicleInfo);

		if (isSucc == 1) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}

		return rObject;
	}

	@ResponseBody
	@RequestMapping("deleteVehicle")
	public Object deleteVehicle(HttpServletRequest request) {
		String idArr = request.getParameter("ids");

		String[] ids = idArr.split(",");

		isSucc = vehicleService.deleteById(ids);
		if (isSucc > 0) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("updateVehicle")
	public Object updateVehicle(VehicleInfo vehicleInfo) {
		vehicleInfo.update_time = GetCurrentTime.getNow();
		int isSucc = vehicleService.updateById(vehicleInfo);

		if (isSucc > 0) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("listAllVehicle")
	public Map<String, Object> listAllVehicle(QueryParameters qParameters, HttpServletRequest request) {

		PAGE_NOW = qParameters.getPage();
		PAGE_SIZE = qParameters.getRows();
		PAGE_NOW = (PAGE_NOW - 1) * PAGE_SIZE;
		qParameters.setPage(PAGE_NOW);

		// 获取账号总记录数

		List<VehicleInfo> allList = vehicleService.listAllVehicleInfo(qParameters);
		int recordNum = allList.size();

		List<VehicleInfo> userList = vehicleService.selectByPage(qParameters);
		if (userList != null) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", recordNum);
			result.put("rows", userList);
			return result;
		}
		return null;

	}

	@RequestMapping("/info")
	public ModelAndView index(String id, HttpServletRequest request, Model m) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("user2company/vehicleInfo");
		return mv;
	}

}
