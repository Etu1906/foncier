<%@page import="foncier.*" %>
<% Propriete propriete = (Propriete) request.getAttribute("propriete"); %>
<!DOCTYPE html>
<html>
  <head>
    <title>Carte Google Maps</title>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCec-7VgSCmboA2sSYm52X2rKS02pp9Mcw&libraries=geometry"
      defer
    ></script>
  </head>
  <body>
    <div id="map" style="height: 400px; width: 100%;"></div>
    <div>
        <p>Adresse:<%=propriete.getAdresse() %></p>
        <p>Description:<%=propriete.getDescription() %></p>
        <p>Superficie:<%=propriete.getSuperficie() %></p>
    </div>
    <script>
      // Fonction d'initialisation de la carte
      <% 
        Coordonnees focus = propriete.getPolygone().getCoordonnees().get(0);
      %>
      function initMap() {
        // Coordonnées d'Antananarivo
        var antananarivo = {lat:<%=focus.getLatitude() %> , lng: <%=focus.getLongitude() %>};

        // Crée une carte centrée sur Antananarivo
        var map = new google.maps.Map(document.getElementById("map"), {
          zoom: 10, // Niveau de zoom initial
          center: antananarivo,
        });

        // Liste de coordonnées pour le polyline (fermé pour en faire un polygone)
        var coordinates = [
            <% for(Coordonnees c : propriete.getPolygone().getCoordonnees()){ %>
                {lat:<%=c.getLatitude() %> , lng: <%=c.getLongitude() %>},
            <%  } %> 
        ];

        // Crée un objet Polygon avec les coordonnées
        var polygon = new google.maps.Polygon({
          paths: coordinates,
          strokeColor: "#FF0000", // Couleur de la ligne
          strokeOpacity: 1.0, // Opacité de la ligne
          strokeWeight: 2, // Épaisseur de la ligne
          fillColor: "#FF0000", // Couleur de remplissage
          fillOpacity: 0.35, // Opacité de remplissage
        });

        // Ajoute le polygone à la carte
        polygon.setMap(map);
      }
    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCec-7VgSCmboA2sSYm52X2rKS02pp9Mcw&callback=initMap"></script>
  </body>
</html>
