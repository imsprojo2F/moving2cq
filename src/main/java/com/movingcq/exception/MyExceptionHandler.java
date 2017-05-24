package com.movingcq.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.error("===========>" , ex);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);

		return new ModelAndView("error", model);
	}

}
