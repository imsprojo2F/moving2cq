package com.movingcq.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.movingcq.entity.SysUser;
import com.movingcq.service.ISysUserService;
import com.movingcq.util.ApiResult;

@Controller
public class LoginController {

	@Autowired
	private ISysUserService sysUserService;

	/**
	 * 访问登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView toLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/removePass")
	public Object removePass(HttpSession session) {
		session.setAttribute("password", "");
		return null;
	}

	/**
	 * 请求登录，验证用户
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ApiResult login(@RequestParam(value = "userAccount") String userAccount,
			@RequestParam(value = "password") String password, String type, HttpSession session) throws Exception {

		if (type != null && type.equals("lock")) {
			SysUser sysUser = (SysUser) session.getAttribute("user");
			if (sysUser == null) {
				return new ApiResult("登录失败", ApiResult.CODE_FAIL, "登录超时");
			}
		}
		SysUser sysUser = sysUserService.selectByAccount(userAccount);

		if (sysUser == null) {
			return new ApiResult("登录失败", ApiResult.CODE_FAIL);
		} else {
			session.setAttribute("user", sysUser);
			session.setAttribute("password", password);
			return new ApiResult("登录成功", ApiResult.CODE_SUCCESS);
		}

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/login";
	}

}
