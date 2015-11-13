/**
 * Verifie que la syntaxe du mail est correcte
 */
function verifEmail(email_id) {
	//pattern representant une adresse mail correcte
	var pattern = /^[a-zA-Z0-9\.\-\_]+@[a-zA-Z0-9\-\_]+\.[a-zA-Z]{2,4}$/;
	var email = document.getElementById(email_id).value;

	if (email == "" || pattern.test(email)) {
		//syntaxe correcte, on colorie le texte en noir
		document.getElementById(email_id).style.color = "black";
	} else {
		//syntaxe incorrecte, on colorie le texte en rouge
		document.getElementById(email_id).style.color = "red";
	}
}

/**
 * Verifie que tous les champs du formulaire sont bien renseignes
 */
function verifForm(leg_name, form_name) {
	var formulaire = document.forms[form_name];
	var text = null, bloc;
	var a = false;

	for (var i = 1; i < (formulaire.length - 1); i++) {
		if (formulaire[i].value == "" || formulaire[i].value == null) {
			text = document
					.createTextNode("Tous les champs doivent \352tre renseign\351s");
			a=true;
		}
	}

	if (!a && document.getElementById('email').style.color == "red") {
		text = document
				.createTextNode("Merci de saisir une adresse mail valide");
	}
	else if (!a && document.getElementById('email').value.length > 40) {
		text = document
				.createTextNode("Merci de saisir une adresse mail de taille maximale de 40 caract\350res");
	}
	else if (!a && document.getElementById('identifiant').value.length > 40) {
		text = document
				.createTextNode("Merci de saisir un identifiant de taille maximale de 40 caract\350res");
	}

	//Afficher le message d'erreur
	var leg = document.getElementById(leg_name);
	var sp = document.createElement('span');

	if (document.getElementById('divErreur')) {
		//pour supprimer un eventuel avertissement precedement affiche
		bloc = document.getElementById('divErreur');
		bloc.removeChild(bloc.firstChild);
	} else {
		bloc = document.createElement('div');
		bloc.setAttribute("id", "divErreur");
	}

	if (text) {
		sp.appendChild(text);
		sp.style.color = "red";
		bloc.appendChild(sp);
		leg.parentNode.insertBefore(bloc, leg.nextSibling);
		return false;
	}

	return true;
}

function modifierForm() {
	if (document.getElementById('identifiant').getAttribute('disabled')) {
		// demande de modification
		document.getElementById('identifiant').removeAttribute('disabled');
		document.getElementById('email').removeAttribute('disabled');
		document.getElementById('email').setAttribute('onkeyup',
				'verifEmail(\'email\')');
		document.getElementById('modifier').setAttribute('id', 'valider');
		document.getElementById('valider').textContent = 'valider';
		console.log('false');
		return false;
	} else {
		// demande de validation du formulaire
		// verification des formulaires
		return verifForm("leg", "Myform");
	}
}