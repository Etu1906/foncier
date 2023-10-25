package foncier;

import java.util.ArrayList;
import java.util.List;

public class Polygone {

  List<Coordonnees> coordonnees;

  public Polygone() {}

  public Polygone(String geomString) {
    if (geomString.startsWith("POLYGON((")) {
      geomString = geomString.substring(9, geomString.length() - 2); // Retirez le "POLYGON((" au début et les "))" à la fin
    }

    String[] coordinatePairs = geomString.split(",");

    List<Coordonnees> coordonneesList = new ArrayList<>();

    for (String coordinatePair : coordinatePairs) {
      String[] parts = coordinatePair.trim().split(" ");
      if (parts.length == 2) {
        Coordonnees coordonnees = new Coordonnees();
        coordonnees.setLatitude(parts[0]);
        coordonnees.setLongitude(parts[1]);
        coordonneesList.add(coordonnees);
      }
    }

    this.setCoordonnees(coordonneesList);
  }

  public String getGeomString() {
    if (coordonnees.isEmpty()) {
      return ""; // Retourne une chaîne vide si la liste de coordonnées est vide
    }

    StringBuilder polygonWKT = new StringBuilder("POLYGON((");

    for (int i = 0; i < coordonnees.size(); i++) {
      Coordonnees coordonnee = coordonnees.get(i);
      polygonWKT
        .append(coordonnee.getLongitude())
        .append(" ")
        .append(coordonnee.getLatitude());

      if (i < coordonnees.size() - 1) {
        polygonWKT.append(", ");
      }
    }

    polygonWKT.append(", ");
    // Ajoutez la première coordonnée à la fin pour fermer le polygone
    Coordonnees firstCoordonnee = coordonnees.get(0);
    polygonWKT
      .append(firstCoordonnee.getLongitude())
      .append(" ")
      .append(firstCoordonnee.getLatitude())
      .append("))");

    return polygonWKT.toString();
  }

  public List<Coordonnees> getCoordonnees() {
    return coordonnees;
  }

  public void setCoordonnees(List<Coordonnees> coordonnees) {
    this.coordonnees = coordonnees;
  }
}
