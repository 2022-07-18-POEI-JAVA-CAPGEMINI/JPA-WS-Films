package com.poe.poe20220718.poe20220118.films;

import com.poe.poe2220718.poe20220718.films.Film;
import com.poe.poe2220718.poe20220718.films.FilmDAO;
import com.poe.poe2220718.poe20220718.films.Realisateur;
import com.poe.poe2220718.poe20220718.films.RealisateurDAO;
import java.util.List;
import org.junit.jupiter.api.Test;


public class FilmTest {
    
    //@Test
    public void testCreateRealisateur() {
        
        Realisateur realisateur = new Realisateur("Cameron", "James", "USA");
        RealisateurDAO.create(realisateur);
        
    }
    
    //@Test
    public void testCreateFilm() {
        
        Realisateur james = new Realisateur("Cameron", "James", "USA");
        RealisateurDAO.create(james);
        
        Film film = new Film("Titanic", 1997, "Drame", james);
        FilmDAO.create(film);
    }
    
    //@Test
    public void testReadFilm() {
        
        Film film = FilmDAO.findById(1L);
        System.out.println(film);
        
    }
    
    //@Test
    public void testGetAllFilms() {
        
        List<Film> films = FilmDAO.findAll();
        for(Film film : films){
            System.out.println(film);     
        }
       
        
    }
}
