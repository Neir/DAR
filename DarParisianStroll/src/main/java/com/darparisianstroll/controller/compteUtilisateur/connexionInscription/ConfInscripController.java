package com.darparisianstroll.controller.compteUtilisateur.connexionInscription;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfInscripController {

    @RequestMapping(value = "confirmation_inscription", method = RequestMethod.GET)
    public ModelAndView getConfInscrip() {
	return new ModelAndView(
		"compte_utilisateur/connexion_inscription/confirmation_inscription");
    }

    @RequestMapping(value = "confirmation_inscription", method = RequestMethod.POST)
    public ModelAndView postConfInscrip() {
	return new ModelAndView(
		"compte_utilisateur/connexion_inscription/confirmation_inscription");
    }

}
