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
import com.isat.service.RegisterService;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	

	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisterService registerService;

	

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute User user) {
		ModelAndView mav = null;
		System.out.println(user.getUserId()+"---------------------------------------");
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
	
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute User user) {
		ModelAndView mav = null;
		int registerUsercounter = registerService.insertUser(user);

		if (registerUsercounter != 0) {
			mav = new ModelAndView("error");
			/*mav.addObject("UserEmail", loginUser.getEmail());*/
			logger.info("User Registered Successfully");
			System.out.println("User Registered Successfully");


		}else {
			mav = new ModelAndView("error");
			mav.addObject("message", "User not Registered Successfully");
		}
		return mav;
	}
}
