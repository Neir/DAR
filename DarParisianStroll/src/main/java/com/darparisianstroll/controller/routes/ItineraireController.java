package com.darparisianstroll.controller.routes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
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
import com.darparisianstroll.domain.User;
import com.darparisianstroll.forms.CreateItineraireForm;
import com.darparisianstroll.service.ActivityService;
import com.darparisianstroll.service.RouteActService;
import com.darparisianstroll.service.RouteService;
import com.darparisianstroll.service.UserService;
import com.darparisianstroll.util.Util;

@Controller
public class ItineraireController {
    public static final String CHAMP_NAME = "name";
    public static final String CHAMP_DESCR = "description";
    public static final String CHAMP_ACT1 = "act1";
    public static final String CHAMP_ACT2 = "act2";
    public static final String CHAMP_ACT3 = "act3";
    public static final String CHAMP_ACT4 = "act4";
    public static final String CHAMP_ACT5 = "act5";
    public static final String CHAMP_ACT6 = "act6";
    public static final String CHAMP_DUREE1 = "duree1";
    public static final String CHAMP_DUREE2 = "duree2";
    public static final String CHAMP_DUREE3 = "duree3";
    public static final String CHAMP_DUREE4 = "duree4";
    public static final String CHAMP_DUREE5 = "duree5";
    public static final String CHAMP_DUREE6 = "duree6";
    public static final String CHAMP_PRIX1 = "prix1";
    public static final String CHAMP_PRIX2 = "prix2";
    public static final String CHAMP_PRIX3 = "prix3";
    public static final String CHAMP_PRIX4 = "prix4";
    public static final String CHAMP_PRIX5 = "prix5";
    public static final String CHAMP_PRIX6 = "prix6";
    public static final String CHAMP_ID_ITINERAIRE = "itineraire";

    @Autowired
    ActivityService activityService;

    @Autowired
    UserService userService;

    @Autowired
    RouteService routeService;

    @Autowired
    RouteActService routeActService;

    private User user = null;
    private int itineraire;

    @RequestMapping(value = "itineraire", method = RequestMethod.GET)
    public ModelAndView getItineraire(HttpServletRequest request,
	    @RequestParam("id") int id, Model model) {
	Route route = routeService.findById(id);

	model.addAttribute("author", userService.findById(route.getUser()));
	model.addAttribute("route", route);

	ArrayList<Activity> activites = new ArrayList<Activity>();

	List<RouteAct> act = routeActService.getByRoute(route);

	for (int i = 1; i <= act.size(); i++) {
	    activites.add(activityService
		    .findById(act.get(i - 1).getActivity()));
	}

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    model.addAttribute("connected", true);
	} else {
	    model.addAttribute("connected", false);
	}

	model.addAttribute("activityTable", activites);
	model.addAttribute("prix", Util.compteCout(act));
	model.addAttribute("duree", Util.compteDuree(act));

