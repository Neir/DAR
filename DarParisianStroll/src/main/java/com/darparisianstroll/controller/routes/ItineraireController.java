package com.darparisianstroll.controller.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ItineraireController {

    @RequestMapping(value = "/itineraire", method = RequestMethod.GET)
    public ModelAndView getItineraire() {
	return new ModelAndView("routes/itineraire");
    }

    @RequestMapping(value = "/itineraire", method = RequestMethod.POST)
    public ModelAndView postItineraire() {
	return new ModelAndView("routes/itineraire");
    }

}
