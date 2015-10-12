/**
 * Verifie que la syntaxe du mail est correcte
 */
function verifEmail(email_id){
	//pattern representant une adresse mail correcte
	var pattern = /^[a-zA-Z0-9\.\-\_]+@[a-zA-Z0-9\-\_]+\.[a-zA-Z]{2,4}$/;
	var email = document.getElementById(email_id).value;
	
	if(email=="" || pattern.test(email)){
		//syntaxe correcte, on colorie le texte en noir
		document.getElementById(email_id).style.color = "black";
	}
	else{
		//syntaxe incorrecte, on colorie le texte en rouge
		document.getElementById(email_id).style.color = "red";
	}
}

/**
 * Verifie que tous les champs du formulaire sont bien renseignes
 */
function verifForm(email_id, leg_name, form_name){
	var formulaire = document.forms[form_name];
	var text, bloc;
	var a=false;
	
	for(var i=1; i<(formulaire.length-1); i++){
		if(formulaire[i].value=="" || formulaire[i].value==null){
			text = document.createTextNode("Tous les champs doivent \352tre renseign\351s");
			a=true;
		}
	}
	
	if(document.getElementById(email_id).style.color == "red"){
		text = document.createTextNode("Merci de saisir une adresse mail valide");
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