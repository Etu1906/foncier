package presidence;

import banque.FicheBanque;
import banque.Operation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ejb.EjbClient;
import ejb.FicheSanteRemote;
import foncier.FicheFoncier;
import formatters.DateDeserializer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import javax.naming.Context;
import sante.Citoyen;
import sante.FicheSante;

public class CitoyenData {

  FicheFoncier foncier;
  FicheSante sante;
  FicheBanque banque;

  public CitoyenData(String idcin) {
    foncier = new FicheFoncier(idcin);
    this.banque = new FicheBanque();
    this.banque.setCitoyen(new Citoyen());
    this.banque.getCitoyen().setIdcin(idcin);
    sante = new FicheSante();
    sante.setIdcin(idcin);
  }

  public void complete() throws Exception {
    System.out.println("updated");
    setFoncier(getFoncierInWS());
    setSante(getSanteInWS());
    setBanque(getFicheBanque());
  }

  public FicheBanque getFicheBanque() throws Exception {
    try {
      URL url = new URL(
        "http://localhost:5251/Banque/operations/" +
        this.banque.getCitoyen().getIdcin()
      );
      System.out.println(
        "http://localhost:5251/Banque/operations/" +
        this.banque.getCitoyen().getIdcin()
      );
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      InputStreamReader reader = new InputStreamReader(
        connection.getInputStream()
      );
      Gson gson = new GsonBuilder()
        .registerTypeAdapter(Date.class, new DateDeserializer())
        .create();
      FicheBanque ficheBanque = gson.fromJson(reader, FicheBanque.class);

      System.out.println("Citoyen: " + ficheBanque.getCitoyen().toString());
      for (Operation operation : ficheBanque.getOperations()) {
        System.out.println("Opération - Plus: " + operation.getPlus());
        System.out.println("Opération - Moins: " + operation.getMoins());
        System.out.println("Opération - Date: " + operation.getDateOperation());
      }
      connection.disconnect();
      reader.close();
      return ficheBanque;
    } catch (IOException e) {
      throw e;
    }
  }

  // public FicheFoncier getFoncierInEjb(boolean close) throws Exception {
  //   EjbClient clientEjb = new EjbClient();
  //   Context context = clientEjb.getContextEjb();
  //   String jndiName = "ejb:foncier/foncier/EjbFoncier!ejb.FoncierRemote";
  //   FoncierRemote remote = (FoncierRemote) context.lookup(jndiName);
  //   FicheFoncier result = remote.getFicheFoncier(
  //     this.foncier.getCitoyen().getIdcin()
  //   );
  //   if (close) {
  //     context.close();
  //   }
  //   return result;
  // }
  public FicheFoncier getFoncierInWS() throws Exception {
    try {
      URL url = new URL(
        "http://127.0.0.1:8080/foncier/appli/proprietes/" +
        this.foncier.getCitoyen().getIdcin()
      );
      System.out.println(
        "http://127.0.0.1:8080/foncier/appli/proprietes/" +
        this.foncier.getCitoyen().getIdcin()
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
      FicheFoncier ff = gson.fromJson(reader, FicheFoncier.class);
      connection.disconnect();
      reader.close();
      return ff;
    } catch (IOException e) {
      throw e;
    }
  }

  public FicheSante getSanteInWS() throws Exception {
    try {
      URL url = new URL(
        "http://localhost:8080/sante/appli/citoyens/getSante/" +
        this.banque.getCitoyen().getIdcin()
      );
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      InputStreamReader reader = new InputStreamReader(
        connection.getInputStream()
      );
      Gson gson = new GsonBuilder()
        .registerTypeAdapter(Date.class, new DateDeserializer())
        .create();

      FicheSante ficheSante = gson.fromJson(reader, FicheSante.class);
      System.out.println("Citoyen: " + ficheSante);
      connection.disconnect();
      reader.close();
      return ficheSante;
    } catch (IOException e) {
      throw e;
    }
  }

  public FicheSante geFicheSanteInEjb(boolean close) throws Exception {
    EjbClient clientEjb = new EjbClient();
    Context context = clientEjb.getContextEjb();
    String jndiName = "ejb:sante/sante/EjbFicheSante!ejb.FicheSanteRemote";
    FicheSanteRemote remote = (FicheSanteRemote) context.lookup(jndiName);
    FicheSante result = remote.getFicheSante(this.sante.getIdcin());
    if (close) {
      context.close();
    }
    return result;
  }

  public FicheFoncier getFoncier() {
    return foncier;
  }

  public void setFoncier(FicheFoncier foncier) {
    this.foncier = foncier;
  }

  public FicheSante getSante() {
    return sante;
  }

  public void setSante(FicheSante sante) {
    this.sante = sante;
  }

  public FicheBanque getBanque() {
    return banque;
  }

  public void setBanque(FicheBanque banque) {
    this.banque = banque;
  }
}
