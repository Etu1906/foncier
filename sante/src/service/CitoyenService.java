package service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import sante.Citoyen;
import sante.FicheSante;

@Path("/citoyens")
@Stateless
public class CitoyenService {

  @PersistenceContext(name = "santePersistenceUnit")
  private EntityManager manager;

  @GET
  @Path("/getSante/{cin}")
  @Produces(MediaType.APPLICATION_JSON)
  public FicheSante getCitoyenSante(@PathParam("cin") String cin) {
    return FicheSante.getFicheSante(manager, cin);
  }

  @GET
  @Path("/{cin}")
  @Produces(MediaType.APPLICATION_JSON)
  public Citoyen getCitoyen(@PathParam("cin") String cin) {
    Citoyen result = new Citoyen(cin);
    result.getCitoyen(manager);
    return result;
  }
}
