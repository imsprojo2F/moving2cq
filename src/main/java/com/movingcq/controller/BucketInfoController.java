/**   
* @Title: BucketInfoController.java 
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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.movingcq.entity.Bucket2RfidInfo;
import com.movingcq.entity.BucketInfo;
import com.movingcq.entity.RfidInfo;
import com.movingcq.service.IBucketInfoService;
import com.movingcq.service.IRfidInfoService;
import com.movingcq.util.ApiResult;
import com.movingcq.util.GetCurrentTime;

/**
 * @ClassName: BucketInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月14日 下午5:08:12
 * 
 */

@Controller
@RequestMapping("/menu/bucket")
public class BucketInfoController {

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
	@RequestMapping("addBucket")
	public Object addBucket(BucketInfo bucketInfo) {

		bucketInfo.create_time = GetCurrentTime.getNow();
		bucketInfo.update_time = GetCurrentTime.getNow();
		if ("".equals(bucketInfo.bucket_mode) || bucketInfo.bucket_mode == null) {
			bucketInfo.bucket_mode = "暂未填写";
		}
		if ("".equals(bucketInfo.volume) || bucketInfo.volume == null) {
			bucketInfo.volume = 0.0;
		}
		isSucc = bucketService.addBucketInfo(bucketInfo);

		// 更新rfid为被使用

		// rfidService.updateByRfid(1, bucketInfo.rfid);

		if (isSucc == 1) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}

		return rObject;
	}

	@ResponseBody
	@RequestMapping("deleteBucket")
	public Object deleteUser(HttpServletRequest request) {
		String idArr = request.getParameter("ids");
		// String rfidArr = request.getParameter("rfids");
		String[] ids = idArr.split(",");
		// String[] rfids = rfidArr.split(",");
		isSucc = bucketService.deleteById(ids);
		// 更新rfid为未被使用
		// rfidService.updateByIds(rfids);
		if (isSucc > 0) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("updateBucket")
	public Object updateBucket(BucketInfo bucketInfo, HttpSession session) {

		bucketInfo.update_time = GetCurrentTime.getNow();
		int isSucc = bucketService.updateById(bucketInfo);

		/*
		 * String oldRfid = (String)
		 * session.getAttribute(bucketInfo.bucket_code); String newRfid =
		 * bucketInfo.rfid;
		 * 
		 * isSucc = bucketService.updateById(bucketInfo);
		 * 
		 * if (!oldRfid.equals(newRfid)) {// 两次rfid不相同才更新rfid使用状态 //
		 * 更新被选中的rfid为被使用 rfidService.updateByRfid(1, newRfid); // 更新旧的rfid为未被使用
		 * rfidService.updateByRfid(0, oldRfid); }
		 */

		if (isSucc > 0) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("listAllBucket")
	public Map<String, Object> listAllBucket(HttpServletRequest request) {

		List<BucketInfo> allList1 = bucketService.listAllBucketInfo(qMap);
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

		// 获取rfid总记录数

		List<BucketInfo> allList2 = bucketService.listAllBucketInfo(qMap);
		int recordsFiltered = allList2.size();

		List<Map<String, String>> rfidList = bucketService.selectByPage(qMap);
		if (rfidList != null) {
			resultMap.put("draw", request.getParameter("draw"));
			resultMap.put("recordsTotal", recordsTotal);
			resultMap.put("recordsFiltered", recordsFiltered);
			resultMap.put("data", rfidList);
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
