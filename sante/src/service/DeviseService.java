package service;

import devise.Cours;
import devise.Devise;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/devise")
public class DeviseService {

  @PersistenceContext(name = "santePersistenceUnit")
  private EntityManager manager;

  @GET
  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Devise> getCitoyenSante() {
    return Devise.getAll(manager);
  }

  @GET
  @Path("/cours/{iddevise}/{date}")
  @Produces(MediaType.APPLICATION_JSON)
  public Cours getCours(@PathParam("iddevise") String cin, @PathParam("date") String date) throws Exception {
    try {
      Cours c = new Cours(date, cin);
      c.complete(manager);
      return c;
    } catch (Exception e) {
      throw e;
    }
  }
}
