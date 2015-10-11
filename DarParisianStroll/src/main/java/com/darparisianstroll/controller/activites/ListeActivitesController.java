package com.darparisianstroll.controller.activites;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.service.ActivityService;

@Controller
@RequestMapping("/liste_activites")
public class ListeActivitesController {

	@Autowired
	ActivityService service;

	@RequestMapping( method = RequestMethod.GET)
	public ModelAndView getListeActivites() {
		List<Activity> activities = service.findAllActivities();
		ModelAndView mod = new ModelAndView("activites/liste_activites");
		mod.addObject("activities", activities);
		return mod;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postListeActivites() {
		return new ModelAndView("activites/liste_activites");
	}

}
