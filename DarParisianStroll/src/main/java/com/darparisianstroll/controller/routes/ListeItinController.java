package com.darparisianstroll.controller.routes;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Category;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.User;
import com.darparisianstroll.service.ActivityService;
import com.darparisianstroll.service.CategoryService;
import com.darparisianstroll.service.RouteActService;
import com.darparisianstroll.service.UserService;

@Controller
public class ListeItinController {

	@Autowired
	UserService userService;
	@Autowired
	ActivityService actService;
	@Autowired
	RouteActService routeActService;

	@RequestMapping(value = "liste_itineraires", method = RequestMethod.GET)
	public ModelAndView getListeItin(HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = null;

		/*
		String user_id = Util.getCookieValue(request, "user");

		if (user_id != null) {
			user = userService.findById(Integer.parseInt(user_id));
		} else {
			// redirection vers la page de connexion
			return new ModelAndView(
					"compte_utilisateur/connexion_inscription/connexion_inscription");
		}
		 */
		ArrayList<Activity> activities = (ArrayList<Activity>) actService.findAllVisibleActivities();

		model.addAttribute("activities", activities);
		return new ModelAndView("routes/liste_itineraires");
	}

	@RequestMapping(value = "liste_itineraires", method = RequestMethod.POST)
	public ModelAndView postListeItin(
			@RequestParam("activityId1") int id1,
			@RequestParam("activityId2") int id2,
			@RequestParam("activityId3") int id3,
			Model model) {
		ArrayList<Route> routes1 = null;
		ArrayList<Route> routes2 = null;
		ArrayList<Route> routes3 = null;
		Activity act1 = actService.findById(id1);
		Activity act2 = actService.findById(id2);
		Activity act3 = actService.findById(id3);
		if(act1 != null) {
			routes1 = (ArrayList<Route>) routeActService.findAllRoutesByActivities(act1);
		}
		if(act2 != null) {
			routes2 = (ArrayList<Route>) routeActService.findAllRoutesByActivities(act2);
		}
		if(act3 != null) {
			routes3 = (ArrayList<Route>) routeActService.findAllRoutesByActivities(act3);
		}

		ArrayList<Route> routesRes1 = null;
		ArrayList<Route> routesRes2 = null;
		if(routes1!=null && routes2 == null && routes3 == null) {

			model.addAttribute("routes", convertRouteList2Model(routes1));
		}else if(routes1!=null && routes2 != null) {
			routesRes1 = new ArrayList<Route>();
			for(Route r1 : routes1) {
				for(Route r2 : routes2){
					if(r1.getRoute_id() == r2.getRoute_id()){
						routesRes1.add(r1);
					}
				}
			}
			if(routes3!=null) {
				routesRes2 = new ArrayList<Route>();

				for(Route r : routesRes1) {
					for(Route r3 : routes3){
						if(r.getRoute_id() == r3.getRoute_id()){
							routesRes2.add(r);
						}
					}
				}
				model.addAttribute("routes", convertRouteList2Model(routesRes2));
			} else {
				model.addAttribute("routes", convertRouteList2Model(routesRes1));
			}
		}
		return new ModelAndView("routes/liste_itineraires");
	}

	private ArrayList<RouteModel> convertRouteList2Model(ArrayList<Route> routeList) {
		ArrayList<RouteModel> result = new ArrayList<RouteModel>();

		for(Route r : routeList) {
			result.add(new RouteModel(r));
		}

		return result;
	}
}
