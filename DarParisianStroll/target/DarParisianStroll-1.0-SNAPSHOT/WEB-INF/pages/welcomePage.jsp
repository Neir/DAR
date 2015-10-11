<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Maps Test</title>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true&language=fr"></script>
    <script src="<c:url value="/resources/js/welcomePage.js" />"></script>
    <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/welcomePage.css" />'></link>
  </head>
  <!-- <body style="background-image:url(<c:url value="/resources/images/ParisRomance.jpg" />)" onload="initialize()">  -->
  <body onload="initialize()">
    <!--
    <div style="background:color=blue;">
      <h1>TRY MY TRIP</h1>
      <form action="" method="get" name="direction" id="direction">
         <label>Point de départ :</label>
         <input type="text" name="origin" id="origin">
         <label>Destination :</label>
         <input type="text" name="destination" id="destination">
         <input type="button" value="Calculer l'itinéraire" onclick="javascript:calculate()">
     </form>
    </div>
    -->
    <banner>TRY MY TRIP</banner>
    <div id="panel"></div>
    <!-- <banner> </banner> -->
    <leftMenu>
      <menuHeader> Most famous in Paris </menuHeader>
      <choice type="button" onclick="onClickEiffel()">Tour Eiffel</choice>
      <choice type="button" onclick="onClickMontMartre()">Mont Martre</choice>
      <choice type="button" onclick="onClickArcDeTriomphe()">Arc De Triomphe</choice>
      <menuHeader> Most interesting trips </menuHeader>
      <choice type="button" >Love story</choice>
      <choice type="button" >Buddy trip</choice>
      <choice type="button" >Family with kids</choice>
    </leftMenu>
    <section id="map_canvas">
    	<p>Veuillez patienter pendant le chargement de la carte...</p>
    </section>
  </body>
</html>