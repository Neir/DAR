package com.darparisianstroll.controller.compteUtilisateur.motDePasseOublie;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class MdpoController {

    @RequestMapping(value = "/mdpo", method = RequestMethod.GET)
    public ModelAndView getMdpo() {
	return new ModelAndView("compte_utilisateur/mot_de_passe_oublie/mdpo");
    }

    @RequestMapping(value = "/mdpo", method = RequestMethod.POST)
    public ModelAndView postMdpo() {
	return new ModelAndView("compte_utilisateur/mot_de_passe_oublie/mdpo");
    }

}
