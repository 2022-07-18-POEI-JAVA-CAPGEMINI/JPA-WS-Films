package com.poe.poe2220718.poe20220718.films;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("realisateurs")
public class RealisateurApi {
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Realisateur> getRealisateurs(){
        
        return  RealisateurDAO.findAll();
    }
    
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public void postRealisateur(Realisateur newRealisateur) {
        
        RealisateurDAO.create(newRealisateur);
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        
       RealisateurDAO.deleteById(id);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void update(Realisateur real, @PathParam("id") long id) {
        

      RealisateurDAO.update(id, real);
    }
    
    /*
    @GET
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public Person getOnePersonne(@PathParam("id") int id, @Context HttpServletRequest request){
        
        List<Person> personnes = (List)request.getSession().getAttribute("persons");
        if(personnes == null) {
            personnes = new ArrayList<>();
            request.getSession().setAttribute("persons", personnes);
        }
        
        Person p = personnes.get(id);
        return p;
    }
    

    
*/
}
