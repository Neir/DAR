<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Maps Test</title>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&language=fr"></script>
    <!-- Ajout pour javascript ne fonctionne pas pour l"instant -->
    <script src="<c:url value="/resources/js/functions.js" />"></script>
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0px; padding: 0px }
      #map_canvas { height: 100% ; width:100%;}
    </style>
  </head>
  <body style="background-image:url(<c:url value="/resources/images/fond.jpg" />)" onload="initialize()">
    <div style="background:color=blue;">
      <h1>Test MAPS API</h1>
      <form action="" method="get" name="direction" id="direction">
         <label>Point de départ :</label>
         <input type="text" name="origin" id="origin">
         <label>Destination :</label>
         <input type="text" name="destination" id="destination">
         <input type="button" value="Calculer l'itinéraire" onclick="javascript:calculate()">
     </form>
    </div>
    <div id="panel"></div>
    <div id="map_canvas">
      <p>Veuillez patienter pendant le chargement de la carte...</p>
    </div>
  </body>
</html>