/**   
* @Title: MenuRedirector.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Imsprojo2FAN
* @date 2017年5月8日 上午10:11:37 
* @version V1.0   
*/
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

/**
 * @ClassName: MenuRedirector
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Imsprojo2FAN
 * @date 2017年5月8日 上午10:11:37
 * 
 */
@Controller
@RequestMapping("/menu")
public class MenuRedirector {

	@Autowired
	private ISysUserService sysUserService;

	@RequestMapping("/index")
	public String index() {

		return "index";
	}

	@RequestMapping("/main")
	public String main() {

		return "main";
	}

	@RequestMapping("/lock")
	public String lock(HttpSession session) {
		return "lockscreen";
	}

	@ResponseBody
	@RequestMapping("/removePass")
	public Object removePass(HttpSession session) {
		session.setAttribute("password", "");
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView toLogin() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

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

		if (!sysUser.getPassword().equals(password)) {
			return new ApiResult("登录失败", ApiResult.CODE_FAIL);
		} else {
			session.setAttribute("user", sysUser);
			session.setAttribute("password", sysUser.getPassword());
			return new ApiResult("登录成功", ApiResult.CODE_SUCCESS);
		}

	}

	// 导航栏页面跳转----------------------------------------------------------

	@RequestMapping("/userOperate")
	public String toUser() {
		return "/user2company/userOperate";
	}

	@RequestMapping("/restaurantOperate")
	public String toRestaurant() {
		return "/user2company/restaurantOperate";
	}

	@RequestMapping("/rfidOperate")
	public String toRfic() {
		return "/user2company/rfidOperate";
	}

	@RequestMapping("/bucketOperate")
	public String toBucket() {
		return "/user2company/bucketOperate";
	}

	@RequestMapping("/driverOperate")
	public String toDriver() {
		return "/user2company/driverOperate";
	}

	@RequestMapping("/carOperate")
	public String toCar() {
		return "/user2company/carOperate";
	}

	@RequestMapping("/history")
	public String tohistory() {
		return "/trashInfo/history";
	}

	@RequestMapping("/dataAnalysis")
	public String toAnalysis() {
		return "/trashInfo/dataAnalysis";
	}

	@RequestMapping("/collect")
	public String toCollect() {
		return "/trashInfo/collect";
	}

	@RequestMapping("/program")
	public String toProgram() {
		return "/mapInfo/program";
	}

	@RequestMapping("/listLine")
	public String toLine() {
		return "/mapInfo/line";
	}

	@RequestMapping("/real")
	public String toReal() {
		return "/mapInfo/real";
	}

}
