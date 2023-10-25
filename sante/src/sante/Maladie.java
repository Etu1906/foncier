package sante;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "maladie")
public class Maladie implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  int idMaladie;

  @Column(name = "nomMaladie")
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
