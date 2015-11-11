$(document).ready(function() {
	$("#act1").select2({})
	$("#act2").select2({})
	$("#act3").select2({})
	$("#act4").select2({})
	$("#act5").select2({})
	$("#act6").select2({})
});

/**
 * Verifie que tous les champs du formulaire sont bien renseignes
 */
function verifForm(leg_name, form_name) {
	var formulaire = document.forms[form_name];
	var text = null, bloc;

	// Verifier que tous les champs obligatoires sont bien remplis
	if (document.getElementById('name').value == "" 
		|| document.getElementById('name').value == null
		|| document.getElementById('description').value == "" 
		|| document.getElementById('description').value == null
		|| document.getElementById('act1').value == "" 
		|| document.getElementById('act1').value == null) {
			text = document
					.createTextNode("Tous les champs doivent \352tre renseign\351s");
	}
	else if(document.getElementById('name').length > 40 
			|| document.getElementById('description').length > 40){
		text = document.createTextNode("Tous les champs mis \341 part le champs description, supportent une taille maximale de 40 caract\350res");
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