<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<jsp:include page="../import.jsp"></jsp:include>
<script
	src="http://maps.googleapis.com/maps/api/js?sensor=false&extension=.js&output=embed"></script>
<script src="<c:url value="/resources/js/functions.js"/>"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>


<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"
	media="screen" />
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
		<jsp:param name="page_active" value="liste_inteneraires" />
	</jsp:include>

	<div id="container" class="container">

		<div class="panel panel-default">
			<div class="panel-heading">
				<label>Road to Mars</label>
			</div>
			<div class="panel-body">
				<form class="form-vertical">
					<div class="column">
						<div class="col-md-6">
							<fieldset>

								<div class="form-group row">
									Créé par <a href="#">M. Spoke</a>
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Note :
									</label> *****
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Catégories
										: </label> Spatiale Ennuyeux Solitaire Dépaysant Long Onéreux
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Description
										: </label> ${route.description}
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Coût :
									</label> 1 million et 5 centimes
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Durée
										totale : </label> 9.2 années lumières
								</div>

								<div class="form-group row">
									<label class="col-md-3 control-label" for="name">Liste
										des activités :</label>

									<script type="text/javascript">
										var previousPoint = new google.maps.LatLng(
												48.858565, 2.347198);
										var monobjet_json = JSON
												.stringify(previousPoint);
										sessionStorage.setItem("previousObj",
												monobjet_json);

										window.onload = function() {
											var start = JSON
													.parse(window.localStorage
															.getItem("previousObj"));

											console.log("1");
											var destinations = [];
											<c:forEach items="${activityTable}" var="activity">
											var arr = [];

											arr
													.push("<c:out value="${activity.lat}" />");
											arr
													.push("<c:out value="${activity.lon}" />");

											destinations.push(arr);
											</c:forEach>

											console.log("2");

											var wp = [];
											Array
													.forEach(
															destinations,
															function(dest) {
																var end = new google.maps.LatLng(
																		parseFloat(dest[0]),
																		parseFloat(dest[1]));
																//  												     calculate(start, end);
																//  												     start = end;
																wp
																		.push({
																			location : new google.maps.LatLng(
																					parseFloat(dest[0]),
																					parseFloat(dest[1])),
																			stopover : false
																		})
																console
																		.log(end);
															});

											console.log(1);
											var start = new google.maps.LatLng(
													destinations[0][0],
													destinations[0][1]);
											console.log(2);
											var end = new google.maps.LatLng(
													destinations[destinations.length - 1][0],
													destinations[destinations.length - 1][1]);
											console.log(end);
											calculate(start, end, wp);

											// 													end[index] = new google.maps.LatLng(parseFloat(dest[0]), parseFloat(dest[1]));
											// 												    start[index+1] = new google.maps.LatLng(parseFloat(dest[0]), parseFloat(dest[1]));  

											//  	 											calculate(start, destination);
											//  	 											firstPoint = destination;
											//  	 											var previousPoint = destination;
											//  	 											var monobjet_json = JSON.stringify(previousPoint);
											//  	 											sessionStorage.setItem("previousObj", monobjet_json);
										};
									</script>

									<c:forEach items="${activityTable}" var="activity"
										varStatus="status">
										<a href="#">${activity.name} ${activity.lat}</a>&nbsp;&nbsp;
										
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