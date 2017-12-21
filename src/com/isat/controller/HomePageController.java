package com.isat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isat.pojo.User;
import com.isat.service.PropertyService;

@Controller
public class HomePageController {

	@Autowired
	PropertyService propertyService ;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showHomePage() {
        
		propertyService.readValues("error");
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
