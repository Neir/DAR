<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- <style type="text/css"> -->
<!--    @import url(/resources/css/header.css); -->
<!-- </style> -->

<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>"
	type="text/css" media="screen" />

</head>
<body>
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

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#">Liste des Itinéraire <b
						class="caret"></b></a>
					<ul role="menu" class="dropdown-menu">
						<li><a href="#">Touristique</a></li>
						<li><a href="#">Romantique</a></li>
						<li><a href="#">Vintage</a></li>
						<li class="divider"></li>
						<li><a href="#">Gratuit</a></li>
					</ul></li>
				<li id="newItinerary"><a href="#">Creer un Itinéraire</a></li>


			</ul>

			<ul class="nav navbar-nav pull-right">
				<li id="profil"
					class="${param.page_active eq 'profil' ? 'active' : ''}"><a
					href="profil">Mon Profil</a></li>
				<li id="connexion" class="${param.page_active eq 'connexion' ? 'active' : ''}"><a href="connexion_inscription">Connexion</a></li>
			</ul>

		</div>
	</nav>