	return new ModelAndView("routes/itineraire");
    }

    @RequestMapping(value = "itineraire", method = RequestMethod.POST)
    public ModelAndView postItineraire(HttpServletRequest request) {
	String user_id = Util.getCookieValue(request, "user");

	ModelAndView model = new ModelAndView("routes/itineraire");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }

    @RequestMapping(value = "create_itineraire", method = RequestMethod.GET)
    public ModelAndView getCreateItineraire(HttpServletRequest request) {
	String user_id = Util.getCookieValue(request, "user");
	ModelAndView model = new ModelAndView("routes/create_itineraire");

	if (user_id != null) {
	    user = userService.findById(Integer.parseInt(user_id));

	    ArrayList<String> listeActivites = new ArrayList<String>();

	    List<Activity> actList = activityService.findAllActivities();

	    for (int i = 0; i < actList.size(); i++) {
		listeActivites.add(actList.get(i).getName());
	    }

	    if (!listeActivites.isEmpty())
		model.addObject("listeActivites", listeActivites);

	    model.addObject("connected", true);
	} else {
	    model = new ModelAndView(
		    "compte_utilisateur/connexion_inscription/connexion_inscription");

	    model.addObject("connected", false);
	}

	return model;
    }

    @RequestMapping(value = "create_itineraire", method = RequestMethod.POST)
    public ModelAndView postCreateItineraire(
	    @RequestParam(value = CHAMP_NAME) final String Name,
	    @RequestParam(value = CHAMP_DESCR) final String Description,
	    @RequestParam(value = CHAMP_ACT1) final String act1,
	    @RequestParam(value = CHAMP_ACT2) final String act2,
	    @RequestParam(value = CHAMP_ACT3) final String act3,
	    @RequestParam(value = CHAMP_ACT4) final String act4,
	    @RequestParam(value = CHAMP_ACT5) final String act5,
	    @RequestParam(value = CHAMP_ACT6) final String act6,
	    @RequestParam(value = CHAMP_DUREE1) final String duree1,
	    @RequestParam(value = CHAMP_DUREE2) final String duree2,
	    @RequestParam(value = CHAMP_DUREE3) final String duree3,
	    @RequestParam(value = CHAMP_DUREE4) final String duree4,
	    @RequestParam(value = CHAMP_DUREE5) final String duree5,
	    @RequestParam(value = CHAMP_DUREE6) final String duree6,
	    @RequestParam(value = CHAMP_PRIX1) final String prix1,
	    @RequestParam(value = CHAMP_PRIX2) final String prix2,
	    @RequestParam(value = CHAMP_PRIX3) final String prix3,
	    @RequestParam(value = CHAMP_PRIX4) final String prix4,
	    @RequestParam(value = CHAMP_PRIX5) final String prix5,
	    @RequestParam(value = CHAMP_PRIX6) final String prix6) {

	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;

	// Echapper code HTML s'il existe
	final String name = StringEscapeUtils.escapeHtml4(Name);
	final String description = StringEscapeUtils.escapeHtml4(Description);
	ArrayList<String> act = new ArrayList<String>();
	ArrayList<Integer> duree = new ArrayList<Integer>();
	ArrayList<Double> prix = new ArrayList<Double>();

	// verif formulaire
	erreursMap = CreateItineraireForm.verifForm(name, description);

	if (erreursMap.isEmpty() && act1 != null && !act1.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act1));
	    if (duree1 == null || duree1.isEmpty() || prix1 == null
		    || prix1.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree1)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix1)));
	    }
	} else {
	    erreursMap
		    .put("erreur",
			    "L'Activité 1 est un champ obligatoire, elle doit être complété");
	}
	if (erreursMap.isEmpty() && act2 != null && !act2.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act2));
	    if (duree2 == null || duree2.isEmpty() || prix2 == null
		    || prix2.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree2)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix2)));
	    }
	}
	if (erreursMap.isEmpty() && act3 != null && !act3.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act3));
	    if (duree3 == null || duree3.isEmpty() || prix3 == null
		    || prix3.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree3)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix3)));
	    }
	}
	if (erreursMap.isEmpty() && act4 != null && !act4.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act4));
	    if (duree4 == null || duree4.isEmpty() || prix4 == null
		    || prix4.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree4)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix4)));
	    }
	}
	if (erreursMap.isEmpty() && act5 != null && !act5.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act5));
	    if (duree5 == null || duree5.isEmpty() || prix5 == null
		    || prix5.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree5)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix5)));
	    }
	}
	if (erreursMap.isEmpty() && act6 != null && !act6.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act6));
	    if (duree6 == null || duree6.isEmpty() || prix6 == null
		    || prix6.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree6)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix6)));
	    }
	}

	if (act.isEmpty())
	    erreursMap.put("erreur", "Tous les champs doivent être renseignés");

	ModelAndView model;

	if (erreursMap.isEmpty()) {
	    erreur = false;

	    // chercher les activites
	    ArrayList<Integer> activities_id = new ArrayList<Integer>();

	    for (int i = 0; i < act.size(); i++) {
		activities_id.add(activityService.findByName(act.get(i))
			.getId_activity());
	    }

	    if (act.size() != activities_id.size()) {
		erreur = true;

		erreursMap
			.put("erreur",
				"Une erreur est survenue, veuillez renouveller l'essais");
		// ajouter l'erreur et rediriger vers la page
		model = new ModelAndView("routes/create_itineraire");
		model.addObject("erreur", erreur);
		model.addObject("erreursMap", erreursMap);
		return model;
	    }

	    // ajout nouvel itineraire
	    Route route = new Route();

	    route.setName(name);
	    route.setDescription(description);
	    route.setUser(user.getUser_id());

	    routeService.saveRoute(route);

	    // mettre a jour la table route_act
	    for (int i = 0; i < activities_id.size(); i++) {
		RouteAct ra = new RouteAct();
		ra.setRoute(route.getRoute_id());
		ra.setActivity(activities_id.get(i));
		ra.setDuree(duree.get(i));
		ra.setPrix(prix.get(i));
		routeActService.saveRouteAct(ra);
	    }

	    model = new ModelAndView("routes/itineraire?id="
		    + route.getRoute_id());

	} else {
	    model = new ModelAndView("routes/create_itineraire");

	    // ajouter l'erreur et rediriger vers la page
	    model.addObject("erreur", erreur);
	    model.addObject("erreursMap", erreursMap);
	}

	model.addObject("connected", true);

	return model;
    }

    @RequestMapping(value = "modifier_supprimer_itineraire", method = RequestMethod.GET)
    public ModelAndView getModifierItineraire(HttpServletRequest request,
	    @RequestParam(value = CHAMP_ID_ITINERAIRE) final String Itineraire) {
	Map<String, String> erreursMap = new HashMap<String, String>();

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    user = userService.findById(Integer.parseInt(user_id));
	} else {
	    // redirection vers la page de connexion
	    ModelAndView model = new ModelAndView(
		    "compte_utilisateur/connexion_inscription/connexion_inscription");
	    model.addObject("connected", false);
	    return model;
	}

	ModelAndView model = new ModelAndView(
		"routes/modifier_supprimer_itineraire");

	// Echapper code HTML s'il existe
	itineraire = Integer
		.parseInt(StringEscapeUtils.escapeHtml4(Itineraire));

	// Recuperer itineraire concerne
	Route route = routeService.findById(itineraire);

	if (route != null) {
	    // verifier que le user courant est bien proprietaire de
	    // l'itineraire
	    if (user.getUser_id() != route.getUser()) {
		erreursMap
			.put("erreur",
				"Vous tentez d'accéder à un itinéraire dont vous n'êtes pas propriétaire !");
		model.addObject("erreur", true);
		model.addObject("erreursMap", erreursMap);
		return model;
	    }

	    model.addObject("name", route.getName());
	    model.addObject("description", route.getDescription());

	    List<RouteAct> act = routeActService.getByRoute(route);

	    for (int i = 1; i <= act.size(); i++) {
		model.addObject("act" + i,
			activityService.findById(act.get(i - 1).getActivity())
				.getName());
		model.addObject("duree" + i, act.get(i - 1).getDuree());
		model.addObject("prix" + i, act.get(i - 1).getPrix());
	    }
	} else {
	    erreursMap.put("erreur",
		    "Un problème est survenu veuillez réessayer");
	    model.addObject("erreur", true);
	    model.addObject("erreursMap", erreursMap);
	}

	model.addObject("connected", true);

	return model;
    }

    @RequestMapping(value = "modifier_supprimer_itineraire", method = RequestMethod.POST)
    public ModelAndView POSTModifierItineraire(
	    @RequestParam(value = CHAMP_NAME) final String Name,
	    @RequestParam(value = CHAMP_DESCR) final String Description,
	    @RequestParam(value = CHAMP_ACT1) final String act1,
	    @RequestParam(value = CHAMP_ACT2) final String act2,
	    @RequestParam(value = CHAMP_ACT3) final String act3,
	    @RequestParam(value = CHAMP_ACT4) final String act4,
	    @RequestParam(value = CHAMP_ACT5) final String act5,
	    @RequestParam(value = CHAMP_ACT6) final String act6,
	    @RequestParam(value = CHAMP_DUREE1) final String duree1,
	    @RequestParam(value = CHAMP_DUREE2) final String duree2,
	    @RequestParam(value = CHAMP_DUREE3) final String duree3,
	    @RequestParam(value = CHAMP_DUREE4) final String duree4,
	    @RequestParam(value = CHAMP_DUREE5) final String duree5,
	    @RequestParam(value = CHAMP_DUREE6) final String duree6,
	    @RequestParam(value = CHAMP_PRIX1) final String prix1,
	    @RequestParam(value = CHAMP_PRIX2) final String prix2,
	    @RequestParam(value = CHAMP_PRIX3) final String prix3,
	    @RequestParam(value = CHAMP_PRIX4) final String prix4,
	    @RequestParam(value = CHAMP_PRIX5) final String prix5,
	    @RequestParam(value = CHAMP_PRIX6) final String prix6) {

	// Echapper code HTML s'il existe
	final String name = StringEscapeUtils.escapeHtml4(Name);
	final String description = StringEscapeUtils.escapeHtml4(Description);
	Map<String, String> erreursMap = new HashMap<String, String>();
	ArrayList<String> act = new ArrayList<String>();
	ArrayList<Integer> duree = new ArrayList<Integer>();
	ArrayList<Double> prix = new ArrayList<Double>();

	// verifier les champs
	erreursMap = CreateItineraireForm.verifForm(name, description);

	if (erreursMap.isEmpty() && act1 != null && !act1.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act1));
	    if (duree1 == null || duree1.isEmpty() || prix1 == null
		    || prix1.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree1)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix1)));
	    }
	} else {
	    erreursMap
		    .put("erreur",
			    "L'Activité 1 est un champ obligatoire, elle doit être complété");
	}
	if (erreursMap.isEmpty() && act2 != null && !act2.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act2));
	    if (duree2 == null || duree2.isEmpty() || prix2 == null
		    || prix2.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree2)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix2)));
	    }
	}
	if (erreursMap.isEmpty() && act3 != null && !act3.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act3));
	    if (duree3 == null || duree3.isEmpty() || prix3 == null
		    || prix3.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree3)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix3)));
	    }
	}
	if (erreursMap.isEmpty() && act4 != null && !act4.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act4));
	    if (duree4 == null || duree4.isEmpty() || prix4 == null
		    || prix4.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree4)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix4)));
	    }
	}
	if (erreursMap.isEmpty() && act5 != null && !act5.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act5));
	    if (duree5 == null || duree5.isEmpty() || prix5 == null
		    || prix5.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree5)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix5)));
	    }
	}
	if (erreursMap.isEmpty() && act6 != null && !act6.isEmpty()) {
	    act.add(StringEscapeUtils.escapeHtml4(act6));
	    if (duree6 == null || duree6.isEmpty() || prix6 == null
		    || prix6.isEmpty()) {
		erreursMap
			.put("erreur",
				"Tous les champs d'une activité doivent être complétés");
	    } else {
		duree.add(Integer.parseInt(StringEscapeUtils
			.escapeHtml4(duree6)));
		prix.add(Double.parseDouble(StringEscapeUtils
			.escapeHtml4(prix6)));
	    }
	}

	if (act.isEmpty())
	    erreursMap.put("erreur", "Tous les champs doivent être renseignés");

	ModelAndView model = new ModelAndView(
		"routes/modifier_supprimer_itineraire");

	if (erreursMap.isEmpty()) {
	    // mettre a jour la base de donnee
	    Route route = routeService.findById(itineraire);

	    List<RouteAct> r_act = routeActService.getByRoute(route);

	    if (r_act.size() != act.size()) {
		model.addObject("name", route.getName());
		model.addObject("description", route.getDescription());

		for (int i = 1; i <= r_act.size(); i++) {
		    model.addObject(
			    "act" + i,
			    activityService.findById(
				    r_act.get(i - 1).getActivity()).getName());
		    model.addObject("duree" + i, r_act.get(i - 1).getDuree());
		    model.addObject("prix" + i, r_act.get(i - 1).getPrix());
		}

		erreursMap.put("erreur",
			"Toutes les activités doivent être renseignés");
		model.addObject("erreur", true);
		model.addObject("erreursMap", erreursMap);
		return model;
	    } else {
		// update route
		route.setName(name);
		route.setDescription(description);
		routeService.updateRoute(route);

		model.addObject("name", route.getName());
		model.addObject("description", route.getDescription());

		// update RouteAct list dans BD
		for (int i = 1; i <= r_act.size(); i++) {
		    r_act.get(i - 1).setDuree(duree.get(i - 1));
		    r_act.get(i - 1).setPrix(prix.get(i - 1));
		    routeActService.updateRouteAct(r_act.get(i - 1));

		    model.addObject(
			    "act" + i,
			    activityService.findById(
				    r_act.get(i - 1).getActivity()).getName());
		    model.addObject("duree" + i, r_act.get(i - 1).getDuree());
		    model.addObject("prix" + i, r_act.get(i - 1).getPrix());
		}
	    }
	} else {
	    model.addObject("erreur", true);
	    model.addObject("erreursMap", erreursMap);
	}

	model.addObject("connected", true);

	return model;
    }

    @RequestMapping(value = "supprimer_itineraire", method = RequestMethod.GET)
    public ModelAndView POSTSupprimerItineraire() {
	// supprimer les activites de l'itineraire dans route_act
	Route route = routeService.findById(itineraire);

	List<RouteAct> r_act = routeActService.getByRoute(route);

	for (int i = 0; i < r_act.size(); i++) {
	    routeActService.deleteRouteAct(r_act.get(i));
	}

	// supprimer itineraire
	routeService.deleteRoute(route);
	ModelAndView model = new ModelAndView("routes/liste_itineraires");
	model.addObject("connected", true);
	return model;
    }
}
