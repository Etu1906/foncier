package devise;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Devise {

  @Id
  int idDevise;

  String nomDevise;

  public Devise(String devise) throws Exception{
    setIdDevise(devise);
  }
  public Devise(){}
  public static List<Devise> getAll(EntityManager manager) {
    String req = "select * from devise";
    Query query = manager.createNativeQuery(req, Devise.class);
    List<Devise> devises = (List<Devise>) query.getResultList();
    return devises;
  }
  
  // public static Devise getDevise(string iddevise){
  //   String req= "select * from devise where iddevise = "+Integer.valueOf(iddevise);
  //   Query query = manager.createNativeQuery(req, Devise.class);
  //   Devise devise= (Devise) query.getFirst
  //   return devise;
  // }

  public int getIdDevise() {
    return idDevise;
  }

  public void setIdDevise(int idDevise) {
    this.idDevise = idDevise;
  }
  public void setIdDevise(String idDevise) throws Exception {
    setIdDevise(Integer.valueOf(idDevise));
  }
  public String getNomDevise() {
    return nomDevise;
  }

  public void setNomDevise(String nomDevise) {
    this.nomDevise = nomDevise;
  }
  
}
