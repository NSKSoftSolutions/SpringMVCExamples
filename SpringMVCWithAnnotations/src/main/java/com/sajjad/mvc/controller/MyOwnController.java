package com.sajjad.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sajjad.mvc.bens.User;

@Controller
public class MyOwnController {

	ModelAndView model_and_view;

	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User user) {
		model_and_view = new ModelAndView();
		model_and_view.addObject("user", user);
		model_and_view.setViewName("success");
		return model_and_view;

	}

}
