package com.darparisianstroll.controller.compteUtilisateur.motDePasseOublie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MdpoController {

    @RequestMapping(value = "mdpo", method = RequestMethod.GET)
    public ModelAndView getMdpo() {
	System.out.println("mdpoGET");
	return new ModelAndView("compte_utilisateur/mot_de_passe_oublie/mdpo");
    }

    @RequestMapping(value = "mdpo", method = RequestMethod.POST)
    public ModelAndView postMdpo() {
	System.out.println("mdpoPOST");
	return new ModelAndView("compte_utilisateur/mot_de_passe_oublie/mdpo");
    }

}
