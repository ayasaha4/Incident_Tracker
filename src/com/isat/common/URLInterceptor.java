package com.isat.common;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.isat.controller.HomePageController;
import com.isat.service.impl.LoginServiceImpl;

public class URLInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = Logger.getLogger(URLInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" <interceptor> - this is pre handle");
		logger.info(" <interceptor> - this is pre handle");

		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Set<String> urls = (Set<String>) session.getAttribute("offerings");
		String invokedURL = request.getRequestURI().substring(request.getContextPath().length()+1);
		System.out.println("----------------------------Invoked URL IS------------------------"+invokedURL);
		
		if (urls != null) {
			System.out.println("size ---- "+urls.size()+"-------------"+invokedURL);
			if (urls.contains(request.getRequestURI().substring(request.getContextPath().length())) || urls.contains(invokedURL)) {
				System.out.println("URL matched");
			} else {
				System.out.println("Redirect");
				ModelAndView mav = new ModelAndView("error");

				throw new ModelAndViewDefiningException(mav);
			}
		}

		return super.preHandle(request, response, handler);

	}

}