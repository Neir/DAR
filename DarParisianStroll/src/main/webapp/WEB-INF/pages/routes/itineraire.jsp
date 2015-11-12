<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<jsp:include page="../import.jsp"></jsp:include>
<script
	src="http://maps.googleapis.com/maps/api/js?sensor=false&extension=.js&output=embed"></script>
<script src="<c:url value="/resources/js/functions.js"/>"></script>


<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet"
	href="<c:url value="/resources/css/routes/itineraire.css"/>"
	media="screen" />
<!-- Faire fonctionner les balises structurantes de HTML5 -->
<!--[if lt IE 9]>
      		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->

<style type="text/css">
body {
	background-repeat: no-repeat;
	background-size: cover;
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	font-size: 16px;
}

#map-canvas {
	height: 500px;
	width: 500px;
}
</style>
</head>
<body
	style="background-image:url(<c:url value="/resources/images/paris.jpg" />)">
	<jsp:include page="../header.jsp">
		<jsp:param name="page_active" value="itineraire" />
		<jsp:param name="connected" value="${connected}" />
	</jsp:include>

	<div id="container" class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<label>${route.name}</label>
			</div>
			<div class="panel-body">
				<form class="form-vertical">
					<div class="column">
						<div class="col-md-6">
							<fieldset>

								<div class="form-group row">
									Créé par <a href="profil?id=${author.user_id}">${author.username}</a>
								</div>

								<c:if test="${route.user == author.user_id}">
									<div id="lien">
										<a
											href="modifier_supprimer_itineraire?itineraire=${route.route_id}"><span
											style="color: blue;">modifier ou supprimer
												l'itineraire</a></span>
									</div>
									</br>
								</c:if>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Note
										(à supprimer): </label> *****
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Description
										: </label> ${route.description}
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Coût :
									</label> ${prix} euros
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Durée
										totale : </label> ${duree} heure(s)
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Liste
										des activités :</label>

									<script type="text/javascript">
									window.onload = function(){
                                        
                                        console.log("1");
                                        var destinations = [];
                                       
                                          destinations.push("Avenue des Minimes"+" Paris");
                                       
                                          destinations.push("61 place des Vosges"+" Paris");
                                       
     
                                        console.log("2");
                                             
                                        var wp = [];
										   var tabResults = [];
										   
                                        Array.forEach(destinations, function(dest) {
                                            geocoder.geocode({
                                                 'address' : dest
                                             }, function(results, status) {
                                                 if (status == google.maps.GeocoderStatus.OK) {
														tabResults.push(results[0]);
                                                     var marker = new google.maps.Marker({
                                                         map : map,
                                                         position : results[0].geometry.location
                                                     });
                                                     wp.push({
                                                         location : results[0].geometry.location,
                                                         stopover : false
                                                     });
                                                 } else {
                                                     alert("Geocode was not successful for the following reason: "
                                                             + status);
                                                 }
                                             });
                                           console.log(end);
                                        });
     
                                        console.log(1);
                                        var start = tabResults[0];
                                        console.log(2);
                                        var end = tabResults[tabResults.length - 1];
                                        console.log(end);
                                        calculate(start, end, wp);
                                   };
                                    </script>

									<c:forEach items="${activityTable}" var="activity"
										varStatus="status">
										<a href="activite?id=${activity.id_activity}">${activity.name}</a>&nbsp;&nbsp;
										
									</c:forEach>
								</div>

							</fieldset>
						</div>
					</div>

					<div class="col-md-6">

						<div class="container-fluid">
							<label>Plan :</label>
							<div id="map-canvas">
								<p>Veuillez patienter pendant le chargement de la carte...</p>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>