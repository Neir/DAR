package com.darparisianstroll.controller.routes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.Activity;
import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteAct;
import com.darparisianstroll.domain.RouteReview;
import com.darparisianstroll.service.RouteActService;
import com.darparisianstroll.service.RouteActServiceImpl;
import com.darparisianstroll.service.RouteReviewService;
import com.darparisianstroll.service.RouteReviewServiceImpl;
import com.darparisianstroll.service.RouteService;
import com.darparisianstroll.service.RouteServiceImpl;

@Controller
public class ItineraireController {
	
	@Autowired
	RouteService routeService;
	@Autowired
	RouteActService routeActService;
	@Autowired
	RouteReviewService routeRevService;

    @RequestMapping(value = "itineraire", method = RequestMethod.GET)
    public ModelAndView getItineraire(@RequestParam("id") int id, Model model) {

    	RouteModel route = new RouteModel(routeService.findById(id));
        /*
        Route route = new Route();
        
        route.setDescription("En litt�rature, la description constitue une pause dans le r�cit, o� elle peut former un ensemble autonome, bien que le plus souvent elle prenne place dans la narration."
        		+ "On la reconna�t � l'abondance des verbes de perception, d'�l�ments visuels, de rep�res spatiaux, de verbes d'�tat et de qualificatifs. Elle suit g�n�ralement un ordre, par exemple de la t�te aux pieds ou d'un plan g�n�ral � un plan rapproch�."
        		+ "Dans son ouvrage Les textes, Jean-Michel Adam distingue trois parties dans la formation d'un texte descriptif 1:"
        		+ "		l'op�ration d'ancrage (qui donne le th�me),"
        		+ "		l'op�ration d'aspectualisation (qui op�re un d�coupage en parties)"
        		+ "		la qualification. Cette derni�re se base sur \"�tre\" (� la boutique �tait la plus importante du quartier �), sur \"avoir\" (� il y avait une �troite all�e encombr�e par les sacs de riz et de sel �) ou sur un verbe d'action (� l'enfant mange une pomme �, � la montagne barre la vue �). Selon Adam, on pourrait ajouter dans la sous-cat�gorie \"�tre\" les \"assimilations\" (ou m�taphores) : � le peuple blanc des villas semble endormi dans le soleil � (Maupassant), qui peut se transcrire en � les villas sont comme un peuple blanc qui est endormi au soleil �.");
        model.addAttribute("route", route);
        Random r = new Random();
        ArrayList<Activity> activityList = new ArrayList<Activity>();
        for(int i=0; i<4; i++){
        	Activity act = new Activity();
        	act.setName("Activit� "+i);
        	act.setId_activity(i+10);
        	
        		act.setLat(48.8534100 + (r.nextDouble()-0.5)*(double)(i+1) / 100.0f);
        		act.setLon(2.347198 + (r.nextDouble()-0.5)*(double)(i+1) / 100.0f);
        	
        	activityList.add(act);
        }
        model.addAttribute("activityTable", activityList);
        */
        
        model.addAttribute("author", route.getAuteur());
        model.addAttribute("route", route);
        model.addAttribute("activityTable", route.getActivites());
//      model.addAttribute("reviews", routeRevService.findRouteReviewsByRoute(route));
        
        
        
        return new ModelAndView("routes/itineraire");
    }

    @RequestMapping(value = "itineraire", method = RequestMethod.POST)
    public ModelAndView postItineraire() {
    	return new ModelAndView("routes/itineraire");
    }

}
