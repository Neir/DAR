package com.darparisianstroll.controller.compteUtilisateur.profil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfilController {

    @RequestMapping(value = "profil", method = RequestMethod.GET)
    public ModelAndView getProfil() {
	return new ModelAndView("compte_utilisateur/profil/profil");
    }

    @RequestMapping(value = "profil", method = RequestMethod.POST)
    public ModelAndView postProfil() {
	return new ModelAndView("compte_utilisateur/profil/profil");
    }

}
