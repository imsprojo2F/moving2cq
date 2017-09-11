/**   
* @Title: TrashInfoController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月26日 上午10:13:31 
* @version V1.0   
*/
package com.movingcq.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movingcq.entity.TrashCollectionDetailInfo;
import com.movingcq.service.IRestInfoService;
import com.movingcq.service.ITrashDetailService;
import com.movingcq.util.ApiResult;
import com.movingcq.util.DateUtil;
import com.movingcq.util.GetCurrentTime;

/**
 * @ClassName: TrashInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月26日 上午10:13:31
 * 
 */
@Controller
@RequestMapping("/trashInfo")
public class TrashInfoController {

	public static int PAGE_NOW;
	public static int PAGE_SIZE;

	private int isSucc = 0;
	boolean isTrue = false;
	Object rObject = null;

	@Autowired
	private ITrashDetailService trashDetailService;

	@Autowired
	private IRestInfoService restInfoService;

	@ResponseBody
	@RequestMapping("listAllTrash")
	public Map<String, Object> listAllTrash(String page, String rows, String key_area, String key_company,
			String key_startDate, String key_endDate, String sort, String order) {

		PAGE_NOW = Integer.parseInt(page);
		PAGE_SIZE = Integer.parseInt(rows);
		PAGE_NOW = (PAGE_NOW - 1) * PAGE_SIZE;
		page = String.valueOf(PAGE_NOW);

		Map<String, String> map = new HashMap<String, String>();
		map.put("page", page);
		map.put("rows", rows);

		if (key_area != null && !"".equals(key_area)) {
			map.put("key_area", key_area);
		}
		if (key_company != null && !"".equals(key_company)) {
			map.put("key_company", key_company);
		}
		if (key_startDate != null && !"".equals(key_startDate)) {
			map.put("key_startDate", key_startDate);
			map.put("key_endDate", key_endDate);
		}
		if (sort == null || order == null) {
			sort = "id";
			order = "desc";
		}
		if (sort.equals("area_name") || sort.equals("name")) {
			sort = "r." + sort;
		} else {
			sort = "t." + sort;
		}

		map.put("sort", sort);
		map.put("dir", order);

		List<Map<Object, Object>> allList = trashDetailService.listAllTrash(map);
		int recordNum = allList.size();

		List<Map<String, String>> userList = trashDetailService.selectByPage(map);
		if (userList != null) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", recordNum);
			result.put("rows", userList);
			return result;
		}
		return null;

	}

	@ResponseBody
	@RequestMapping("listByArea")
	public Object listByArea(String key_area, String key_company, String key_startDate, String key_endDate, String sort,
			String dir) {

		Map<String, String> map = new HashMap<String, String>();
		if (key_area != null && !"".equals(key_area)) {
			map.put("key_area", key_area);
		}
		if (key_company != null && !"".equals(key_company)) {
			map.put("key_company", key_company);
		}
		if (key_startDate != null && !"".equals(key_startDate)) {
			map.put("key_startDate", key_startDate);
			map.put("key_endDate", key_endDate);
		}

		List<Map<Object, Object>> allList = trashDetailService.listAllTrash(map);

		return allList;

	}

	/*
	 * 数据分析列表
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping("analysisTrash")
	public Map<String, Object> analysisTrash(String page, String rows, String key_area, String dayNum,
			String key_startDate, String key_endDate, String key_company, String sort, String order) {

		PAGE_NOW = Integer.parseInt(page);
		PAGE_SIZE = Integer.parseInt(rows);
		PAGE_NOW = (PAGE_NOW - 1) * PAGE_SIZE;
		page = String.valueOf(PAGE_NOW);

		Map<String, String> querymap = new HashMap<String, String>();
		querymap.put("page", page);
		querymap.put("rows", rows);

		if (key_area != null && !"".equals(key_area)) {
			querymap.put("key_area", key_area);
		}
		if (key_startDate != null && !"".equals(key_startDate)) {
			querymap.put("key_startDate", "CURDATE()");
			querymap.put("key_endDate", "CURDATE()+1");
		}
		if (sort == null || order == null) {
			sort = "id";
			order = "desc";
		}
		if (sort.equals("area_name") || sort.equals("name")) {
			sort = "r." + sort;
		} else {
			sort = "t." + sort;
		}
		querymap.put("sort", sort);
		querymap.put("dir", order);

		// 定义resultList/当日产生量
		List<Map<Object, Object>> resultList = new ArrayList<Map<Object, Object>>();
		Double dayPut = (double) 0;
		int resultIndex = 0;
		int day = Integer.parseInt(dayNum);
		String now = DateUtil.getStringDate();
		try {
			key_endDate = DateUtil.string2Date(now, -1);
			key_startDate = DateUtil.string2Date(now, day);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		querymap.put("key_startDate", key_startDate);
		querymap.put("key_endDate", key_endDate);
		// 获取总共有几家餐厅即总记录数
		List<Map<Object, Object>> allList = trashDetailService.selectByDistinct(querymap);
		int recordNum = allList.size();

		querymap.remove("key_area");
		querymap.put("sort", "id");
		List<Map<Object, Object>> restIds = trashDetailService.selectDistinctByPage(querymap);

		for (int j = 0; j < restIds.size(); j++) {
			// 获取restid集合并查询符合的记录
			querymap.put("key_company_id", String.valueOf(restIds.get(j).get("restaurant_id")));
			allList = trashDetailService.listAllTrash(querymap);// 获取所有等于某个restid的集合
			for (int k = 0; k < allList.size(); k++) {
				Object double1 = allList.get(k).get("net_weight");
				dayPut = dayPut + Double.parseDouble(allList.get(k).get("net_weight").toString());// 日产量累加
				allList.get(k).put("dayPut", String.valueOf(dayPut));
				allList.get(k).put("barrelNum", String.valueOf(allList.size()));
				if (k + 1 == allList.size()) {
					resultList.add(resultIndex++, allList.get(k));
				}
			}

		}
		if (resultList != null) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", recordNum);
			result.put("rows", resultList);
			return result;
		}
		return null;

	}

	/*
	 * 数据分析列表
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping("analysisTrashByDate")
	public Map<String, Object> analysisTrashByDate(String page, String rows, String dayNum, String key_startDate,
			String key_endDate, String key_company, String sort, String order, String key_shopId) {

		PAGE_NOW = Integer.parseInt(page);
		PAGE_SIZE = Integer.parseInt(rows);
		PAGE_NOW = (PAGE_NOW - 1) * PAGE_SIZE;
		page = String.valueOf(PAGE_NOW);

		Map<String, String> map = new HashMap<String, String>();
		map.put("page", page);
		map.put("rows", rows);

		if (sort == null || order == null) {
			sort = "id";
			order = "desc";
		}

		map.put("sort", sort);
		map.put("dir", order);

		map.put("key_shopId", key_shopId);
		// 定义resultList/当日产生量
		List<Map<Object, Object>> resultList = new ArrayList<Map<Object, Object>>();
		List<Map<Object, Object>> allList = new ArrayList<>();
		Double dayPut = (double) 0;
		int resultIndex = 0;
		int recordNum = 0;
		int day = Integer.parseInt(dayNum);

		for (int i = 0; i < day; i++) {
			try {
				String key_Date = DateUtil.string2Date(key_endDate, i);
				map.put("key_Date", key_Date);

				allList = trashDetailService.selectByDistinctDate(map);
				if (allList.size() > 0) {// 当查询某天的记录数大于0时则再总记录数加1
					recordNum++;
				}
				// 获取该餐厅一天内所有记录
				List<Map<Object, Object>> dayList = trashDetailService.selectDistinctDateByPage(map);

				for (int j = 0; j < dayList.size(); j++) {// 每日垃圾量累加
					dayPut = dayPut + Double.parseDouble(dayList.get(j).get("net_weight").toString());
					dayList.get(j).put("dayPut", String.valueOf(dayPut));
					dayList.get(j).put("barrelNum", String.valueOf(dayList.size()));
					if (j + 1 == dayList.size()) {
						resultList.add(resultIndex++, dayList.get(j));
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (resultList != null) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", recordNum);
			result.put("rows", resultList);
			return result;
		}
		return null;

	}

	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping("listDayAllTrash")
	public Map<String, Object> listDayAllTrash(String page, String rows, String key_area, String key_company,
			String key_startDate, String key_company_id, String key_endDate, String key_Date, String sort,
			String order) {

		PAGE_NOW = Integer.parseInt(page);
		PAGE_SIZE = Integer.parseInt(rows);
		PAGE_NOW = (PAGE_NOW - 1) * PAGE_SIZE;
		page = String.valueOf(PAGE_NOW);

		Map<String, String> map = new HashMap<String, String>();
		map.put("page", page);
		map.put("rows", rows);

		if (key_area != null && !"".equals(key_area)) {
			map.put("key_area", key_area);
		}
		if (key_company != null && !"".equals(key_company)) {
			map.put("key_company", key_company);
		}
		if (key_company_id != null && !"".equals(key_company_id)) {
			map.put("key_company_id", key_company_id);
		}
		if (key_startDate != null && !"".equals(key_startDate)) {
			map.put("key_startDate", key_startDate);
			map.put("key_endDate", key_endDate);
		}
		if (sort == null || order == null) {
			sort = "id";
			order = "desc";
		}
		if (sort.equals("area_name") || sort.equals("name")) {
			sort = "r." + sort;
		} else {
			sort = "t." + sort;
		}

		key_Date = DateUtil.getStringDate();
		map.put("key_Date", key_Date);

		map.put("sort", sort);
		map.put("dir", order);

		List<Map<Object, Object>> allList = trashDetailService.selectByDistinct(map);
		int recordNum = allList.size();

		map.put("sort", "id");
		List<Map<Object, Object>> restIds = trashDetailService.selectDistinctByPage(map);

		// 定义resultList/当日产生量
		List<Map<Object, Object>> resultList = new ArrayList<Map<Object, Object>>();
		int resultIndex = 0;
		Map<Object, Object> dayPutMap = new HashMap<Object, Object>();

		for (int i = 0; i < restIds.size(); i++) {
			map.put("restaurant_id", restIds.get(i).get("restaurant_id").toString());
			dayPutMap = trashDetailService.selectPutByDay(map);
			resultList.add(resultIndex++, dayPutMap);
		}

		if (resultList != null) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("total", recordNum);
			result.put("rows", resultList);
			return result;
		}
		return null;

	}

	@ResponseBody
	@RequestMapping("getCompanyList")
	public Object getCompanyList() {
		Map<String, String> map = new HashMap<>();

		Map<Object, Object> comMap = new HashMap<>();
		List<Map<Object, Object>> resultList = new ArrayList<Map<Object, Object>>();
		int resultIndex = 0;
		// 获取restId
		List<Map<Object, Object>> restIds = trashDetailService.selectByDistinct(map);
		for (int i = 0; i < restIds.size(); i++) {
			map.put("id", restIds.get(i).get("restaurant_id").toString());
			comMap = trashDetailService.listRestById(map);
			resultList.add(resultIndex++, comMap);
		}
		return resultList;
	}

	@RequestMapping("insertTrash")
	@ResponseBody
	public Object insertTrash(TrashCollectionDetailInfo tDetailInfo) {
		Map<String, String> map = new HashMap<>();

		isSucc = trashDetailService.insertTrash(tDetailInfo);

		// 更新restInfo表动态垃圾相关数据
		map.put("restId", String.valueOf(tDetailInfo.restaurant_id));
		map.put("last_collect_date", GetCurrentTime.getNow());
		map.put("last_collect_num", String.valueOf(tDetailInfo.net_weight));
		isSucc = restInfoService.updateByDynamic(map);

		if (isSucc == 1) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}

		return rObject;
	}

	@RequestMapping("deleteById")
	@ResponseBody
	public Object deleteById(HttpServletRequest request) {

		String idArr = request.getParameter("ids");
		String[] ids = idArr.split(",");

		isSucc = trashDetailService.deleteById(ids);

		if (isSucc == 1) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}

		return rObject;
	}

	@RequestMapping("updateById")
	@ResponseBody
	public Object updateById(TrashCollectionDetailInfo tDetailInfo) {

		isSucc = trashDetailService.updateById(tDetailInfo);

		if (isSucc == 1) {
			rObject = new ApiResult("更新成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("更新失败", ApiResult.CODE_FAIL);
		}

		return rObject;
	}

	@RequestMapping("toTrashReal_area")
	public Object toRealData_area() {

		return "trash/realData_area";
	}

	@RequestMapping("toTrashHistory")
	public Object toRealData_car() {

		return "trash/historyData";
	}

	@RequestMapping("toTrashAlysis")
	public Object toTrashAlysis() {

		return "trash/alysisData";
	}

	@RequestMapping("toTrashAll")
	public Object toTrashAll() {

		return "trash/allData";
	}

	@RequestMapping("toDataGrid")
	public Object toDataGrid(String shopName, String shopId, HttpServletRequest request) {

		try {
			shopName = new String(shopName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("shopName", shopName);
		request.setAttribute("shopId", shopId);
		return "trash/alysisData_datagrid";
	}

}
