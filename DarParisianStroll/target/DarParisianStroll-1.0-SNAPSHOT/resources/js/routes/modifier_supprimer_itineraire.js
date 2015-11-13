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
		text = document.createTextNode("Tous les champs doivent \352tre renseign\351s");
	}
	else if(document.getElementById('name').length > 40 
		|| document.getElementById('description').length > 40
		|| document.getElementById('act1').length > 40 ){
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

function modifierForm() {

	if (document.getElementById('name').getAttribute('disabled')) {
		var legg = document.getElementById('leg');
		var inn;
		
		// demande de modification
		document.getElementById('name').removeAttribute('disabled');
		document.getElementById('description').removeAttribute('disabled');
		
		if(document.getElementById('act1')){
			document.getElementById('duree1').removeAttribute('disabled');
			document.getElementById('prix1').removeAttribute('disabled');
		}
		else{
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "act1");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "duree1");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "prix1");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
		}
		
		if(document.getElementById('act2')){
			document.getElementById('duree2').removeAttribute('disabled');
			document.getElementById('prix2').removeAttribute('disabled');
		}
		else{
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "act2");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "duree2");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "prix2");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
		}
		
		if(document.getElementById('act3')){
			document.getElementById('duree3').removeAttribute('disabled');
			document.getElementById('prix3').removeAttribute('disabled');
		}
		else{
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "act3");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "duree3");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "prix3");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
		}
		
		if(document.getElementById('act4')){
			document.getElementById('duree4').removeAttribute('disabled');
			document.getElementById('prix4').removeAttribute('disabled');
		}
		else{
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "act4");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "duree4");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "prix4");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
		}
		
		if(document.getElementById('act5')){
			document.getElementById('duree5').removeAttribute('disabled');
			document.getElementById('prix5').removeAttribute('disabled');
		}
		else{
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "act5");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "duree5");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "prix5");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
		}
		
		if(document.getElementById('act6')){
			document.getElementById('duree6').removeAttribute('disabled');
			document.getElementById('prix6').removeAttribute('disabled');
		}
		else{
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "act6");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "duree6");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
			inn = document.createElement('input');
			inn.setAttribute("type", "hidden");
			inn.setAttribute("name", "prix6");
			legg.parentNode.insertBefore(inn, legg.nextSibling);
		}
		
		document.getElementById('modifier').setAttribute('id', 'valider');
		document.getElementById('valider').textContent = 'valider';
		return false;
	} else {
		// demande de validation du formulaire
		// verification des formulaires
		if(document.getElementById('act1')){
			document.getElementById('act1').removeAttribute('disabled');
		}
		if(document.getElementById('act2')){
			document.getElementById('act2').removeAttribute('disabled');
		}
		if(document.getElementById('act3')){
			document.getElementById('act3').removeAttribute('disabled');
		}
		if(document.getElementById('act4')){
			document.getElementById('act4').removeAttribute('disabled');
		}
		if(document.getElementById('act5')){
			document.getElementById('act5').removeAttribute('disabled');
		}
		if(document.getElementById('act6')){
			document.getElementById('act6').removeAttribute('disabled');
		}

		return verifForm("leg", "Myform");
	}
}