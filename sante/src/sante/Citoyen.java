package sante;

import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import serialisers.CustomDateSerializer;

@Entity
@Table(name = "citoyen")
public class Citoyen implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  String idcin;

  String nom;
  String prenom;

  String adresse;

  @JsonbTypeSerializer(CustomDateSerializer.class)
  @Column(name = "datenaissance")
  Date dateNaissance;

  public Citoyen(String idcin) {
    this.idcin = idcin;
  }



  public void getCitoyen(EntityManager manager) {
    FicheSante result = FicheSante.getFicheSante(manager, idcin);
    setNom(result.getNom());
    setPrenom(result.getPrenom());
    setAdresse(result.getAdresse());
    setDateNaissance(result.getDateNaissance());
  }

  public Citoyen(
    String idcin,
    String nom,
    String prenom,
    String adresse,
    Date dateNaissance
  ) {
    this.idcin = idcin;
    this.nom = nom;
    this.prenom = prenom;
    this.adresse = adresse;
    this.dateNaissance = dateNaissance;
  }

  public Citoyen() {}

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
