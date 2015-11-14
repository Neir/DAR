package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe de verification du formulaire d'inscription
 *
 */
public class InscriptionForm {

    /**
     * Methode verifiant le formulaire
     * 
     * @param username
     *            contenu champ username
     * @param email
     *            contenu champ email
     * @param motDePasse
     *            contenu champ motDePasse
     * @param confMDP
     *            contenu champ confMDP
     * @return Map d'erreurs
     */
    public static Map<String, String> verifForm(String username, String email,
	    String motDePasse, String confMDP) {
	String CHAMP_USERNAME = "identifiant1";
	String CHAMP_EMAIL = "email";
	String CHAMP_MDP = "motDePasse1";
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

    /**
     * validation du username
     * 
     * @param username
     *            champ username
     * @throws Exception
     */
    @SuppressWarnings("null")
    private static void validationUsername(String username) throws Exception {
	if (username == null && username.equals(""))
	    throw new Exception("Tous les champs doivent être renseignés");
	else if (username.length() > 40) {
	    throw new Exception(
		    "Merci de saisir un identifiant de taille maximale de 40 caractères");
	}
    }

    /**
     * validation de l'email
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
	    throw new Exception("Tous les champs doivent être renseignés");
	}
    }

    /**
     * validation du motDePasse
     * 
     * @param motDePasse
     *            champ motDePasse
     * @param confMotDePasse
     *            champ confMotDePasse
     * @throws Exception
     */
    private static void validationMotsDePasse(String motDePasse,
	    String confMotDePasse) throws Exception {
	if (motDePasse != null && !motDePasse.equals("")
		&& confMotDePasse != null && !confMotDePasse.equals("")) {
	    if (motDePasse.length() < 6) {
		throw new Exception(
			"Le mot de passe doit contenir au moins 6 caractères");
	    } else if (motDePasse.length() > 200) {
		throw new Exception(
			"Merci de saisir un mot de passe de taille maximale de 200 caractères");
	    } else if (!motDePasse.equals(confMotDePasse)) {
		throw new Exception(
			"Les deux mots de passe fournis sont différents");
	    }
	} else {
	    throw new Exception("Tous les champs doivent être renseignés");
	}
    }
}
