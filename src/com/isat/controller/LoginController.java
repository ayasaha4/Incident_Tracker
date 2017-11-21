package com.isat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isat.pojo.User;
import com.isat.service.LoginService;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	

	@Autowired
	LoginService loginService;

	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}*/

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginUser") User user) {
		ModelAndView mav = null;
		User loginUser = loginService.checkUser(user);

		if (loginUser != null) {
			mav = new ModelAndView("welcome");
			mav.addObject("UserEmail", loginUser.getEmail());
			logger.info(loginUser.getEmail());
			System.out.println(loginUser.getEmail());
			/*System.out.println(System.getProperty("catalina.base"));
			System.out.println(System.getProperty("catalina.home"));*/

		}else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
}
