<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<jsp:include page="../import.jsp"></jsp:include>
    	<meta http-equiv="content-type" content="text/html; charset=utf-8">
    	<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    	<link rel="stylesheet" href="<c:url value="/resources/select2-3.5.4/select2.css"/>" media="screen"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/routes/create_itineraire.css"/>" media="screen"/>
		<script src="<c:url value="/resources/js/jquery-1.11.3.js" />"></script>
		<script src="<c:url value="/resources/select2-3.5.4/select2.min.js" />"></script>
		<script src="<c:url value="/resources/js/routes/create_itineraire.js" />"></script>
		<!-- Faire fonctionner les balises structurantes de HTML5 -->
    	<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
		<title>Créer itinéraire</title>
		
		<style type="text/css">
      		body
			{
			    background-repeat:no-repeat;
			    background-size:cover;
    			margin: auto;
    			margin-top : 5%;
			    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
			    font-size: 16px;
			}
    	</style>
	</head>
	<body style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
		<jsp:include page="../header.jsp">
			<jsp:param name="page_active" value="create_itineraire" />
			<jsp:param name="connected" value="${connected}" />
		</jsp:include>
	
		<div class="container">
      		<form name="Myform" action="create_itineraire" method="post" onsubmit="return verifForm('leg','Myform');" style="margin:0 auto">
				<fieldset>
		  			<legend id="leg"><span style="color:rgb(154, 139, 228);">Nouvel intinéraire</span></legend>
		  			
		  			<c:if test="${erreur == true}">
		   				<div class="form-group input-group" style="width:600px;">
				  			<span id="divErreur" style="color: red;" class="input-group-addon">
				  		  		<c:forEach items="${erreursMap}" var="err">
				  		  			<c:out value="${err.value}"/> </br>
				  		  		</c:forEach>
				  			</span>
				  	  	</div>
					</c:if>
					
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="name" name="name" placeholder="Nom itinéraire">
		    		</div>
		  			
		    		<div class="form-group input-group" style="width:600px;">
	              		<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<textarea class="form-control" style="height: 150px;" id="description" name="description" placeholder="Description"></textarea>
		    		</div>
		    		
		    		</br><span style="color:white;">Activité 1 <span class="requis">*</span></span></br>
					
					<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
						<select id="act1" name="act1" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
							<option> </option>
							<c:forEach items="${listeActivites}" var="act">
				  		 		<option value="${act}">${act}</option>
				  			</c:forEach>
    					</select>
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="duree1" name="duree1" placeholder="Durée en nombre d'heures (ex: 2)">
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="prix1" name="prix1" placeholder="Prix (ex: 120)">
		    		</div>
		    		
		    		</br><span style="color:white;">Activité 2</span></br>
		    		
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
						<select id="act2" name="act2" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
							<option> </option>
							<c:forEach items="${listeActivites}" var="act">
				  		 		<option value="${act}">${act}</option>
				  			</c:forEach>
    					</select>
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="duree2" name="duree2" placeholder="Durée en nombre d'heures (ex: 2)">
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="prix2" name="prix2" placeholder="Prix (ex: 120)">
		    		</div>
		    		
		    		</br><span style="color:white;">Activité 3</span></br>
		    		
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
						<select id="act3" name="act3" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
							<option> </option>
							<c:forEach items="${listeActivites}" var="act">
				  		 		<option value="${act}">${act}</option>
				  			</c:forEach>
    					</select>
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="duree3" name="duree3" placeholder="Durée en nombre d'heures (ex: 2)">
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="prix3" name="prix3" placeholder="Prix (ex: 120)">
		    		</div>
		    		
		    		</br><span style="color:white;">Activité 4</span></br>
		    		
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
						<select id="act4" name="act4" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
							<option> </option>
							<c:forEach items="${listeActivites}" var="act">
				  		 		<option value="${act}">${act}</option>
				  			</c:forEach>
    					</select>
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="duree4" name="duree4" placeholder="Durée en nombre d'heures (ex: 2)">
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="prix4" name="prix4" placeholder="Prix (ex: 120)">
		    		</div>
		    		
		    		</br><span style="color:white;">Activité 5</span></br>
		    		
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
						<select id="act5" name="act5" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
							<option> </option>
							<c:forEach items="${listeActivites}" var="act">
				  		 		<option value="${act}">${act}</option>
				  			</c:forEach>
    					</select>
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="duree5" name="duree5" placeholder="Durée en nombre d'heures (ex: 2)">
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="prix5" name="prix5" placeholder="Prix (ex: 120)">
		    		</div>
		    		
		    		</br><span style="color:white;">Activité 6</span></br>
		    		
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
						<select id="act6" name="act6" class="form-control select2-allow-clear select2-offscreen" tabindex="-1">
							<option> </option>
							<c:forEach items="${listeActivites}" var="act">
				  		 		<option value="${act}">${act}</option>
				  			</c:forEach>
    					</select>
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="duree6" name="duree6" placeholder="Durée en nombre d'heures (ex: 2)">
		    		</div>
		    		<div class="form-group input-group">
		    			<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="prix6" name="prix6" placeholder="Prix (ex: 120)">
		    		</div>
		    		
		    		<div>
					    <button type="submit" class="btn btn-primary" id="valider">
					      <span style="color:white;">Valider</span>
					    </button>
					</div>
		  		</fieldset>
			</form>
		</div>
	</body>
</html>