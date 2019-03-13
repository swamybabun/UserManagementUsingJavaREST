
package com.fbk.usermanagement.application.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fbk.usermanagement.application.rest.dtos.LoginObject;
import com.fbk.usermanagement.application.services.impl.UserService;
import com.fbk.usermanagement.application.viewobjects.User;

@Controller
public class LoginController {

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		return model;
	}

	@RequestMapping(value = { "/homePage" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");

		List<User> user_list = userService.getAll();
		model.getModelMap().addAttribute("users", user_list);
		return model;
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request,
	        @RequestParam(value = "error", required = false) String error,
	        @RequestParam(value = "logout", required = false) String logout, @ModelAttribute LoginObject loginObject) {

		ModelAndView model = new ModelAndView();

		// Validating the login with REST API
		if (loginObject.getEmail() != null && loginObject.getPassword() != null) {
			userService.validateLogin(loginObject.getEmail(), loginObject.getPassword());
		}
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from User Management Portal successfully.");
		}

		model.setViewName("loginPage");
		return model;
	}
}
