<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<nav role="navigation" class="navbar navbar-default">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" data-target="#navbarCollapse"
			data-toggle="collapse" class="navbar-toggle">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<font class="navbar-brand">ParisianStroll</font>
	</div>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">

			<li id="ItineraryList">Liste des Itineraires</li>
			<li id="newItinerary">Creer un Itineraire</li>

			<li id="profil"><a
				href="profil">Mon Profil</a></li>

		</ul>

		<ul class="nav navbar-nav pull-right">
			<li>Connexion</li>
		</ul>

	</div>
</nav>