package com.movingcq.util;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerMapping;

import com.movingcq.entity.SysUser;

public class SpringWebUtil {

	@SuppressWarnings("unchecked")
	public static boolean isJsonResponse(HttpServletRequest request) {
		Set<MediaType> mediaTypes = (Set<MediaType>) request
				.getAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
		if (mediaTypes != null && !mediaTypes.isEmpty()) {
			boolean isJson = mediaTypes.contains(MediaType.APPLICATION_JSON);
			return isJson;
		}
		return false;
	}

	public static SysUser getCurUser() {
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}
}
