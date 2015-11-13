package com.darparisianstroll.controller.activites;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.ActivityReview;
import com.darparisianstroll.domain.Category;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;
import com.darparisianstroll.domain.RouteReview;
import com.darparisianstroll.domain.User;
import com.darparisianstroll.domain.enums.Note;
import com.darparisianstroll.service.ActivityReviewService;
import com.darparisianstroll.service.ActivityService;
import com.darparisianstroll.service.CategoryService;
import com.darparisianstroll.service.RouteActService;
import com.darparisianstroll.service.RouteReviewService;
import com.darparisianstroll.service.UserService;
import com.darparisianstroll.util.Util;

@Controller
public class ActiviteController {

    @Autowired
    ActivityService actService;

    @Autowired
    ActivityReviewService actReviewService;

    @Autowired
    RouteActService routeActService;

    @Autowired
    RouteReviewService routeReviewService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    private int activite;

    private final static String CHAMP_NOTE = "select1";
    private final static String CHAMP_TEXT = "textarea";

    @RequestMapping(value = "activite", method = RequestMethod.GET)
    public ModelAndView getActivite(HttpServletRequest request,
	    HttpServletResponse response, @RequestParam("id") Integer id) {
	Activity act = actService.findById(Integer.parseInt(StringEscapeUtils
		.escapeHtml4(String.valueOf(id))));
	activite = id;
	Category cat = categoryService.findById(act.getCategory());
	List<ActivityReview> actReviews = actReviewService
		.findActivityReviewsFromActivity(act);
	List<Route> routeList = routeActService.findAllRoutesByActivities(act);
	System.out.println("list size : " + routeList.size());
	List<Integer> reviewList = averageRoutesRate(routeList);
	int activityRate = averageActivityRate(act);
	User user = null;
	String user_id = Util.getCookieValue(request, "user");
	if (user_id != null) {
	    user = userService.findById(Integer.parseInt(user_id));
	}

	float prix = averageCost(act);
	float duree = averageDuration(act);

	DecimalFormat df = new DecimalFormat("##.##");
	df.setRoundingMode(RoundingMode.DOWN);

	ModelAndView mov = new ModelAndView("activites/activite");

	if (user_id != null) {
	    mov.addObject("connected", true);
	} else {
	    mov.addObject("connected", false);
	}

	mov.addObject("activity", act);
	mov.addObject("routeList", routeList);
	mov.addObject("reviewList", reviewList);
	mov.addObject("activityRate", activityRate);
	mov.addObject("category", cat);
	mov.addObject("activityReviews", actReviews);
	mov.addObject("user", user);
	mov.addObject("averageCost", df.format(prix));
	mov.addObject("averageDuration", Math.round(duree) + "h");

	return mov;
    }

    @RequestMapping(value = "activite", method = RequestMethod.POST)
    public ModelAndView postActivite(HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam(value = CHAMP_NOTE) final Integer note,
	    @RequestParam(value = CHAMP_TEXT) final String text) {
	final String ftext = StringEscapeUtils.escapeHtml4(text);

	String user_id = Util.getCookieValue(request, "user");

	ActivityReview aw = new ActivityReview();
	aw.setActivity(activite);
	aw.setDescription(ftext);
	aw.setNote(note);
	aw.setUser(Integer.parseInt(user_id));
	actReviewService.saveReview(aw);

	try {
	    response.getWriter().write("true");
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	try {
	    response.sendRedirect("activite?id=" + activite);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	return this.getActivite(request, response, activite);
    }

    @RequestMapping(value = "activite_form", method = RequestMethod.GET)
    public ModelAndView formActivite(HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam(value = CHAMP_NOTE) final Integer note,
	    @RequestParam(value = CHAMP_TEXT) final String text) {
	final String ftext = StringEscapeUtils.escapeHtml4(text);

	String user_id = Util.getCookieValue(request, "user");

	ActivityReview aw = new ActivityReview();
	aw.setActivity(activite);
	aw.setDescription(ftext);
	aw.setNote(note);
	aw.setUser(Integer.parseInt(user_id));
	actReviewService.saveReview(aw);

	try {
	    response.getWriter().write("true");
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

    private List<Integer> averageRoutesRate(List<Route> list) {
	ArrayList<Integer> res = new ArrayList<>();
	List<RouteReview> ll;
	System.out.println("list size : " + list.size());
	for (Route r : list) {
	    ll = routeReviewService.findRouteReviewsByRoute(r);
	    float cpt = 0;
	    for (RouteReview w : ll) {
		Note n = w.getNote();
		int x = 0;
		if (n == Note.un)
		    x = 1;
		if (n == Note.deux)
		    x = 2;
		if (n == Note.trois)
		    x = 3;
		if (n == Note.quatre)
		    x = 4;
		if (n == Note.cinq)
		    x = 5;
		cpt += x;
	    }
	    int s = ll.size();
	    if (s > 0)
		cpt /= s;
	    res.add(Math.round(cpt));
	}
	return res;
    }

    private int averageActivityRate(Activity a) {
	float res = 0;
	List<ActivityReview> ll = actReviewService
		.findActivityReviewsFromActivity(a);
	for (ActivityReview ar : ll) {
	    Note n = ar.getNote();
	    int x = 0;
	    if (n == Note.un)
		x = 1;
	    if (n == Note.deux)
		x = 2;
	    if (n == Note.trois)
		x = 3;
	    if (n == Note.quatre)
		x = 4;
	    if (n == Note.cinq)
		x = 5;
	    res += x;
	}
	int s = ll.size();
	if (s > 0)
	    res /= s;
	return Math.round(res);
    }

    private float averageCost(Activity a) {
	List<RouteAct> lra = routeActService.findRouteAct(a);
	float cpt = 0;
	for (RouteAct ra : lra) {
	    cpt += ra.getPrix();
	}
	if (!lra.isEmpty()) {
	    cpt /= lra.size();
	}
	return cpt;
    }

    private float averageDuration(Activity a) {
	List<RouteAct> lra = routeActService.findRouteAct(a);
	float cpt = 0;
	for (RouteAct ra : lra) {
	    cpt += ra.getDuree();
	}
	if (!lra.isEmpty()) {
	    cpt /= lra.size();
	}
	return cpt;
    }

    private String durationToString(int duration) {
	int h = duration / 60;
	int min = duration % 60;
	String res = "";
	if (h > 0) {
	    res += h + "h";
	}
	res += min + "min";
	return res;
    }

}
