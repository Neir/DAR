package com.darparisianstroll.controller.compteUtilisateur.motDePasseOublie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ConfMailMdpoController {

    @RequestMapping(value = "/confirmation_mail_mdpo", method = RequestMethod.GET)
    public ModelAndView getConfMailMdpo() {
	return new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/confirmation_mail_mdpo");
    }

    @RequestMapping(value = "/confirmation_mail_mdpo", method = RequestMethod.POST)
    public ModelAndView postConfMailMdpo() {
	return new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/confirmation_mail_mdpo");
    }

}
