<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<!-- Bootstrap -->
    	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" media="screen"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/compte_utilisateur/mot_de_passe_oublie/mdpo.css"/>" media="screen"/>
		<script src="<c:url value="/resources/js/compte_utilisateur/mot_de_passe_oublie/mdpo.js" />"></script>
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
			    width: 300px;
    			margin: auto;
    			margin-top : 20%;
			    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
			    font-size: 16px;
			}
    	</style>
	</head>
	<body style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
		<div class="container">
      		<form name="Myform" action="mdpo" method="post" onsubmit="return verifForm('email', 'leg', 'Myform');">
				<fieldset>
		  			<legend id="leg"><span style="color:white;">Réinitialiser mot de passe</span></legend>
		  			
		  			<label for="email"><span class="requis">*</span></label>
		    		<div class="form-group input-group">
	              		<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-envelope"></span>
	              		</span>
		      			<input type="email" class="form-control"  id="email" name="email" placeholder="email" onkeyup="verifEmail('email')">
		    		</div>
		  
		  			<div>
	    				<button type="submit" class="btn btn-primary" id="valider">
	    					<span style="color:white;">valider</span>
	    				</button>
	  				</div>
		  		</fieldset>
			</form>
		</div>
	</body>
</html>