package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

public class CreateItineraireForm {
    public static Map<String, String> verifForm(String name, String description) {
	String CHAMP_NAME = "name";
	String CHAMP_DESCR = "description";
	String ERR_CHAMPS = "Tous les champs doivent être renseignés";
	String ERR = "erreur";

	Map<String, String> erreurs = new HashMap<String, String>();

	try {
	    validationChamps(name);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_NAME, e.getMessage());
	    else if (erreurs.get(ERR) == null) {
		erreurs.put(ERR, ERR_CHAMPS);
	    }
	}

	try {
	    validationDescription(description);
	} catch (Exception e) {
	    if (!e.getMessage().equals(ERR_CHAMPS))
		erreurs.put(CHAMP_DESCR, e.getMessage());
	    else if (erreurs.get(ERR) == null) {
		erreurs.put(ERR, ERR_CHAMPS);
	    }
	}

	return erreurs;
    }

    @SuppressWarnings("null")
    private static void validationChamps(String champs) throws Exception {
	if (champs == null || champs.equals(""))
	    throw new Exception("Tous les champs doivent être renseignés");
	else if (champs.length() > 40) {
	    throw new Exception(
		    "Tous les champs mis à part le champs description, supportent une taille maximale de 40 caractères");
	}
    }

    private static void validationDescription(String description)
	    throws Exception {
	if (description == null || description.equals(""))
	    throw new Exception("Veuillez entrer une description");
    }
}
