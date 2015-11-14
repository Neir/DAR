package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe de verification du formulaire de mot de passe oublie
 *
 */
public class MDPOForm {

    /**
     * Methode verifiant le formulaire
     * 
     * @param email
     *            contenu champ email
     * @return Map d'erreurs
     */
    public static Map<String, String> verifForm(String email) {
	String CHAMP_EMAIL = "email";
	String ERR_CHAMPS = "Le champs email doit être renseigné";
	String ERR = "erreur";
	Map<String, String> erreurs = new HashMap<String, String>();

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

    /**
     * verification email
     * 
     * @param email
     *            champ email
     * @throws Exception
     */
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
	    throw new Exception("Le champs email doit être renseigné");
	}
    }
}
