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
		<link rel="stylesheet" href="<c:url value="/resources/css/compte_utilisateur/connexion_inscription/confirmation_inscription.css"/>" media="screen"/>
		<!-- Faire fonctionner les balises structurantes de HTML5 -->
    	<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
		<title>Confirmation Inscription</title>
		
		<style type="text/css">
      		body
			{
			    background-repeat:no-repeat;
			    background-size:cover;
				width: 800px;
    			margin: auto;
    			margin-top : 20%;
			    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
			    font-size: 16px;
			}
    	</style>
	</head>
	<body style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
		<jsp:include page="../../header.jsp">
			<jsp:param name="page_active" value="confirmation_mail_inscription" />
			<jsp:param name="connected" value="${connected}" />
		</jsp:include>
		
		<div class="container" id="message">
	      <h3><span style="color:white;">Un mail vient de vous être envoyé, veuillez le consulter afin de valider votre inscription.</span></h3>
	      <div id="lien">
			<div><a href="hello">retourner à la page d'acceuil</a></div>
	      </div>
	    </div>	
	</body>
</html>