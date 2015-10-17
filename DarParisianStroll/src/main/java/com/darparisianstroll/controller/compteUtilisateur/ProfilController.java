package com.darparisianstroll.controller.compteUtilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.Route;
import com.darparisianstroll.domain.RouteReview;
import com.darparisianstroll.domain.User;
import com.darparisianstroll.forms.ProfilForm;
import com.darparisianstroll.service.RouteActService;
import com.darparisianstroll.service.RouteReviewService;
import com.darparisianstroll.service.RouteService;
import com.darparisianstroll.service.UserService;
import com.darparisianstroll.util.Util;

@Controller
public class ProfilController {
    public static final String CHAMP_USERNAME = "identifiant";
    public static final String CHAMP_EMAIL = "email";

    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @Autowired
    RouteService routeService;

    @Autowired
    RouteActService routeActService;

    @Autowired
    RouteReviewService routeReviewService;

    @RequestMapping(value = "profil", method = RequestMethod.GET)
    public ModelAndView getProfil(HttpServletRequest request,
	    HttpServletResponse response) {

	ArrayList<Route> routesItineraires = new ArrayList<Route>();
	ArrayList<Route> routesCommentaires = new ArrayList<Route>();
	ArrayList<String> commentaires = new ArrayList<String>();
	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = false;
	String identifiant = "mohamed.af";
	String email = "mohamed.af@hotmail.fr";
	User user = null;

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    user = userService.findById(Integer.parseInt(user_id));
	} else {
	    // redirection vers la page de connexion
	    return new ModelAndView(
		    "compte_utilisateur/connexion_inscription/connexion_inscription");
	}

	// recuperation de l'utilsateur concerne
	// User user = userService.findByEmail(email);

	if (user == null) {
	    erreur = true;
	    erreursMap
		    .put("ProfilERR",
			    "Un probleme est survenu empechant le chargement correct de la page"
				    + "</br>Veuillez reessayer de nouveau dans quelques instants ");
	} else {
	    response.addCookie(new Cookie("email", email));

	    // recuperer les itineraires de user s'ils existent
	    List<Route> routes = routeService.getByUser(user);

	    // recuperer les trois derniers itineraires s'ils existent
	    for (int i = (routes.size() - 1); i >= 0
		    && i >= (routes.size() - 3); i--) {
		routesItineraires.add(routes.get(i));
		System.out.println(routes.get(i).getName());
	    }

	    // recuperer la liste des commentaires
	    List<RouteReview> routesReview = routeReviewService.getByUser(user);

	    /*
	     * recuperer les itineraires des trois derniers commentaires s'ils
	     * existent, ainsi que du contenu de ces derniers
	     */
	    for (int i = (routesReview.size() - 1); i >= 0
		    && i >= (routesReview.size() - 3); i--) {
		routesCommentaires.add(routeService.findById(routesReview
			.get(i).getItineraire()));
		System.out.println(routesCommentaires.get(0).getName());
		commentaires.add(routesReview.get(i).getDescription());

	    }
	}

	ModelAndView model = new ModelAndView(
		"compte_utilisateur/profil/profil");
	model.addObject("identifiant", identifiant);
	model.addObject("email", email);
	if (!routesItineraires.isEmpty())
	    model.addObject("routesItineraires", routesItineraires);
	if (!routesCommentaires.isEmpty())
	    model.addObject("routesCommentaires", routesCommentaires);
	if (!commentaires.isEmpty()) {
	    model.addObject("commentaires", commentaires);
	    model.addObject("cpt", "0");
	}
	model.addObject("erreur", erreur);
	model.addObject("erreursMap", erreursMap);

	return model;
    }

    @RequestMapping(value = "profil", method = RequestMethod.POST)
    public ModelAndView postProfil(HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam(value = CHAMP_USERNAME) final String username,
	    @RequestParam(value = CHAMP_EMAIL) final String email,
	    @CookieValue("email") String emailCookie) {
	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;

	// verification du formulaire
	erreursMap = ProfilForm.verifForm(username, email);

	ModelAndView model = this.getProfil(request, response);

	if (erreursMap.isEmpty()) {
	    // mettre a jour la base de donnee
	    User user = userService.findByEmail(emailCookie);
	    user.setMail(email);
	    user.setUsername(username);
	    userService.updateUser(user);
	} else {
	    // ajouter l'erreur et rediriger vers la page
	    model.addObject("erreur", erreur);
	    model.addObject("erreursMap", erreursMap);
	}

	// redirection vers la page
	return model;
    }
}
