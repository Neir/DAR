package com.darparisianstroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	public ModelAndView getHome() {
		return new ModelAndView("hello");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirect() {
		return "hello";
	}

}