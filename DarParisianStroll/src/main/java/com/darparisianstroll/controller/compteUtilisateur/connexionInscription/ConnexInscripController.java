package com.darparisianstroll.controller.compteUtilisateur.connexionInscription;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.forms.ConnexionForm;
import com.darparisianstroll.forms.InscriptionForm;

@Controller
public class ConnexInscripController {
    public static final String CHAMP_USERNAME = "identifiant";
    public static final String CHAMP_EMAIL = "email1";
    public static final String CHAMP_MDP_INSCR = "motDePasse1";
    public static final String CHAMP_MDP_CONNEX = "motDePasse2";

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

    @RequestMapping(value = "connexion", method = RequestMethod.POST)
    public ModelAndView postConnex(
	    @RequestParam(value = CHAMP_USERNAME) final String username,
	    @RequestParam(value = CHAMP_MDP_CONNEX) final String motDePasse) {
	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;

	// Verification des saisies
	erreursMap = ConnexionForm.verifForm(username, motDePasse);

	return new ModelAndView("hello");
    }

    @RequestMapping(value = "inscription", method = RequestMethod.POST)
    public ModelAndView postInscrip(
	    @RequestParam(value = CHAMP_USERNAME) final String username,
	    @RequestParam(value = CHAMP_EMAIL) final String email,
	    @RequestParam(value = CHAMP_MDP_INSCR) final String motDePasse) {
	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;

	// Verification des saisies
	erreursMap = InscriptionForm.verifForm(username, email, motDePasse,
		"confMotDePasse");

	if (erreursMap.isEmpty()) {
	    // ajout a la base de donnee "en attente"

	    if (erreur && erreursMap.isEmpty())
		erreursMap
			.put("inscriptionERR",
				"Un problème a survenu l'ors de la tentative d'inscription\nVeuillez réessayer");
	    else if (erreursMap.isEmpty()) {
		// envois du mail
	    }

	}

	// redirection vers la page de confirmation 1
	ModelAndView model = new ModelAndView(
		"compte_utilisateur/connexion_inscription/confirmation_inscription");
	model.addObject(CHAMP_USERNAME, username);
	model.addObject(CHAMP_EMAIL, email);
	model.addObject(CHAMP_MDP_INSCR, motDePasse);
	model.addObject("erreur", erreur);
	model.addObject("erreursMap", erreursMap);

	return model;
    }

}