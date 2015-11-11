var map;
var panel;
var direction;

function initialize() {
    map = new google.maps.Map(document.getElementById("map_canvas"), {
        zoom: 14,
        center: new google.maps.LatLng(48.858565, 2.347198),
        mapTypeId: google.maps.MapTypeId.ROADMAP,
	maxZoom   : 20
    });

    panel    = document.getElementById('panel');

    direction = new google.maps.DirectionsRenderer({
	map   : map, 
	panel : panel 
    });
}

function calculate(){
    origin      = document.getElementById('origin').value; // Le point départ
    destination = document.getElementById('destination').value; // Le point d'arrivé
    if(origin && destination){
        var request = {
            origin      : origin,
            destination : destination,
            travelMode  : google.maps.DirectionsTravelMode.WALKING // Type de transport
        }
        var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
        directionsService.route(request, function(response, status){ // Envoie de la requête pour calculer le parcours
            if(status == google.maps.DirectionsStatus.OK){
                direction.setDirections(response); // Trace l'itinéraire sur la carte et les différentes étapes du parcours
            }
        });
    } //http://code.google.com/intl/fr-FR/apis/maps/documentation/javascript/reference.html#DirectionsRequest
};

function geolocalisation_test() {
    if (navigator.geolocation)
	var watchId = navigator.geolocation.watchPosition(successCallback,
							  null,
							  {enableHighAccuracy:true});
    else
	alert("Votre navigateur ne prend pas en compte la géolocalisation HTML5");
}

function successCallback(position){
    var latLng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    //recuperer la position de l'utilisateur, centrer la carte sur la nouvelle position
    map.panTo(latLng);
    //afficher un marqueur sur la nouvelle position
    var marker = new google.maps.Marker({
	position: latLng, 
	map: map,
	title: "Position actuelle"
    });

    //ajouter une info-bulle a notre marqueur
    var contentMarker = 'Voici votre position actuelle'
    
    var infoWindow = new google.maps.InfoWindow({
	content  : contentMarker,
	position : latLng
    });

    //Definir un Listener pour notre marqueur
    google.maps.event.addListener(marker, 'click', function() {
	infoWindow.open(map,marker);
    });

    //tracer une ligne
    var newLineCoordinates =
	[
	    new google.maps.LatLng(48.858565, 2.347198),
	    new google.maps.LatLng(position.coords.latitude, position.coords.longitude)
	];
    
    var newLine = new google.maps.Polyline({
	path: newLineCoordinates,        
	strokeColor: "#0000FF",
	strokeOpacity: 1.0,
	strokeWeight: 5
    });
    newLine.setMap(map);
}
