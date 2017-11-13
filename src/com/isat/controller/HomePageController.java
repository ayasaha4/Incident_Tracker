package com.isat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	

	
	@RequestMapping("/")
	public ModelAndView showHomePage()
	{
		
		return new ModelAndView("home");
		
	}

}
