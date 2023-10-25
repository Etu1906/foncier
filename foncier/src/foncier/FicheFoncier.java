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

  public void getData(EntityManager manager) throws Exception {
    this.setProprietes(getListeProprietes(manager));
  }

  public List<Propriete> getListeProprietes(EntityManager manager) {
    String req =
      "select idpropriete,superficie,adresse,description from v_propriete where idcin = '" +
      citoyen.getIdcin() +
      "'";
    System.out.println(req);
    Query query = manager.createNativeQuery(req, "ProprieteMapping2");
    List<Propriete> proprietes = (List<Propriete>) query.getResultList();
    System.out.println(proprietes);
    System.out.println("nahita biens");
    return proprietes;
  }

  public Propriete getFirst() {
    return proprietes.get(0);
  }

  public void insert(EntityManager manager) throws Exception {
    String sql =
      "INSERT INTO propriete (description, adresse, geom, superficie,idcin) VALUES (?, ?, ST_GeomFromText(?,4326), ?,?)";
    manager
      .createNativeQuery(sql)
      .setParameter(1, getFirst().description)
      .setParameter(2, getFirst().adresse)
      .setParameter(3, getFirst().getPolygone().getGeomString())
      .setParameter(4, getFirst().superficie)
      .setParameter(5, citoyen.getIdcin())
      .executeUpdate();
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
