package com.darparisianstroll.controller.compteUtilisateur;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.User;
import com.darparisianstroll.domain.enums.State;
import com.darparisianstroll.forms.ConnexionForm;
import com.darparisianstroll.forms.InscriptionForm;
import com.darparisianstroll.mail.EmailTest;
import com.darparisianstroll.service.UserService;
import com.darparisianstroll.util.Util;

@Controller
public class ConnexInscripController {
    public static final String CHAMP_USERNAME_INSCR = "identifiant1";
    public static final String CHAMP_USERNAME_CONNEX = "identifiant2";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_MDP_INSCR = "motDePasse1";
    public static final String CHAMP_MDP_CONNEX = "motDePasse2";
    public static final String CHAMP_CONFIRMATION_MDP = "confMotDePasse";

    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @RequestMapping(value = "connexion_inscription", method = RequestMethod.GET)
    public ModelAndView getConnexInscr() {
	return new ModelAndView(
		"compte_utilisateur/connexion_inscription/connexion_inscription");
    }

    @RequestMapping(value = "connexion_inscription", method = RequestMethod.POST)
    public ModelAndView postConnexInscr() {
	return new ModelAndView(
		"compte_utilisateur/connexion_inscription/connexion_inscription");
    }

    @RequestMapping(value = "deconnexion", method = RequestMethod.GET)
    public ModelAndView getDeconnexInscr(HttpServletRequest request,
	    HttpServletResponse response) {

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    System.out.println("supprimer cookie");
	    Util.deleteCookie(request, response, "user");
	}

	return new ModelAndView(
		"compte_utilisateur/connexion_inscription/connexion_inscription");
    }

    @RequestMapping(value = "inscription", method = RequestMethod.POST)
    public ModelAndView postInscrip(
	    @RequestParam(value = CHAMP_USERNAME_INSCR) final String Username,
	    @RequestParam(value = CHAMP_EMAIL) final String Email,
	    @RequestParam(value = CHAMP_MDP_INSCR) final String MotDePasse,
	    @RequestParam(value = CHAMP_CONFIRMATION_MDP) final String ConfMDP) {
	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;
	User user = null;

	// Echapper code HTML s'il existe
	final String username = StringEscapeUtils.escapeHtml4(Username);
	final String email = StringEscapeUtils.escapeHtml4(Email);
	final String motDePasse = StringEscapeUtils.escapeHtml4(MotDePasse);
	final String confMDP = StringEscapeUtils.escapeHtml4(ConfMDP);

	// Verification des saisies
	erreursMap = InscriptionForm.verifForm(username, email, motDePasse,
		confMDP);

	if (erreursMap.isEmpty()) {
	    erreur = false;

	    // verifier si le mail fourni existe dans la base
	    if (userService.isRegistred(email)) {
		erreur = true;
		erreursMap
			.put("mailERR",
				"Le mail fourni existe déjà dans notre base, veuillez choisir un mail différent");
	    } else {
		// ajout du client a la base de donnee, etat "en attente"
		user = new User();
		user.setUsername(username);
		user.setMail(email);
		user.setPassword(Util.MD5(motDePasse));
		user.setState(State.attente);

		userService.saveUser(user);

		String codeUser = new Integer(new Double(
			Math.random() * 456709689).intValue() + 1767)
			.toString();

		// enregistrement du code correspondant au user
		servletContext.setAttribute(codeUser, user);

		// Envoi du mail
		EmailTest
			.sendEmail(
				email,
				"Parisian Stroll: Validation inscription",
				"Bonjour,\n\nPour valider votre inscription"
					+ " veuillez suivre ce lien:\n"
					+ "http://localhost:8080/DarParisianStroll/validation_inscription?a="
					+ codeUser + "\n\nCordialement");
	    }

	}

	ModelAndView model;

	if (!erreursMap.isEmpty()) {
	    // redirection vers la page d'inscription
	    model = new ModelAndView(
		    "compte_utilisateur/connexion_inscription/connexion_inscription");
	    model.addObject(CHAMP_USERNAME_INSCR, username);
	    model.addObject(CHAMP_EMAIL, email);
	    model.addObject("erreurInscr", erreur);
	    model.addObject("erreursMap", erreursMap);
	} else {
	    // redirection vers la page de confirmation 1
	    model = new ModelAndView(
		    "compte_utilisateur/connexion_inscription/confirmation_mail_inscription");
	}

	return model;
    }

    @RequestMapping(value = "connexion", method = RequestMethod.POST)
    public ModelAndView postConnex(HttpServletResponse response,
	    @RequestParam(value = CHAMP_USERNAME_CONNEX) final String Username,
	    @RequestParam(value = CHAMP_MDP_CONNEX) final String MotDePasse) {
	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;
	User user = null;

	// Echapper code HTML s'il existe
	final String username = StringEscapeUtils.escapeHtml4(Username);
	final String motDePasse = StringEscapeUtils.escapeHtml4(MotDePasse);

	// Verification des saisies
	erreursMap = ConnexionForm.verifForm(username, motDePasse);

	if (erreursMap.isEmpty()) {
	    erreur = false;

	    // verification dans la base de donnee
	    if (!userService.isRegistred(username, Util.MD5(motDePasse))) {
		erreur = true;
		erreursMap.put("connexionERR",
			"Identifiant ou mot de passe incorrect");
	    }
	}

	ModelAndView model;

	if (!erreursMap.isEmpty()) {
	    // redirection vers la page de connexion
	    model = new ModelAndView(
		    "compte_utilisateur/connexion_inscription/connexion_inscription");
	    model.addObject(CHAMP_USERNAME_CONNEX, username);
	    model.addObject("erreurConnex", erreur);
	    model.addObject("erreursMap", erreursMap);
	} else {
	    user = userService.findByUsername(username);
	    response.addCookie(new Cookie("user", "" + user.getUser_id()));
	    // redirection vers la page d'acceuil
	    model = new ModelAndView("hello");
	}

	return model;
    }

    @RequestMapping(value = "verif_inscription", method = RequestMethod.GET)
    public ModelAndView getVerifInscr(HttpServletResponse response,
	    @RequestParam(value = CHAMP_EMAIL) final String Email) {

	final String email = StringEscapeUtils.escapeHtml4(Email);

	try {
	    // verifier si le mail fourni existe dans la base
	    if (userService.isRegistred(email)) {
		response.getWriter().write("true");
	    } else {
		response.getWriter().write("false");
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}

	return null;
    }

    @RequestMapping(value = "validation_inscription", method = RequestMethod.GET)
    public ModelAndView getValidInscrip(
	    @RequestParam(value = "a") final String CodeUser) {
	User user = null;
	boolean erreur = false;

	// Echapper code HTML s'il existe
	final String codeUser = StringEscapeUtils.escapeHtml4(CodeUser);

	if (codeUser != null) {
	    // recuperation de l'utilisateur concerne
	    user = (User) servletContext.getAttribute(codeUser);
	} else
	    erreur = true;

	if (user != null) {
	    // modification de l'etat de l'agent, passe de "attente" a "membre"
	    user.setState(State.membre);
	    userService.updateUser(user);
	} else
	    erreur = true;

	ModelAndView model;

	model = new ModelAndView(
		"compte_utilisateur/connexion_inscription/confirmation_inscription");
	model.addObject("erreur", erreur);

	return model;
    }
}