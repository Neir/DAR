package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

public class InscriptionForm {

    public static Map<String, String> verifForm(String username, String email,
	    String motDePasse, String confMDP) {
	String CHAMP_USERNAME = "identifiant";
	String CHAMP_EMAIL = "email";
	String CHAMP_MDP = "motDePasse1";
	String CHAMP_CONFMDP = "confMotDePasse";
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

	try {
	    validationMotsDePasse(motDePasse, confMDP);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_MDP, e.getMessage());
	    else if (erreurs.get(ERR) == null) {
		erreurs.put(ERR, ERR_CHAMPS);
	    }
	}

	return erreurs;
    }

    @SuppressWarnings("null")
    private static void validationUsername(String username) throws Exception {
	if (username == null && username.equals(""))
	    throw new Exception("Tous les champs doivent être renseignés");
    }

    private static void validationEmail(String email) throws Exception {
	String mailRegex = "^[a-zA-Z0-9\\.\\-\\_]+@[a-zA-Z0-9\\-\\_]+\\.[a-zA-Z]{2,4}$";

	if (email != null && !email.equals("")) {
	    if (!email.matches(mailRegex)) {
		throw new Exception("Merci de saisir une adresse mail valide");
	    }
	} else {
	    throw new Exception("Tous les champs doivent être renseignés");
	}
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
