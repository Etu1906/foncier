package sante;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "partie_corps")
public class PartieCorps implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  int idPartieCorps;

  String nomPartieCorps;

  public int getIdPartieCorps() {
    return idPartieCorps;
  }

  public void setIdPartieCorps(int idPartieCorps) {
    this.idPartieCorps = idPartieCorps;
  }

  public String getNomPartieCorps() {
    return nomPartieCorps;
  }

  public void setNomPartieCorps(String nomPartieCorps) {
    this.nomPartieCorps = nomPartieCorps;
  }

  @Override
  public String toString() {
    return (
      "PartieCorps [idPartieCorps=" +
      idPartieCorps +
      ", nomPartieCorps=" +
      nomPartieCorps +
      "]"
    );
  }
}
