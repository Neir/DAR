package com.darparisianstroll.controller.compteUtilisateur.motDePasseOublie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfMdpoController {

    @RequestMapping(value = "confirmation_mdpo", method = RequestMethod.GET)
    public ModelAndView getConfMdpo() {
	return new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/confirmation_mdpo");
    }

    @RequestMapping(value = "confirmation_mdpo", method = RequestMethod.POST)
    public ModelAndView postConfMdpo() {
	return new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/confirmation_mdpo");
    }

}
