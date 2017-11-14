package com.isat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isat.pojo.User;

@Controller
public class HomePageController {

	@RequestMapping("/")
	public ModelAndView showHomePage() {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}

}
