package foncier;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Propriete {

  int idpropriete;

  double superficie;
  String description;
  String adresse;
  Polygone polygone;

  public Propriete(String idp) {
    setIdpropriete(idp);
  }
  public Propriete() {}

  public void complete() throws Exception {
    try {
      URL url = new URL(
        "http://127.0.0.1:8080/foncier/appli/propriete/" + this.idpropriete
      );
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      InputStreamReader reader = new InputStreamReader(
        connection.getInputStream()
      );
      // raha misy date
      // Gson gson = new GsonBuilder()
      //   .registerTypeAdapter(Date.class, new DateDeserializer())
      //   .create();
      Gson gson = new Gson();
      Propriete pprt = gson.fromJson(reader, Propriete.class);
      connection.disconnect();
      reader.close();
      this.superficie = pprt.superficie;
      this.polygone = pprt.polygone;
      this.description = pprt.description;
      this.adresse = pprt.adresse;
    } catch (IOException e) {
      throw e;
    }
  }

  public int getIdpropriete() {
    return idpropriete;
  }

  public Propriete(int idpropriete) {
    setIdpropriete(idpropriete);
  }

  public void setIdpropriete(String idpropriete) {
    setIdpropriete(Integer.valueOf(idpropriete));
  }

  public void setIdpropriete(int idpropriete) {
    this.idpropriete = idpropriete;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public Polygone getPolygone() {
    return polygone;
  }

  public void setPolygone(Polygone polygone) {
    this.polygone = polygone;
  }

  public double getSuperficie() {
    return superficie;
  }

  public void setSuperficie(double superficie) {
    this.superficie = superficie;
  }
}
