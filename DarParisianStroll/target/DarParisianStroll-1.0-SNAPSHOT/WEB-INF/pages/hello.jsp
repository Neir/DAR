<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<jsp:include page="import.jsp"></jsp:include>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Dar Parisian Stroll</title>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=true&language=fr"></script>
<script src="<c:url value="/resources/js/hello.js" />"></script>
<style type="text/css">
banner {
	height: 30%;
	background: left top;
}

body {
	background-repeat: no-repeat;
	background-size: cover;
	font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	font-size: 16px;
}

leftMenu {
	float: left;
	height: 100%;
	width: 20%;
	background: rgba(1, 1, 1, 0.5);
}

section {
	margin-left: 20%
}

#map_canvas {
	height: 500px;
	width: 800px;
}

.panel-height {
	height: 150px;
}

.panel-default > .panel-heading-custom {
	@import url('//maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css');
	background: #4c4a7f; color: #fff;
}
</style>
</head>
<body
	style="background-image:url(<c:url value="/resources/images/paris.jpg" />)"
	onload="initialize()">
	<jsp:include page="header.jsp"><jsp:param name="connected" value="${connected}" /></jsp:include>

	<div id="container" class="container">

		<div class="panel panel-default">
			<div class="panel-heading panel-heading-custom panel-height">
				<img
					src="resources/images/parisianStrollTitle.png"
					width="75%" height="100%" />
			</div>
			<div class="panel-body" style="background-color: rgba(0, 0, 0, 0.1);">
								<div id="resume">
									<p>Bienvenue sur <u>DarParisiaStroll.com</u> ! La référence des sorties à Paris. <u><a href="connexion_inscription">Inscrivez-vous</a></u> et proposez votre propre itinéraire.</p>
								</div>
				<form class="form-vertical">
					<div class="column">
						<div class="col-md-3">

							<label id="titleActivity">
						<span style="color: black;">
								Activités populaires à Paris</span>
					</label>
							<a href="activite?id=1653" class="btn btn-lg btn-block btn-primary" id="eiffel">Tour Eiffel</a>
							<a href="activite?id=1650" class="btn btn-lg btn-block btn-primary" id="arcDeTriomphe">Arc de Triomphe</a>
							<a href="activite?id=1799" class="btn btn-lg btn-block btn-primary"id="montMartre">Jardin des plantes</a>
						</div>

						<div class="col-md-9">
							<div class="container-fluid">
								<div id="map_canvas">
									<p>Veuillez patienter pendant le chargement de la carte...</p>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>