/* google maps -----------------------------------------------------*/
google.maps.event.addDomListener(window, 'load', initialize);
var geocoder = geocoder = new google.maps.Geocoder();
var map;

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
	var element = document.getElementById("theForm");
	console.log("visible");
	element.style.visibility = "visible";
}

function hideMsg() {
	var element = document.getElementById("theForm");
	element.style.visibility = "hidden";
}

function func() {
	event.preventDefault(x);
	console.log(x);
	var id = x;
	var select1 = $('#select1').val();
	var textarea = $('#textarea').val();
	var xhr = new XMLHttpRequest();
	var url = 'http://localhost:8080/DarParisianStroll/activite?id='
			+ id + '&select1=' + select1 + '&textarea=' + textarea;

	xhr.open('post', url, false);

	xhr.onreadystatechange = function() {
		// Ready state 4 means the request is done
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				if (xhr.responseText == "true") {
					// email existant dans la base
					text = document.createTextNode("Commentaire envoyé");
					hideMsg();
				}
			}
		}
	}

	xhr.send(null);
	return true;;
}