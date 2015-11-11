<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<jsp:include page="../../import.jsp"></jsp:include>
    	<meta http-equiv="content-type" content="text/html; charset=utf-8">
    	<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="<c:url value="/resources/css/compte_utilisateur/mot_de_passe_oublie/new_mdpo.css"/>" media="screen"/>
		<script src="<c:url value="/resources/js/compte_utilisateur/mot_de_passe_oublie/new_mdpo.css" />"></script>
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
		<jsp:include page="../../header.jsp">
			<jsp:param name="page_active" value="new_mdpo" />
			<jsp:param name="connected" value="${connected}" />
		</jsp:include>
	
		<div class="container">
      		<form name="Myform" action="new_mdpo" method="post" onsubmit="return verifForm('motDePasse', 'leg', 'Myform');">
				<fieldset>
		  			<legend id="leg"><span style="color:white;">Réinitialiser mot de passe</span></legend>
		  			
		  			<c:if test="${erreur == true}">
		   				<div class="form-group input-group">
				  			<span id="divErreur" style="color: red;" class="input-group-addon">
				  		  		<c:forEach items="${erreursMap}" var="err">
				  		  			<c:out value="${err.value}"/> </br>
				  		  		</c:forEach>
				  			</span>
				  	  	</div>
					</c:if>
		  			
		  			<label for="password"><span class="requis">*</span></label>
				    <div class="form-group input-group">
			              <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
				      <input type="password" class="form-control"  id="motDePasse" name="motDePasse" placeholder="mot de passe">
				    </div>
				    
				    <label for="password"><span class="requis">*</span></label>
				    <div class="form-group input-group">
			              <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
				      <input type="password" class="form-control"  id="confMotDePasse" name="confMotDePasse" placeholder="confirmation mot de passe">
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