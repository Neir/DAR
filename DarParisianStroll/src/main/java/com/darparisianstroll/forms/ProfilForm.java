package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

public class ProfilForm {
    public static Map<String, String> verifForm(String username, String email) {
	String CHAMP_USERNAME = "identifiant";
	String CHAMP_EMAIL = "email";
	String ERR_CHAMPS = "Tous les champs doivent être renseignés";
	String ERR = "erreur";

	Map<String, String> erreurs = new HashMap<String, String>();

	try {
	    validationUsername(username);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_USERNAME, e.getMessage());
	    else if (erreurs.get(ERR) == null) {
		erreurs.put(ERR, ERR_CHAMPS);
	    }
	}

	try {
	    validationEmail(email);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_EMAIL, e.getMessage());
	    else if (erreurs.get(ERR) == null) {
		erreurs.put(ERR, ERR_CHAMPS);
	    }
	}

	return erreurs;
    }

    @SuppressWarnings("null")
    private static void validationUsername(String username) throws Exception {
	if (username == null || username.equals(""))
	    throw new Exception("Tous les champs doivent être renseignés");
	else if (username.length() > 40) {
	    throw new Exception(
		    "Merci de saisir un identifiant de taille maximale de 40 caractères");
	}
    }

    private static void validationEmail(String email) throws Exception {
	String mailRegex = "^[a-zA-Z0-9\\.\\-\\_]+@[a-zA-Z0-9\\-\\_]+\\.[a-zA-Z]{2,4}$";

	if (email != null && !email.equals("")) {
	    if (!email.matches(mailRegex)) {
		throw new Exception("Merci de saisir une adresse mail valide");
	    } else if (email.length() > 40) {
		throw new Exception(
			"Merci de saisir une adresse mail de taille maximale de 40 caractères");
	    }
	} else {
	    throw new Exception("Tous les champs doivent être renseignés");
	}
    }
}
