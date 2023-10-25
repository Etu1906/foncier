package sante;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.List;

@Entity
@Table(name = "citoyen")
public class FicheSante extends Citoyen {

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "citoyen_allergie",
    joinColumns = { @JoinColumn(name = "idcin") },
    inverseJoinColumns = { @JoinColumn(name = "idAllergie") }
  )
  List<Allergie> allergie;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "idcin")
  List<Operation> operation;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "citoyen_maladie",
    joinColumns = { @JoinColumn(name = "idcin") },
    inverseJoinColumns = { @JoinColumn(name = "idMaladie") }
  )
  List<Maladie> maladie;

  @Transactional
  public static FicheSante getFicheSante(EntityManager manager, String idcin) {
    String req = "select * from citoyen where idcin = '" + idcin + "'";
    System.out.println(req);
    Query query = manager.createNativeQuery(req, FicheSante.class);
    List<FicheSante> citoyens = (List<FicheSante>) query.getResultList();
    FicheSante result = citoyens.get(0);
    return result;
  }

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
    return (
      super.toString() +
      "FicheSante [allergie=" +
      allergie +
      ", operation=" +
      operation +
      ", maladie=" +
      maladie +
      "]"
    );
  }
}
