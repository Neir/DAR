package com.darparisianstroll.forms;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe de verification du formulaire d'ajout du nouveau mot de passe
 *
 */
public class NewMDPOForm {

    /**
     * Methode verifiant le formulaire
     * 
     * @param motDePasse
     *            contenu champ motDePasse
     * @param confMDP
     *            contenu champ confMDP
     * @return Map d'erreurs
     */
    public static Map<String, String> verifForm(String motDePasse,
	    String confMDP) {
	String CHAMP_MDP = "motDePasse";
	String ERR_CHAMPS = "Tous les champs doivent être renseignés";
	String ERR = "erreur";
	Map<String, String> erreurs = new HashMap<String, String>();

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
