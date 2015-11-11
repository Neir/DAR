<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<nav role="navigation" class="navbar navbar-custom navbar-fixed-top">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" data-target="#navbarCollapse"
				data-toggle="collapse" class="navbar-toggle">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="hello" class="navbar-brand">ParisianStroll</a>
		</div>
		<!-- Collection of nav links, forms, and other content for toggling -->
		<div id="navbarCollapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
			
				<li id="newItinerary"
					class="${param.page_active eq 'create_itineraire' ? 'active' : ''}"><a
					href="create_itineraire">Créer un Itinéraire</a></li>
					
				<li id="liste_inteneraires"
					class="${param.page_active eq 'liste_inteneraires' ? 'active' : ''}"><a
					href="liste_itineraires">Recherche par activités</a></li>
			</ul>
			
			<c:if test="${param.connected != true}">
			<ul class="nav navbar-nav pull-right" id="connexion">
							<li id="connexion" class="${param.page_active eq 'connexion' ? 'active' : ''}"><a href="connexion_inscription">Connexion</a></li>
			</ul>
			</c:if>

			<c:if test="${param.connected eq true}">
			<ul class="nav navbar-nav pull-right">
				<li id="profil" class="${param.page_active eq 'profil' ? 'active' : ''}"><a
					href="profil">Mon Profil</a></li>
				<li id="deconnexion" class="${param.page_active eq 'deconnexion' ? 'active' : ''}"><a href="deconnexion">Déconnexion</a></li>
			</ul>
			</c:if>

		</div>
	</nav>