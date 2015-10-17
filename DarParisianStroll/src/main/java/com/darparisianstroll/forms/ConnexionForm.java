package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

public final class ConnexionForm {

    public static Map<String, String> verifForm(String username,
	    String motDePasse) {
	String CHAMP_USERNAME = "identifiant2";
	String CHAMP_PASS = "motDePasse2";
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
	    validationMotsDePasse(motDePasse);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_PASS, e.getMessage());
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
	else if (username.length() > 40) {
	    throw new Exception(
		    "Merci de saisir un identifiant de taille maximale de 40 caractères");
	}
    }

    private static void validationMotsDePasse(String motDePasse)
	    throws Exception {
	if (motDePasse != null && !motDePasse.equals("")) {
	    if (motDePasse.length() < 6) {
		throw new Exception(
			"Le mot de passe doit contenir au moins 6 caractères");
	    } else if (motDePasse.length() > 200) {
		throw new Exception(
			"Merci de saisir un mot de passe de taille maximale de 200 caractères");
	    }
	} else {
	    throw new Exception("Tous les champs doivent être renseignés");
	}
    }

}
