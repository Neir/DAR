var map;
var panel;
var direction;
var itinerary;
var eiffelMarker, montMartreMarker, arcDeTriopheMarker;
var eiffelIcon, montMartreIcon, arcDeTriopheIcon;
var eiffelSelect, montMartreSelect, arcDeTriompheSelect;

var defaultCenterPosition = new google.maps.LatLng(48.87, 2.347198);

var eiffelPosition = new google.maps.LatLng(48.858093, 2.294694);
var montMartrePosition = new google.maps.LatLng(48.887691, 2.340607);
var arcDeTriomphePosition = new google.maps.LatLng(48.873756, 2.294946);
var fochPoincarePosition = new google.maps.LatLng(48.87250602041687,
		2.284727096557617);
var trocaderoPosition = new google.maps.LatLng(48.862936152271594,
		2.287130355834961);

function initialize() {
	map = new google.maps.Map(document.getElementById("map_canvas"), {
		zoom : 13,
		center : defaultCenterPosition,
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		maxZoom : 20
	});
	map.addListener('click', onClickMap);

	itinerary = new google.maps.Polyline({
		strokeColor : '#4876FF',
		strokeOpacity : 1.0,
		strokeWeight : 3
	});
	itinerary.setMap(map);

	panel = document.getElementById('panel');

	direction = new google.maps.DirectionsRenderer({
		map : map,
		panel : panel
	});

	// Eiffel Tower
	eiffelIcon = {
		url : 'resources/images/eiffel.png',
		scaledSize : new google.maps.Size(50, 70)
	};
	var stringEiffel = '<div id="content">' + '<div id="siteNotice">'
			+ '</div>'
			+ '<h1 id="firstHeading" class="firstHeading">Eiffel Tower</h1>'
			+ '<div id="bodyContent">' + '<p><b>Tarif: ....</b>, 4.7 stars</p>'
			+ '</div>' + '</div>';
	var infoEiffel = new google.maps.InfoWindow({
		content : stringEiffel
	});

	eiffelMarker = new google.maps.Marker({
		position : eiffelPosition,
		icon : eiffelIcon,
		map : map
	});
	eiffelMarker.addListener('mouseover', function() {
		infoEiffel.open(map, eiffelMarker);
	});
	eiffelMarker.addListener('mouseout', function() {
		infoEiffel.close(map, eiffelMarker);
	});
	eiffelMarker.addListener('click', onClickEiffel);
	eiffelSelect = false;

	// Mont Martre
	montMartreIcon = {
		url : 'resources/images/moulinRouge.png',
		scaledSize : new google.maps.Size(50, 50)
	};
	var stringMontMartre = '<div id="content">' + '<div id="siteNotice">'
			+ '</div>'
			+ '<h1 id="firstHeading" class="firstHeading">Moulin Rouge</h1>'
			+ '<div id="bodyContent">' + '<p><b>Tarif: ....</b>, 5 stars</p>'
			+ '</div>' + '</div>';
	var infoMontMartre = new google.maps.InfoWindow({
		content : stringMontMartre
	});
	montMartreMarker = new google.maps.Marker({
		position : montMartrePosition,
		icon : montMartreIcon,
		map : map
	});
	montMartreMarker.addListener('mouseover', function() {
		infoMontMartre.open(map, montMartreMarker);
	});
	montMartreMarker.addListener('mouseout', function() {
		infoMontMartre.close(map, montMartreMarker);
	});
	montMartreMarker.addListener('click', onClickMontMartre);
	montMartreSelect = false;

	// Arc De Triomphe
	arcDeTriompheIcon = {
		url : 'resources/images/arcDeTriomphe.png',
		scaledSize : new google.maps.Size(50, 50)
	};
	var stringArcDeTriomphe = '<div id="content">' + '<div id="siteNotice">'
			+ '</div>'
			+ '<h1 id="firstHeading" class="firstHeading">Arc De Triomphe</h1>'
			+ '<div id="bodyContent">' + '<p><b>Tarif: ....</b>, 4.8 stars</p>'
			+ '</div>' + '</div>';
	var infoArcDeTriomphe = new google.maps.InfoWindow({
		content : stringArcDeTriomphe
	});
	arcDeTriompheMarker = new google.maps.Marker({
		position : arcDeTriomphePosition,
		icon : arcDeTriompheIcon,
		map : map
	});
	arcDeTriompheMarker.addListener('mouseover', function() {
		infoArcDeTriomphe.open(map, arcDeTriompheMarker);
	});
	arcDeTriompheMarker.addListener('mouseout', function() {
		infoArcDeTriomphe.close(map, arcDeTriompheMarker);
	});
	arcDeTriompheMarker.addListener('click', onClickArcDeTriomphe);
	arcDeTriompheSelect = false;
}

