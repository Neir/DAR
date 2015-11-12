var map;
var panel;
var directionsDisplay;
var firstPoint;
var destinations;
var geocoder = new google.maps.Geocoder();

function initialize() {
	firstPoint = new google.maps.LatLng(48.858565, 2.347198);

	var mapOptions = {
		center : firstPoint,
		scrollWheel : false,
		zoom : 13
	};
	var marker = new google.maps.Marker({
		position : firstPoint,
		url : '/',
		animation : google.maps.Animation.DROP
	});

	var map = new google.maps.Map(document.getElementById("map-canvas"),
			mapOptions);
	//marker.setMap(map);

	directionsDisplay = new google.maps.DirectionsRenderer({
		map : map
	});

	var directionsService = new google.maps.DirectionsService();

	// Instantiate an info window to hold step text.
	var stepDisplay = new google.maps.InfoWindow;
}

google.maps.event.addDomListener(window, 'load', initialize);

function calculate(origin, destination, waypts) {
	//origin      = document.getElementById('origin').value; // Le point départ
	//destination = document.getElementById('destination').value; // Le point d'arrivé
	if (origin && destination) {
		var request = {
			origin : origin,
			destination : destination,
			waypoints : waypts,
			optimizeWaypoints : false,
			travelMode : google.maps.DirectionsTravelMode.WALKING
		// Type de transport
		}
		var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
		directionsService.route(request, function(response, status) { // Envoie de la requête pour calculer le parcours
			if (status == google.maps.DirectionsStatus.OK) {
				directionsDisplay.setDirections(response); // Trace l'itinéraire sur la carte et les différentes étapes du parcours
			}
		});
	} //http://code.google.com/intl/fr-FR/apis/maps/documentation/javascript/reference.html#DirectionsRequest
};

function calculateAndDisplayRoute(directionsDisplay, directionsService,
		markerArray, stepDisplay, map) {
	// First, remove any existing markers from the map.
	for (var i = 0; i < markerArray.length; i++) {
		markerArray[i].setMap(null);
	}

	// Retrieve the start and end locations and create a DirectionsRequest using
	// WALKING directions.
	directionsService.route({
		origin : document.getElementById('start').value,
		destination : document.getElementById('end').value,
		travelMode : google.maps.TravelMode.WALKING
	}, function(response, status) {
		// Route the directions and pass the response to a function to create
		// markers for each step.
		if (status === google.maps.DirectionsStatus.OK) {
			document.getElementById('warnings-panel').innerHTML = '<b>'
					+ response.routes[0].warnings + '</b>';
			directionsDisplay.setDirections(response);
			showSteps(response, markerArray, stepDisplay, map);
		} else {
			window.alert('Directions request failed due to ' + status);
		}
	});
}

function showSteps(directionResult, markerArray, stepDisplay, map) {
	// For each step, place a marker, and add the text to the marker's infowindow.
	// Also attach the marker to an array so we can keep track of it and remove it
	// when calculating new routes.
	var myRoute = directionResult.routes[0].legs[0];
	for (var i = 0; i < myRoute.steps.length; i++) {
		var marker = markerArray[i] = markerArray[i] || new google.maps.Marker;
		marker.setMap(map);
		marker.setPosition(myRoute.steps[i].start_location);
	}
}

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
	//recuperer la position de l'utilisateur, centrer la carte sur la nouvelle position
	map.panTo(latLng);
	//afficher un marqueur sur la nouvelle position
	var marker = new google.maps.Marker({
		position : latLng,
		map : map,
		title : "Position actuelle"
	});

	//ajouter une info-bulle a notre marqueur
	var contentMarker = 'Voici votre position actuelle'

	var infoWindow = new google.maps.InfoWindow({
		content : contentMarker,
		position : latLng
	});

	//Definir un Listener pour notre marqueur
	google.maps.event.addListener(marker, 'click', function() {
		infoWindow.open(map, marker);
	});

	//tracer une ligne
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

function codeAddress(address) {
    geocoder.geocode({
        'address' : address
    }, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            var marker = new google.maps.Marker({
                map : map,
                position : results[0].geometry.location
            });
            
            return results[0].geometry.location;
        } else {
            alert("Geocode was not successful for the following reason: "
                    + status);
        }
    });
}
