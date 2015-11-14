package com.darparisianstroll.controller.compteUtilisateur;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.forms.MDPOForm;
import com.darparisianstroll.mail.EmailTest;
import com.darparisianstroll.service.UserService;
import com.darparisianstroll.util.Util;

/**
 * Controller de la page mot de passe oublie
 *
 */
@Controller
public class MdpoController {
    public static final String CHAMP_EMAIL = "email";

    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    /**
     * Controlleur methode Get de la page de mot de passe oublie
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @return la page de mot de passe oublie
     */
    @RequestMapping(value = "mdpo", method = RequestMethod.GET)
    public ModelAndView getMdpo(HttpServletRequest request) {
	String user_id = Util.getCookieValue(request, "user");

	ModelAndView model = new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/mdpo");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }

    /**
     * Controlleur methode Post de la page de mot de passe oublie
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @param Email
     *            email de l'utilisateur
     * @return page de confirmation
     */
    @RequestMapping(value = "mdpo", method = RequestMethod.POST)
    public ModelAndView postMdpo(HttpServletRequest request,
	    @RequestParam(value = CHAMP_EMAIL) final String Email) {
	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;

	// Echapper code HTML s'il existe
	final String email = StringEscapeUtils.escapeHtml4(Email);

	// Verification des saisies
	erreursMap = MDPOForm.verifForm(email);

	if (erreursMap.isEmpty()) {
	    erreur = false;

	    if (!userService.isRegistred(email)) {
		erreur = true;
		erreursMap
			.put("MDPOERR",
				"Le mail fourni n'existe pas dans notre base de"
					+ " donnee.\nVeuillez le ressaisir de nouveau ");
	    } else {
		// affecter un code au mail pour la servlet NouveauMDP
		String codeMail = new Integer(new Double(
			Math.random() * 456709689).intValue() + 1767)
			.toString();
		servletContext.setAttribute(codeMail, email);

		// Envoi du mail
		EmailTest
			.sendEmail(
				email,
				"Parisian Stroll: Reinitialisation mot de passe",
				"Bonjour,\n\nPour reinitialiser votre mot de passe"
					+ " veuillez suivre ce lien:\n"
					+ "http://darparisianstroll.elasticbeanstalk.com/new_mdpo?a="
					+ codeMail + "\n\nCordialement");
	    }
	}

	ModelAndView model;

	if (erreur) {
	    model = new ModelAndView(
		    "compte_utilisateur/mot_de_passe_oublie/mdpo");

	    model.addObject("erreur", erreur);
	    model.addObject("erreursMap", erreursMap);
	} else
	    model = new ModelAndView(
		    "compte_utilisateur/mot_de_passe_oublie/confirmation_mail_mdpo");

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }

}
