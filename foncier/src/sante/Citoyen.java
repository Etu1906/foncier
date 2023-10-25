package sante;

import java.io.Serializable;
import java.sql.Date;

public class Citoyen implements Serializable {

  private static final long serialVersionUID = 1L;

  String idcin;

  String nom;
  String prenom;

  String adresse;

  Date dateNaissance;

  public Citoyen(String idcin) {
    this.idcin = idcin;
  }

  public Citoyen(){
    
  }
  // public static Citoyen getCitoyenInEjb(String idcin) throws Exception {
  //   EjbClient client = new EjbClient();
  //   Context context = client.getContextEjb();
  //   String jndiName = "ejb:sante/sante/EjbCitoyen!ejb.EjbRemote";
  //   EjbRemote remote = (EjbRemote) context.lookup(jndiName);
  //   Citoyen result = remote.getCitoyen(idcin);
  //   System.out.println(result);
  //   context.close();
  //   return result;
  // }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public String getIdcin() {
    return idcin;
  }

  public void setIdcin(String idcin) {
    this.idcin = idcin;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public Date getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(Date dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  @Override
  public String toString() {
    return (
      "Citoyen [idcin=" +
      idcin +
      ", nom=" +
      nom +
      ", prenom=" +
      prenom +
      ", adresse=" +
      adresse +
      ", dateNaissance=" +
      dateNaissance +
      "]"
    );
  }
}
