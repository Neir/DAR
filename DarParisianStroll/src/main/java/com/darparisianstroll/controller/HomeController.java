package com.darparisianstroll.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.util.Util;

/**
 * Controller de la page d'accueil
 *
 */
@Controller
public class HomeController {

    /**
     * Controlleur méthode Get de la page d'acceuil
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @return page d'accueil
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHome(HttpServletRequest request) {
	String user_id = Util.getCookieValue(request, "user");

	ModelAndView model = new ModelAndView("hello");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }

    /**
     * Controlleur méthode Post de la page d'acceuil
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @return page d'accueil
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView postHome(HttpServletRequest request) {
	String user_id = Util.getCookieValue(request, "user");

	ModelAndView model = new ModelAndView("hello");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }

    /**
     * Controlleur méthode Get de la page d'acceuil
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @return page d'accueil
     */
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ModelAndView getHome2(HttpServletRequest request) {
	String user_id = Util.getCookieValue(request, "user");

	ModelAndView model = new ModelAndView("hello");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }

    /**
     * Controlleur méthode Post de la page d'acceuil
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @return page d'accueil
     */
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    public ModelAndView postHome2(HttpServletRequest request) {
	String user_id = Util.getCookieValue(request, "user");

	ModelAndView model = new ModelAndView("hello");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }

}