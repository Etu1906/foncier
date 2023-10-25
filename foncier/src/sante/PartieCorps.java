package sante;

import java.io.Serializable;


public class PartieCorps implements Serializable {

  private static final long serialVersionUID = 1L;

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
