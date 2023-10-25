package ejb;

import jakarta.ejb.Remote;
import sante.FicheSante;

@Remote
public interface FicheSanteRemote {
    public FicheSante getFicheSante(String idcin) throws Exception;
}
