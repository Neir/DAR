package com.darparisianstroll.controller.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ListeItinController {

    @RequestMapping(value = "/liste_itineraires", method = RequestMethod.GET)
    public ModelAndView getListeItin() {
	return new ModelAndView("routes/liste_itineraires");
    }

    @RequestMapping(value = "/liste_itineraires", method = RequestMethod.POST)
    public ModelAndView postListeItin() {
	return new ModelAndView("routes/liste_itineraires");
    }
}
