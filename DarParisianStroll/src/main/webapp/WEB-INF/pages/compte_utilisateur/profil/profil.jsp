<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<!-- Bootstrap -->
    	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" media="screen"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/compte_utilisateur/profil/profil.css"/>" media="screen"/>
		<script src="<c:url value="/resources/js/compte_utilisateur/profil/profil.js" />"></script>
		<!-- Faire fonctionner les balises structurantes de HTML5 -->
    	<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
		<title>Profil</title>
		
		<style type="text/css">
      		body
			{
			    background-repeat:no-repeat;
			    background-size:cover;
			    width: 300px;
    			margin: auto;
    			margin-top : 5%;
			    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
			    font-size: 16px;
			}
    	</style>
	</head>
	<body style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
		<div class="container">
      		<form name="Myform" action="profil" method="post">
				<fieldset>
		  			<legend id="leg"><span style="color:red;">Profil</span></legend>
		  			
		  			<c:if test="${erreur == true}">
		   				<div class="form-group input-group">
				  			<span id="divErreur" style="color: red;" class="input-group-addon">
				  		  		<c:forEach items="${erreursMap}" var="err">
				  		  			<c:out value="${err.value}"/> </br>
				  		  		</c:forEach>
				  			</span>
				  	  	</div>
					</c:if>
					
		    		<div class="form-group input-group">
	              		<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-user"></span>
	              		</span>
		      			<input type="identifiant" class="form-control"  id="identifiant" name="identifiant" value="<c:out value="${identifiant}"/>" disabled="disabled" >
		    		</div>
		  			
		    		<div class="form-group input-group">
	              		<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-envelope"></span>
	              		</span>
		      			<input type="email" class="form-control"  id="email" name="email" value="<c:out value="${email}"/>" disabled="disabled">
		    		</div>
		    		
		    		<div>
					    <button type="submit" class="btn btn-primary" id="modifier" onclick="return modifierForm()">
					      <span style="color:white;">modifier</span>
					    </button>
					</div>
					
					<div id="lien"><a href="mdpo"><span style="color:white;">modifier mot de passe</a></span></div>
		  		</fieldset>
			</form>
			
			<c:if test="${routesItineraires != null}">
				<form>
					<fieldset>
				      <legend><span style="color:red;">Mes derniers itinéraires</span></legend>
					  
					  <div class="form-group input-group">
					  	<c:forEach items="${routesItineraires}" var="i">
				  		  	<span><a href="itineraire?id=<c:out value="${i.route_id}"/>"><c:out value="${i.name}"/></a> </br></span>
				  		</c:forEach>
					  </div>
					</fieldset>
				</form>
			</c:if>
			
			<c:if test="${routesCommentaires != null}">
				<form>
					<fieldset>
				      <legend><span style="color:red;">Mes derniers commentaires</span></legend>
					  
					  <div class="form-group input-group">
					    <c:forEach items="${routesCommentaires}" var="i">
				  		  	<span><a href="itineraire?id=<c:out value="${i.route_id}"/>"><c:out value="${i.name}"/></a> </br></span>
				  		  	<span style="color:white;"><c:out value="${ commentaires[cpt] }"/></br></span>
				  		  	<%
				  		  		if(request.getAttribute("cpt").equals("0"))
				  		  		    request.setAttribute("cpt", "1");
				  		  		else
				  		  		    request.setAttribute("cpt", "2");
				  		  	%>
				  		</c:forEach>
					  </div>
					</fieldset>
				</form>
			</c:if>
		</div>
	</body>
</html>