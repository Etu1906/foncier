package devise;

import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Query;
import java.sql.Date;
import serialisers.CustomDateSerializer;

@Entity
public class Cours {

  @Id
  int idCours;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idDevise")
  Devise devise;

  @JsonbTypeSerializer(CustomDateSerializer.class)
  Date dateCours;

  double tauxAchat;
  double tauxVente;

  public Cours(String date, String iddevise) throws Exception {
    setDateCours(date);
    devise = new Devise(iddevise);
  }

  public int getIdCours() {
    return idCours;
  }
  

  public Cours(){}
  public void complete(EntityManager manager) {
    String req =
      "select * from cours where dateCours = (select max(dateCours) from cours where iddevise = " +
      this.devise.getIdDevise() +
      " and dateCours <= '" +
      this.dateCours +
      "') and iddevise  =  " +
      this.devise.getIdDevise();
    System.out.println(req);
    Query query = manager.createNativeQuery(req, Cours.class);
    Cours c =(Cours) query.getSingleResult();
    setTauxAchat(c.getTauxAchat());
    setTauxVente(c.getTauxVente());
    setIdCours(c.getIdCours());
  }

  public void setIdCours(int idCours) {
    this.idCours = idCours;
  }

  public void setDateCours(String dateCours) throws Exception {
    setDateCours(Date.valueOf(dateCours));
  }

  public Devise getDevise() {
    return devise;
  }

  public void setDevise(Devise devise) {
    this.devise = devise;
  }



  public Date getDateCours() {
    return dateCours;
  }

  public void setDateCours(Date dateCours) {
    this.dateCours = dateCours;
  }

  public double getTauxAchat() {
    return tauxAchat;
  }

  public void setTauxAchat(double tauxAchat) {
    this.tauxAchat = tauxAchat;
  }

  public double getTauxVente() {
    return tauxVente;
  }

  public void setTauxVente(double tauxVente) {
    this.tauxVente = tauxVente;
  }
}
