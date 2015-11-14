package com.darparisianstroll.controller.compteUtilisateur;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.darparisianstroll.domain.User;
import com.darparisianstroll.forms.NewMDPOForm;
import com.darparisianstroll.service.UserService;
import com.darparisianstroll.util.Util;

/**
 * Controller de la page de creation d'un nouveau mot de passe
 *
 */
@Controller
public class NewMdpoController {
    public static final String CHAMP_MDP = "motDePasse";
    public static final String CONF_MDP = "confMotDePasse";

    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    /**
     * Controlleur methode Get de la page de creation d'un nouveau mot de passe
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @param response
     *            contient les informations concernant la reponse HTTP
     * @param CodeMail
     *            cle utilisateur
     * @return page de creation d'un nouveau mot de passe
     */
    @RequestMapping(value = "new_mdpo", method = RequestMethod.GET)
    public ModelAndView getNewMdpo(HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam(value = "a") final String CodeMail) {
	String emailCookie = null;

	// Echapper code HTML s'il existe
	final String codeMail = StringEscapeUtils.escapeHtml4(CodeMail);

	if (codeMail != null) {
	    // recuperation de l'adresse mail
	    emailCookie = (String) servletContext.getAttribute(codeMail);
	    response.addCookie(new Cookie("email", emailCookie));
	}

	ModelAndView model = new ModelAndView(
		"compte_utilisateur/mot_de_passe_oublie/new_mdpo");

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	model.addObject("emailU", emailCookie);
	return model;
    }

    /**
     * Controlleur methode Post de la page de creation d'un nouveau mot de passe
     * 
     * @param request
     *            contient les informations concernant la requete HTTP
     * @param MotDePasse
     *            mot de passe de l'utilisateur
     * @param ConfMotDePasse
     *            confirmation de mot de passe de l'utilisateur
     * @param emailCookie
     *            cookie contenant l'email
     * @return page de confirmation
     */
    @RequestMapping(value = "new_mdpo", method = RequestMethod.POST)
    public ModelAndView postNewMdpo(HttpServletRequest request,
	    @RequestParam(value = CHAMP_MDP) final String MotDePasse,
	    @RequestParam(value = CONF_MDP) final String ConfMotDePasse,
	    @CookieValue("email") String emailCookie) {

	Map<String, String> erreursMap = new HashMap<String, String>();
	boolean erreur = true;

	// Echapper code HTML s'il existe
	final String motDePasse = StringEscapeUtils.escapeHtml4(MotDePasse);
	final String confMotDePasse = StringEscapeUtils
		.escapeHtml4(ConfMotDePasse);

	// Verification des saisies
	erreursMap = NewMDPOForm.verifForm(motDePasse, confMotDePasse);

	// enregistrement du nouveau mdp si aucun souci
	if (emailCookie == null || emailCookie.isEmpty()) {
	    erreursMap.put("MDPOERR",
		    "Un probleme est survenu veuillez reessayer de nouveau");
	} else {
	    erreur = false;
	    User user = userService.findByEmail(emailCookie);
	    user.setPassword(Util.MD5("ajdikchetdysuncklplq869785SHFhjv"
		    + motDePasse + "dysuncklpl"));
	    userService.updateUser(user);
	}

	ModelAndView model = null;

	if (erreur) {
	    model = new ModelAndView(
		    "compte_utilisateur/mot_de_passe_oublie/new_mdpo");
	    model.addObject("erreur", erreur);
	    model.addObject("erreursMap", erreursMap);
	} else {
	    model = new ModelAndView(
		    "compte_utilisateur/mot_de_passe_oublie/confirmation_mdpo");
	}

	String user_id = Util.getCookieValue(request, "user");

	if (user_id != null) {
	    model.addObject("connected", true);
	} else {
	    model.addObject("connected", false);
	}

	return model;
    }
}
