package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class MDPOForm {

    public static Map<String, String> verifForm(HttpServletRequest req) {
	String CHAMP_EMAIL = "email";
	String ERR_CHAMPS = "Le champs email doit être renseigné";
	String ERR = "erreur";
	Map<String, String> erreurs = new HashMap<String, String>();

	// Recuperation des donnees du formulaire
	String email = req.getParameter(CHAMP_EMAIL);

	try {
	    validationEmail(email);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_EMAIL, e.getMessage());
	    else
		erreurs.put(ERR, ERR_CHAMPS);
	}

	return erreurs;
    }

    private static void validationEmail(String email) throws Exception {
	String mailRegex = "^[a-zA-Z0-9\\.\\-\\_]+@[a-zA-Z0-9\\-\\_]+\\.[a-zA-Z]{2,4}$";

	if (email != null && !email.equals("")) {
	    if (!email.matches(mailRegex)) {
		throw new Exception("Merci de saisir une adresse mail valide");
	    }
	} else {
	    throw new Exception("Le champs email doit être renseigné");
	}
    }
}
