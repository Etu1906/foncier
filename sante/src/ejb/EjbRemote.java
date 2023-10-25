package ejb;

import jakarta.ejb.Remote;
import sante.Citoyen;

@Remote
public interface EjbRemote {
  public Citoyen getCitoyen(String cin);
}
