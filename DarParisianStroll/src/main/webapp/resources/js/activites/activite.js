/* google maps -----------------------------------------------------*/
google.maps.event.addDomListener(window, 'load', initialize);
var geocoder = geocoder = new google.maps.Geocoder();
var map;
var element = document.getElementById("theForm");
function initialize() {
	firstPoint = new google.maps.LatLng(48.858565, 2.347198);

	var mapOptions = {
		center : firstPoint,
		scrollWheel : false,
		zoom : 13
	};

	map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

	directionsDisplay = new google.maps.DirectionsRenderer({
		map : map
	});

	var directionsService = new google.maps.DirectionsService();

	// Instantiate an info window to hold step text.
	var stepDisplay = new google.maps.InfoWindow;

	codeAddress();
	hideMsg();
}
google.maps.event.addDomListener(window, 'load', initialize);

function codeAddress() {
	var address = document.getElementById("address").innerHTML;
	console.log("contenu : "
			+ address.replace("<br>", " ").replace("&nbsp;", " "));
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			map.setCenter(results[0].geometry.location);
			var marker = new google.maps.Marker({
				map : map,
				position : results[0].geometry.location
			});
		} else {
			alert("Geocode was not successful for the following reason: "
					+ status);
		}
	});
}

function showMsg() {
	element.style.visibility = "visible";
}

function hideMsg() {
	element.style.visibility = "hidden";
}