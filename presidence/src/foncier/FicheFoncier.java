package foncier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;
import sante.Citoyen;

public class FicheFoncier implements Serializable {

  private static final long serialVersionUID = 1L;

  Citoyen citoyen;
  List<Propriete> proprietes;

  public FicheFoncier() {
  }

  public FicheFoncier(String idcin) {
    this.citoyen = new Citoyen(idcin);
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Citoyen getCitoyen() {
    return citoyen;
  }

  public void setCitoyen(Citoyen citoyen) {
    this.citoyen = citoyen;
  }

  public List<Propriete> getProprietes() {
    return proprietes;
  }

  public void setProprietes(List<Propriete> proprietes) {
    this.proprietes = proprietes;
  }
}
