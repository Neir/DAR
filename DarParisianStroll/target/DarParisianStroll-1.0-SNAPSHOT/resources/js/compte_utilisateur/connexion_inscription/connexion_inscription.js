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
function verifForm1(motDePasse_id, leg_name, form_name){
	var formulaire = document.forms[form_name];
	var text, bloc;
	var a=false;
	
	for(var i=1; i<(formulaire.length-1); i++){
		if(formulaire[i].value=="" || formulaire[i].value==null){
			text = document.createTextNode("Tous les champs doivent \352tre renseign\351s");
			a=true;
		}
	}
	
	if(!a){
		// verifier si l'adresse mail se trouve deja dans la base de donnee
		var xhr = new XMLHttpRequest();
		var url = 'http://localhost:8080/DarParisianStroll/verif_inscription?email='+document.getElementById('email').value;
		
		xhr.open('get', url , false);
		
		xhr.onreadystatechange = function() {
		  // Ready state 4 means the request is done
		  if (xhr.readyState === 4) {
		    if (xhr.status === 200) {
		    	if(xhr.responseText == "true"){
		    		// email existant dans la base
		    		text = document.createTextNode("Adresse mail d\351j\340 existante, veuillez vous connectez \340 l'aide vos identifiant et mot de passe");
		    		a=true;
		    	}
		    }
		  }
		}
		
		xhr.send(null);
	}
	
	if(!a && document.getElementById('email').style.color == "red"){
		text = document.createTextNode("Merci de saisir une adresse mail valide");
	}
	else if (!a && document.getElementById('email').value.length > 40) {
		text = document
				.createTextNode("Merci de saisir une adresse mail de taille maximale de 40 caract\350res");
	}
	else if (!a && document.getElementById('identifiant1').value.length > 40) {
		text = document
				.createTextNode("Merci de saisir un identifiant de taille maximale de 40 caract\350res");
	}
	else if(!a && document.getElementById(motDePasse_id).value.length < 6){
		text = document.createTextNode("Le mot de passe doit contenir au moins 6 caract\350res");
	}
	else if(!a){
		if(document.getElementById(motDePasse_id).value.length > 200){
			alert(motDePasse_id);
			alert(document.getElementById(motDePasse_id).value.length);
			text = document.createTextNode("Merci de saisir un mot de passe de taille maximale de 200 caract\350res");
		}
		else if(verifMdp(motDePasse_id)){
			return true;
		}
		else{
			text = document.createTextNode("Les deux mots de passe fournis sont diff\351rents");
		}
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

function verifForm2(motDePasse_id, leg_name, form_name){
	var formulaire = document.forms[form_name];
	var text, bloc;
	var a=false;
	
	for(var i=1; i<(formulaire.length-1); i++){
		if(formulaire[i].value=="" || formulaire[i].value==null){
			text = document.createTextNode("Tous les champs doivent \352tre renseign\351s");
			a=true;
		}
	}
	
	if (!a && document.getElementById('identifiant2').value.length > 40) {
		text = document
				.createTextNode("Merci de saisir un identifiant de taille maximale de 40 caract\350res");
	}
	else if(!a && document.getElementById(motDePasse_id).value.length < 6){
		text = document.createTextNode("Le mot de passe doit contenir au moins 6 caract\350res");
	}
	else if(!a && document.getElementById(motDePasse_id).value.length > 200){
		text = document.createTextNode("Merci de saisir un mot de passe de taille maximale de 200 caract\350res");
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