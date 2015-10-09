package com.darparisianstroll.controller.activites;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListeActivitesController {

    @RequestMapping(value = "liste_activites", method = RequestMethod.GET)
    public ModelAndView getListeActivites() {
	return new ModelAndView("activites/liste_activites");
    }

    @RequestMapping(value = "liste_activites", method = RequestMethod.POST)
    public ModelAndView postListeActivites() {
	return new ModelAndView("activites/liste_activites");
    }

}
