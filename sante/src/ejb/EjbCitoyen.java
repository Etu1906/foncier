package ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sante.Citoyen;

@Stateless
public class EjbCitoyen implements EjbRemote {

  @PersistenceContext(name = "santePersistenceUnit")
  private EntityManager manager;
  @Override
  public Citoyen getCitoyen(String cin) {
    Citoyen result = new Citoyen(cin);
    result.getCitoyen(manager);
    return result;
  }
}