function onClickEiffel(event) {
	eiffelSelect = !eiffelSelect;

	if (eiffelSelect && !arcDeTriompheSelect) {
		eiffelMarker.setIcon();
		itinerary.getPath().clear();
		return;
	}
	if (eiffelSelect && arcDeTriompheSelect) {
		eiffelMarker.setIcon();
		itinerary.getPath().clear();
		itinerary.setPath([ arcDeTriomphePosition, fochPoincarePosition,
				trocaderoPosition, eiffelPosition ]);
		return;
	}
	if (!eiffelSelect && arcDeTriompheSelect) {
		eiffelMarker.setIcon(eiffelIcon);
		itinerary.getPath().clear();
		return;
	}
	if (!eiffelSelect && !arcDeTriompheSelect) {
		eiffelMarker.setIcon(eiffelIcon);
		itinerary.getPath().clear();
		return;
	}
}

//TODO: ...
function onClickMontMartre(event) {
	return;
}

function onClickArcDeTriomphe(event) {
	arcDeTriompheSelect = !arcDeTriompheSelect;

	if (arcDeTriompheSelect && !eiffelSelect) {
		arcDeTriompheMarker.setIcon();
		itinerary.getPath().clear();
		return;
	}
	if (arcDeTriompheSelect && eiffelSelect) {
		arcDeTriompheMarker.setIcon();
		itinerary.getPath().clear();
		itinerary.setPath([ eiffelPosition, trocaderoPosition,
				arcDeTriomphePosition ]);
		return;
	}
	if (!arcDeTriompheSelect && eiffelSelect) {
		arcDeTriompheMarker.setIcon(arcDeTriompheIcon);
		itinerary.getPath().clear();
		return;
	}
	if (!arcDeTriompheSelect && !eiffelSelect) {
		arcDeTriompheMarker.setIcon(arcDeTriompheIcon);
		itinerary.getPath().clear();
		return;
	}
}

function onClickMap(event) {
	console.log(event.latLng);
}

function calculate() {
	origin = document.getElementById('origin').value; // Le point départ
	destination = document.getElementById('destination').value; // Le point
	// d'arrivé
	if (origin && destination) {
		var request = {
			origin : origin,
			destination : destination,
			travelMode : google.maps.DirectionsTravelMode.WALKING
		// Type de transport
		}
		var directionsService = new google.maps.DirectionsService(); // Service
		// de
		// calcul
		// d'itinéraire
		directionsService.route(request, function(response, status) { // Envoie
			// de la
			// requête
			// pour
			// calculer
			// le
			// parcours
			if (status == google.maps.DirectionsStatus.OK) {
				direction.setDirections(response); // Trace l'itinéraire sur la
				// carte et les différentes
				// étapes du parcours
			}
		});
	} // http://code.google.com/intl/fr-FR/apis/maps/documentation/javascript/reference.html#DirectionsRequest
};

function geolocalisation_test() {
	if (navigator.geolocation)
		var watchId = navigator.geolocation.watchPosition(successCallback,
				null, {
					enableHighAccuracy : true
				});
	else
		alert("Votre navigateur ne prend pas en compte la géolocalisation HTML5");
}

function successCallback(position) {
	var latLng = new google.maps.LatLng(position.coords.latitude,
			position.coords.longitude);
	// recuperer la position de l'utilisateur, centrer la carte sur la nouvelle
	// position
	map.panTo(latLng);
	// afficher un marqueur sur la nouvelle position
	var marker = new google.maps.Marker({
		position : latLng,
		map : map,
		title : "Position actuelle"
	});

	// ajouter une info-bulle a notre marqueur
	var contentMarker = 'Voici votre position actuelle'

	var infoWindow = new google.maps.InfoWindow({
		content : contentMarker,
		position : latLng
	});

	// Definir un Listener pour notre marqueur
	google.maps.event.addListener(marker, 'click', function() {
		infoWindow.open(map, marker);
	});

	// tracer une ligne
	var newLineCoordinates = [
			new google.maps.LatLng(48.858565, 2.347198),
			new google.maps.LatLng(position.coords.latitude,
					position.coords.longitude) ];

	var newLine = new google.maps.Polyline({
		path : newLineCoordinates,
		strokeColor : "#0000FF",
		strokeOpacity : 1.0,
		strokeWeight : 5
	});
	newLine.setMap(map);
}
