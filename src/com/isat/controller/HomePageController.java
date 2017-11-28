package com.isat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isat.pojo.User;

@Controller
public class HomePageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showHomePage() {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login",new User());
		/*mav.addObject("register",new User());*/
		return mav;
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showregisterPage() {

		ModelAndView mav = new ModelAndView("register");
		mav.addObject("register",new User());
		return mav;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}

}
