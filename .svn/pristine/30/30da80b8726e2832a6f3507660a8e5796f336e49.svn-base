package com.movingcq.controller;

import java.util.Date;
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

import com.movingcq.entity.SysUser;
import com.movingcq.service.ISysUserService;
import com.movingcq.util.ApiResult;

@Controller
@RequestMapping("/menu/user")
public class UserController {

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

	@Autowired
	private ISysUserService sysUserService;

	// 验证账号是否已被使用
	@ResponseBody
	@RequestMapping("validate")
	public Object validate(String validateValue) {

		SysUser sysUser = null;
		sysUser = sysUserService.selectByAccount(validateValue);
		if (sysUser == null) {
			rObject = new ApiResult("可用", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("不可用", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("addUser")
	public Object addUser(SysUser sysUser) {

		sysUser.setCreateTime(new Date());
		sysUser.setUpdateTime(new Date());
		SysUser sUser = sysUserService.selectByAccount(sysUser.getUserAccount());
		// 再次判断所添加用户是否存在
		if (sUser == null) {
			isSucc = sysUserService.addUser(sysUser);
			if (isSucc == 1) {
				rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
			} else {
				rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
			}
		} else {
			rObject = new ApiResult("不可用", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("deleteUser")
	public Object deleteUser(HttpServletRequest request) {
		String idArr = request.getParameter("ids");

		String[] ids = idArr.split(",");

		isSucc = sysUserService.deleteById(ids);
		if (isSucc > 0) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("updateUser")
	public Object updateUser(SysUser sysUser) {
		sysUser.setUpdateTime(new Date());
		sysUser.setUpdateTime(new Date());
		System.out.println(sysUser);
		int isSucc = sysUserService.updateById(sysUser);
		if (isSucc > 0) {
			rObject = new ApiResult("保存成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("保存失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@ResponseBody
	@RequestMapping("listAllUser")
	public Object listAllUser(HttpServletRequest request) {

		List<SysUser> allList = sysUserService.listAllUser(qMap);
		int recordsTotal = allList.size();

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
		String columnArray[] = { "", "id", "user_account", "password", "user_name", "create_time", "enabled" };
		String sortOrder = request.getParameter("order[0][column]");
		if (!"".equals(sortOrder) && sortOrder != null) {
			int index = Integer.parseInt(sortOrder);
			sortOrder = columnArray[index];
		}
		String sortDir = request.getParameter("order[0][dir]");
		System.out.println("sortOrder: " + sortOrder);
		System.out.println("sortDir: " + sortDir);

		// For search
		String key = request.getParameter("search[value]");

		qMap.put("key", key);
		qMap.put("sortOrder", sortOrder + " " + sortDir);
		qMap.put("pageNow", pageNow);
		qMap.put("pageSize", pageSize);

		// 获取账号带条件查询总记录数
		List<SysUser> filterList = sysUserService.listAllUser(qMap);
		int recordsFiltered = filterList.size();

		List<Map<String, String>> userList = sysUserService.selectByPage(qMap);
		if (userList != null) {
			Map<String, Object> result = new LinkedHashMap<String, Object>();
			result.put("draw", request.getParameter("draw"));
			result.put("recordsTotal", recordsTotal);
			result.put("recordsFiltered", recordsFiltered);
			result.put("data", userList);
			return result;
		}
		return null;

	}

	@RequestMapping("/info")
	public ModelAndView index(String id, HttpServletRequest request, Model m) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user2company/userInfo");
		return mv;
	}
}
