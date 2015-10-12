package com.darparisianstroll.controller.compteUtilisateur.connexionInscription;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConnexInscripController {

    @RequestMapping(value = "connexion_inscription", method = RequestMethod.GET)
    public ModelAndView getConnexInscrip() {
	return new ModelAndView(
		"compte_utilisateur/connexion_inscription/connexion_inscription");
    }

    @RequestMapping(value = "connexion_inscription", method = RequestMethod.POST)
    public ModelAndView postConnexInscrip() {
	return new ModelAndView(
		"compte_utilisateur/connexion_inscription/connexion_inscription");
    }

}