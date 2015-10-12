package com.darparisianstroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHome() {
	return new ModelAndView("hello");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView postHome() {
	return new ModelAndView("hello");
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ModelAndView getHome2() {
	return new ModelAndView("hello");
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public ModelAndView postHome2() {
	return new ModelAndView("hello");
    }

}