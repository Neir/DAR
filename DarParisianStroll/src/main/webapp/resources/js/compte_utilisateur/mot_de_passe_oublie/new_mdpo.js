/**
 * Verifie que le mot de passe et la confirmation sont egaux
 */
function verifMdp(motDePasse_id){
	var mdp = document.getElementById(motDePasse_id).value;
	var confMdp = document.getElementById('confMotDePasse').value;
	
	if(mdp == confMdp)
		return true;
	
	return false;
}

/**
 * Verifie que tous les champs du formulaire sont bien renseignes
 */
function verifForm(motDePasse_id, leg_name, form_name){
	var formulaire = document.forms[form_name];
	var text, bloc;
	var a=false;
	
	for(var i=1; i<(formulaire.length-1); i++){
		if(formulaire[i].value=="" || formulaire[i].value==null){
			text = document.createTextNode("Tous les champs doivent \352tre renseign\351s");
			a=true;
		}
	}
	
	
	if(document.getElementById(motDePasse_id).value.length < 6){
		text = document.createTextNode("Le mot de passe doit contenir au moins 6 caract\350res");
	}
	else if(!a){
		if(verifMdp(motDePasse_id))
			return true;
		else
			text = document.createTextNode("Les deux mots de passe fournis sont diff\351rents");
	}
	
	//Afficher le message d'erreur
	var leg = document.getElementById(leg_name);
	var sp = document.createElement('span');
	
	if(document.getElementById('divErreur')){
		//pour supprimer un eventuel avertissement precedement affiche
		bloc = document.getElementById('divErreur');
		bloc.removeChild(bloc.firstChild);
	}
	else{
		bloc = document.createElement('div');
		bloc.setAttribute("id", "divErreur");
	}
	
	sp.appendChild(text);
	sp.style.color = "red";
	bloc.appendChild(sp);
	leg.parentNode.insertBefore(bloc, leg.nextSibling);
	return false;
}