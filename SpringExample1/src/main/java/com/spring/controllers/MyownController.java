package com.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyownController {
	ModelAndView model_and_view;

	@RequestMapping(value = "register")
	public ModelAndView register() {

		model_and_view = new ModelAndView();
		model_and_view.setViewName("home");

		return model_and_view;
	}

	@RequestMapping(value = "homepage")
	public ModelAndView homePage(@ModelAttribute User user, HttpServletRequest req) {

		model_and_view.addObject("user", user);
		model_and_view.setViewName("success");

		return model_and_view;

	}

}
