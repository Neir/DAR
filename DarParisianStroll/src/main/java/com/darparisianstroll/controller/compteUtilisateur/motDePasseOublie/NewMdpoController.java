package com.darparisianstroll.controller.compteUtilisateur.motDePasseOublie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewMdpoController {

    @RequestMapping(value = "new_mdpo", method = RequestMethod.GET)
    public ModelAndView getNewMdpo() {
	return new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/new_mdpo");
    }

    @RequestMapping(value = "new_mdpo", method = RequestMethod.POST)
    public ModelAndView postNewMdpo() {
	return new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/new_mdpo");
    }

}
