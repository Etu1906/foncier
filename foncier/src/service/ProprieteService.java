package service;

import com.google.gson.Gson;
import foncier.FicheFoncier;
import foncier.Propriete;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("")
public class ProprieteService {

  @PersistenceContext(name = "foncierPersistenceUnit")
  private EntityManager manager;

  @GET
  @Path("/proprietes/{idcin}")
  @Produces(MediaType.APPLICATION_JSON)
  public FicheFoncier getFicheFoncier(@PathParam("idcin") String idcin)
    throws Exception {
    FicheFoncier fiche = new FicheFoncier(idcin);
    fiche.getData(manager);
    return fiche;
  }

  @GET
  @Path("/propriete/{idpropriete}")
  @Produces(MediaType.APPLICATION_JSON)
  public Propriete getPropriete(@PathParam("idpropriete") int idpropriete)
    throws Exception {
    Propriete p = new Propriete(idpropriete);
    p.getDetails(manager);
    return p;
  }

  @POST
  @Path("/propriete/{donneesJSON}/{idcin}")
  public void insert(
    @PathParam("donneesJSON") String donneesJSON,
    @PathParam("idcin") String idcin
  ) throws Exception {
    Gson gson = new Gson();
    FicheFoncier f = gson.fromJson(donneesJSON, FicheFoncier.class);
    f.insert(manager);
  }
}
