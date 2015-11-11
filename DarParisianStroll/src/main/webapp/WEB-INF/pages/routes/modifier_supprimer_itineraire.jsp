<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<!-- Bootstrap -->
    	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" media="screen"/>
		<link rel="stylesheet" href="<c:url value="/resources/css/routes/modifier_supprimer_itineraire.css"/>" media="screen"/>
		<script src="<c:url value="/resources/js/routes/modifier_supprimer_itineraire.js" />"></script>
		<!-- Faire fonctionner les balises structurantes de HTML5 -->
    	<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->
		<title>Modifier/Supprimer itinéraire</title>
		
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
		<div class="container">
      		<form name="Myform" action="modifier_supprimer_itineraire" method="post" style="margin:0 auto; width:400px;" onsubmit="return modifierForm();">
				<fieldset>
		  			<legend id="leg"><span style="color:rgb(154, 139, 228);">Modifier/Supprimer itinéraire</span></legend>
		  			
		  			<c:if test="${erreur == true}">
		   				<div class="form-group input-group">
				  			<span id="divErreur" style="color: red;" class="input-group-addon">
				  		  		<c:forEach items="${erreursMap}" var="err">
				  		  			<c:out value="${err.value}"/> </br>
				  		  		</c:forEach>
				  			</span>
				  	  	</div>
					</c:if>
					
					<div id="lien"><a href="supprimer_itineraire"><span style="color:white;">supprimer itinéraire</a></span></div></br>
		    		<div class="form-group input-group">
	              		<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<input type="text" class="form-control"  id="name" name="name" value="<c:out value="${name}"/>" disabled="disabled" >
		    		</div>
		  			
		    		<div class="form-group input-group">
	              		<span class="input-group-addon">
	              			<span class="glyphicon glyphicon-asterisk"></span>
	              		</span>
		      			<textarea class="form-control" style="height: 150px;"  id="description" name="description" disabled="disabled"><c:out value="${description}"/></textarea>
		    		</div>
		    		
		    		<c:if test="${act1 != null}">
						</br><span style="color:white;">Activité 1 <span class="requis">*</span></span></br>
					
						<div class="form-group input-group">
		    				<span class="input-group-addon">
	             				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="act1" name="act1" value="<c:out value="${act1}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="duree1" name="duree1" value="<c:out value="${duree1}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="prix1" name="prix1" value="<c:out value="${prix1}"/>" disabled="disabled">
		    			</div>
					</c:if>
					
					<c:if test="${act2 != null}">
						</br><span style="color:white;">Activité 2</span></br>
					
						<div class="form-group input-group">
		    				<span class="input-group-addon">
	             				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="act2" name="act2" value="<c:out value="${act2}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="duree2" name="duree2" value="<c:out value="${duree2}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="prix2" name="prix2" value="<c:out value="${prix2}"/>" disabled="disabled">
		    			</div>
					</c:if>
					
					<c:if test="${act3 != null}">
						</br><span style="color:white;">Activité 3</span></br>
					
						<div class="form-group input-group">
		    				<span class="input-group-addon">
	             				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="act3" name="act3" value="<c:out value="${act3}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="duree3" name="duree3" value="<c:out value="${duree3}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="prix3" name="prix3" value="<c:out value="${prix3}"/>" disabled="disabled">
		    			</div>
					</c:if>
					
					<c:if test="${act4 != null}">
						</br><span style="color:white;">Activité 4</span></br>
					
						<div class="form-group input-group">
		    				<span class="input-group-addon">
	             				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="act4" name="act4" value="<c:out value="${act4}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="duree4" name="duree4" value="<c:out value="${duree4}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="prix4" name="prix4" value="<c:out value="${prix4}"/>" disabled="disabled">
		    			</div>
					</c:if>
					
					<c:if test="${act5 != null}">
						</br><span style="color:white;">Activité 5</span></br>
					
						<div class="form-group input-group">
		    				<span class="input-group-addon">
	             				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="act5" name="act5" value="<c:out value="${act5}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="duree5" name="duree5" value="<c:out value="${duree5}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="prix5" name="prix5" value="<c:out value="${prix5}"/>" disabled="disabled">
		    			</div>
					</c:if>
					
					<c:if test="${act6 != null}">
						</br><span style="color:white;">Activité 6</span></br>
					
						<div class="form-group input-group">
		    				<span class="input-group-addon">
	             				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="act6" name="act6" value="<c:out value="${act6}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="duree6" name="duree6" value="<c:out value="${duree6}"/>" disabled="disabled">
		    			</div>
		    			<div class="form-group input-group">
		    				<span class="input-group-addon">
	              				<span class="glyphicon glyphicon-asterisk"></span>
	              			</span>
		      				<input type="text" class="form-control"  id="prix6" name="prix6" value="<c:out value="${prix6}"/>" disabled="disabled">
		    			</div>
					</c:if>
		    		
		    		<div>
					    <button type="submit" class="btn btn-primary" id="modifier">
					      <span style="color:white;">modifier</span>
					    </button>
					</div>
		  		</fieldset>
			</form>
		</div>
	</body>
</html>