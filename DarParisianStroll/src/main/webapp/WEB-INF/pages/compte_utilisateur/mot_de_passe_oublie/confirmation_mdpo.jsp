<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<!-- Bootstrap -->
    	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" media="screen"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/compte_utilisateur/mot_de_passe_oublie/confirmation_mdpo.css"/>" media="screen"/>
		<!-- Faire fonctionner les balises structurantes de HTML5 -->
    	<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
		<title>Réinitialiser mot de passe</title>
		
		<style type="text/css">
      		body
			{
			    background-repeat:no-repeat;
			    background-size:cover;
			    width: 400px;
    			margin: auto;
    			margin-top : 20%;
			    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
			    font-size: 16px;
			}
    	</style>
	</head>
	<body style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
		<div class="container" id="message">
	      <h4><span style="color:white;">Le mot de passe vient d'être modifié avec succès</span></h4>
	
	      <div id="lien">
		<div><a href="hello">retourner à la page d'Acceuil</a></div>
	      </div>
	    </div>
	</body>
</html>