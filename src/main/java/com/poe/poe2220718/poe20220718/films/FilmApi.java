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
import javax.ws.rs.core.Response;

@Path("films")
public class FilmApi {
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Film> getFilms(){
         System.out.println("------ getFilms()");
        
        List<Film> films = FilmDAO.findAll();
        for(Film film : films){
            System.out.println(film);     
        }
       
        return films;
    }
    
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public Response postFilm(Film newFilm) {
        
        System.out.println("objet reçue : "+newFilm);
        
        FilmDAO.create(newFilm);
        
        return Response.status(201).entity(newFilm).build();
    } 
    
        
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
      
        Film filmToDelete = FilmDAO.findById(id);
        System.out.println("filmToDelete: "+filmToDelete);
        
        if(filmToDelete == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
             FilmDAO.deleteById(id);
             return Response.status(200).build();
        }
        
        
     
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response update(Film data, @PathParam("id") long id) {
      
        try { // une meilleure solution aurait été de vérifier l'existence en BD
            FilmDAO.update(id, data);
            return Response.status(Response.Status.ACCEPTED).build();
        }
        catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity("<h1>ID inconnu</h1>").build();
        }
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
