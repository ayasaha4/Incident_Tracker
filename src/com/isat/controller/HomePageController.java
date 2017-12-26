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

import com.isat.objects.User;
import com.isat.service.LoginService;
import com.isat.service.PropertyService;
import com.isat.service.RegisterService;

@Controller
public class HomePageController {

	private static final Logger logger = Logger.getLogger(HomePageController.class);
	
	@Autowired
	PropertyService propertyService ;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisterService registerService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showHomePage() {
        
		propertyService.readValues("error");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login",new User());
		return mav;
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showregisterPage() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("register",new User());
		return mav;
	}
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute User user) {
		ModelAndView mav = null;
		int registerUsercounter = registerService.insertUser(user);

		if (registerUsercounter != 0) {
			mav = new ModelAndView("error");
			logger.info("User Registered Successfully");
			System.out.println("User Registered Successfully");


		}else {
			mav = new ModelAndView("error");
			mav.addObject("message", "User not Registered Successfully");
		}
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User user) {
		ModelAndView mav = null;
		System.out.println(user.getUserId()+"---------------------------------------");
		User loginUser = loginService.checkUser(user);

		if (loginUser != null) {
			mav = new ModelAndView("welcome");
			mav.addObject("UserEmail", loginUser.getEmail());
			logger.info(loginUser.getEmail());
		}else {
			mav = new ModelAndView("login");
			mav.addObject("login",new User());
		}
		return mav;
	}
}
