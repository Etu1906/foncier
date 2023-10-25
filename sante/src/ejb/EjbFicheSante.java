package ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sante.FicheSante;

@Stateless
public class EjbFicheSante implements FicheSanteRemote{
    @PersistenceContext(name = "santePersistenceUnit")
    private EntityManager manager;
    @Override
    public FicheSante getFicheSante(String idcin) throws Exception {
        return FicheSante.getFicheSante(manager, idcin);
    }
}
