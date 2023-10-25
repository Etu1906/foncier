package sante;

import java.io.Serializable;
public class Maladie implements Serializable {

  private static final long serialVersionUID = 1L;

  int idMaladie;

  String maladie;

  public int getIdMaladie() {
    return idMaladie;
  }

  public void setIdMaladie(int idMaladie) {
    this.idMaladie = idMaladie;
  }

  public String getMaladie() {
    return maladie;
  }

  public void setMaladie(String maladie) {
    this.maladie = maladie;
  }

  @Override
  public String toString() {
    return "Maladie [idMaladie=" + idMaladie + ", maladie=" + maladie + "]";
  }
}
