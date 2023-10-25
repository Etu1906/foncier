package sante;

import java.util.List;
public class FicheSante extends Citoyen {

  List<Allergie> allergie;
  List<Operation> operation;
  List<Maladie> maladie;

  public FicheSante(String idcin) {
    super(idcin);
  }

  public FicheSante() {
    super();
  }

  public List<Allergie> getAllergies() {
    return allergie;
  }

  public void setAllergies(List<Allergie> allergies) {
    this.allergie = allergies;
  }

  public List<Operation> getOperation() {
    return operation;
  }

  public void setOperation(List<Operation> operation) {
    this.operation = operation;
  }

  public List<Maladie> getMaladie() {
    return maladie;
  }

  public void setMaladie(List<Maladie> maladie) {
    this.maladie = maladie;
  }

  public List<Allergie> getAllergie() {
    return allergie;
  }

  public void setAllergie(List<Allergie> allergie) {
    this.allergie = allergie;
  }

  @Override
  public String toString() {
    return "FicheSante [allergie=" + allergie + ", operation=" + operation + ", maladie=" + maladie + "]";
  }
}
