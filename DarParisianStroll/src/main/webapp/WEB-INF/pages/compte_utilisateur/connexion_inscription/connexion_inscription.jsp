<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" media="screen"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/compte_utilisateur/connexion_inscription/connexion_inscription.css"/>" media="screen"/>
    <script src="<c:url value="/resources/js/compte_utilisateur/connexion_inscription/connexion_inscription.js" />"></script>
    <title>Connexion/Inscription</title>
    
    <style type="text/css">
      body
      {
      	background-repeat:no-repeat;
      	background-size:cover;
      	margin-top : 8%;
      	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
      	font-size: 16px;
      }
    </style>
  </head>
  <body style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
    <div style="display:table">

      <div id="divInscription">
		<form name="Myform1" class="contact-us form-horizontal" action="confirmation_inscription" method="post" onsubmit="return verifForm('email1','motDePasse1','legInscription', 'Myform1');">
		  
		  <fieldset>
		    <legend id="legInscription"><span style="color:white;">Inscription</span></legend>
		    
		    <label for="identifiant"><span class="requis">*</span></label>
		    <div class="form-group input-group">
	              <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
		      <input type="text" class="form-control" id="identifiant" name="identifiant" placeholder="identifiant">
		    </div>
		    
		    <label for="email"><span class="requis">*</span></label>
		    <div class="form-group input-group">
	              <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
		      <input type="email" class="form-control"  id="email1" name="email1" placeholder="email" onkeyup="verifEmail('email1')">
		    </div>
		    
		    <label for="password"><span class="requis">*</span></label>
		    <div class="form-group input-group">
	              <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		      <input type="password" class="form-control"  id="motDePasse1" name="motDePasse1" placeholder="mot de passe">
		    </div>
		    
		    <label for="password"><span class="requis">*</span></label>
		    <div class="form-group input-group">
	              <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		      <input type="password" class="form-control"  id="confMotDePasse" name="confMotDePasse" placeholder="confirmation mot de passe">
		    </div>
		    
		    <div>
		      <button type="submit" class="btn btn-primary" id="valider">valider</button>
		    </div>
		  </fieldset>
		</form>
      </div>
      
      <div id="divConnexion">
		<form name="Myform2" class="contact-us form-horizontal" action="connexion_inscription" method="post" onsubmit="return verifForm('email1','motDePasse1','legConnexion', 'Myform2');">
		  <fieldset>
		    <legend id='legConnexion'><span style="color:white;">Connexion</span></legend>
		    
		    <label for="email"><span class="requis">*</span></label>
		    <div class="form-group input-group">
		      <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
		      <input type="email" class="form-control"  id="email2" name="email2" placeholder="email" onkeyup="verifEmail('email2')">
		    </div>
		    
		    <label for="password"><span class="requis">*</span></label>
		    <div class="form-group input-group">
		      <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
		      <input type="password" class="form-control" id="motDePasse2" name="motDePasse2" placeholder="mot de passe">
		    </div>
		    
		    <div class="control-group">
		      <button type="submit" class="btn btn-primary form-group input-group" id="connexion">connexion</button>
		    </div>
		  </fieldset>
		  
		  <div id="liens">
		    <div><a class="form-group input-group" href="mdpo">mot de passe oublié ?</a></div>
		  </div>
		</form>
      </div>
  </body>
</html>
