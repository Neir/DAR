package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class NewMDPOForm {

    public static Map<String, String> verifForm(HttpServletRequest req) {
	String CHAMP_MDP = "motDePasse";
	String CHAMP_CONFMDP = "confMotDePasse";
	String ERR_CHAMPS = "Tous les champs doivent être renseignés";
	String ERR = "erreur";
	Map<String, String> erreurs = new HashMap<String, String>();

	// Recuperation des donnees du formulaire
	String motDePasse = req.getParameter(CHAMP_MDP);
	String confMDP = req.getParameter(CHAMP_CONFMDP);

	try {
	    validationMotsDePasse(motDePasse, confMDP);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_MDP, e.getMessage());
	    else
		erreurs.put(ERR, ERR_CHAMPS);
	}

	return erreurs;
    }

    private static void validationMotsDePasse(String motDePasse,
	    String confMotDePasse) throws Exception {
	if (motDePasse != null && !motDePasse.equals("")
		&& confMotDePasse != null && !confMotDePasse.equals("")) {
	    if (motDePasse.length() < 6) {
		throw new Exception(
			"Le mot de passe doit contenir au moins 6 caractères");
	    }
	    if (!motDePasse.equals(confMotDePasse)) {
		throw new Exception(
			"Les deux mots de passe fournis sont différents");
	    }
	} else {
	    throw new Exception("Tous les champs doivent être renseignés");
	}
    }
}
