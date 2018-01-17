package com.isat.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.isat.exception.IncidentTrackerBusinessException;
import com.isat.objects.User;
import com.isat.service.LoginService;
import com.isat.service.PropertyService;

@Controller
@SessionAttributes({"user_info","offerings"})
public class HomePageController {

	private static final Logger logger = Logger.getLogger(HomePageController.class);

	@Autowired
	PropertyService propertyService;

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showregisterPage() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("register", new User());
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute User user) {
		ModelAndView mav = null;
		try {
			loginService.insertUser(user);
			mav = new ModelAndView("newuser");
			mav.addObject("message", user.getEmail());
			logger.info("User Registered Successfully");
			System.out.println("User Registered Successfully");
		} catch (IncidentTrackerBusinessException ex) {
			logger.error("Error occured during user registration "+ex.getMessage());
			mav = new ModelAndView("register");
			mav.addObject("register", new User());
			mav.addObject("message", propertyService.readValues(ex.getErrorCode()));
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
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute User user) {

		ModelAndView mav = null;
		try {
			logger.debug(user.getUserName() + "-------------------" + user.getPassword());
			User loginUser = loginService.checkUser(user);
			if (loginUser != null) {
				mav = new ModelAndView("welcome");
				Set<String> offerResultSet=loginService.checkOffering(loginUser.getUserId());
				//for(int index=0;index<offerResultSet.size();index++)
				//{
					mav.addObject("offerings",offerResultSet);
				//}
				//mav.addObject("UserEmail", loginUser.getEmail());
				//request.getSession().setAttribute("loginUser",loginUser.getUserId());
				mav.addObject("user_info", loginUser);
				logger.info(loginUser.getEmail());
			}
		} catch (IncidentTrackerBusinessException e) {
			mav = new ModelAndView("login");
			mav.addObject("message", propertyService.readValues(e.getErrorCode()));
			mav.addObject("login", new User());
		}
		return mav;
	}

	@RequestMapping(value = "/viewIncidents", method = RequestMethod.GET)
	public ModelAndView viewIncidents() {
		ModelAndView mav = new ModelAndView("viewIncidents");
		mav.addObject("login", new User());
		return mav;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logOutPage() {
		ModelAndView mav = new ModelAndView("logout");
		return mav;
	}
}
