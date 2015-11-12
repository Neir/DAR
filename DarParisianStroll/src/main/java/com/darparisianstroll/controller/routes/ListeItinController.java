package com.darparisianstroll.controller.routes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.service.ActivityService;
import com.darparisianstroll.service.RouteActService;
import com.darparisianstroll.service.UserService;
import com.darparisianstroll.util.Util;

@Controller
public class ListeItinController {
    public static final String CHAMP_ACT1 = "act1";
    public static final String CHAMP_ACT2 = "act2";
    public static final String CHAMP_ACT3 = "act3";

    @Autowired
    UserService userService;
    @Autowired
    ActivityService actService;
    @Autowired
    RouteActService routeActService;

    @RequestMapping(value = "liste_itineraires", method = RequestMethod.GET)
    public ModelAndView getListeItin(HttpServletRequest request) {
	ModelAndView model = new ModelAndView("routes/liste_itineraires");

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	ArrayList<Activity> activities = (ArrayList<Activity>) actService
		.findAllVisibleActivities();

	model.addObject("activities", activities);
	return model;
    }

    @RequestMapping(value = "liste_itineraires", method = RequestMethod.POST)
    public ModelAndView postListeItin(HttpServletRequest request,
	    @RequestParam(value = CHAMP_ACT1) final String act1,
	    @RequestParam(value = CHAMP_ACT2) final String act2,
	    @RequestParam(value = CHAMP_ACT3) final String act3) {

	System.out.println("POST");

	List<Route> routes = null;
	Activity activ1 = null, activ2 = null, activ3 = null;

	if (act1 != null && !act1.isEmpty()) {
	    activ1 = actService.findById(Integer.parseInt(act1));
	}
	if (act2 != null && !act2.isEmpty()) {
	    activ2 = actService.findById(Integer.parseInt(act2));
	}
	if (act3 != null && !act3.isEmpty()) {
	    activ3 = actService.findById(Integer.parseInt(act3));
	}

	ModelAndView model = new ModelAndView("routes/liste_itineraires");

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	if (activ1 != null) {
	    routes = routeActService.findAllRoutesByActivities(activ1);
	}
	if (activ2 != null) {
	    if (routes.isEmpty())
		routes = routeActService.findAllRoutesByActivities(activ2);
	    else
		routes.addAll(routeActService.findAllRoutesByActivities(activ2));
	}
	if (activ3 != null) {
	    if (routes.isEmpty())
		routes = routeActService.findAllRoutesByActivities(activ3);
	    else
		routes.addAll(routeActService.findAllRoutesByActivities(activ3));
	}

	ArrayList<Route> routesRes1 = null;
	ArrayList<Route> routesRes2 = null;

	if (routes != null) {
	    model.addObject("routes", routes);
	}

	ArrayList<Activity> activities = (ArrayList<Activity>) actService
		.findAllVisibleActivities();

	model.addObject("activities", activities);

	return model;
    }
}
