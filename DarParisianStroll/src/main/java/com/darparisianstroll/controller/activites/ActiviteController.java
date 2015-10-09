package com.darparisianstroll.controller.activites;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActiviteController {

    @RequestMapping(value = "activite", method = RequestMethod.GET)
    public ModelAndView getActivite() {
	return new ModelAndView("activites/activite");
    }

    @RequestMapping(value = "activite", method = RequestMethod.POST)
    public ModelAndView postActivite() {
	return new ModelAndView("activites/activite");
    }

}
