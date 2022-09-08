package com.poe.poe2220718.poe20220718.films;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="films")
public class Film {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    private String titre;
    private Integer annee;
    private String genre;
    
    @ManyToOne
    @JoinColumn(name="realisateur_id")
    private Realisateur realisateur;
    

    public Film() {
      
    }

    public Film(String titre, Integer annee, String genre, Realisateur realisateur) {
        this.titre = titre;
        this.annee = annee;
        this.genre = genre;
        this.realisateur = realisateur;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", titre=" + titre + ", annee=" + annee + ", genre=" + genre + ", realisateur=" + realisateur + '}';
    }
    
    
    
    public void setNotNullData(Film newData){
        
      if(newData.getTitre() != null) {
          this.setTitre(newData.getTitre());
      }
      if(newData.getAnnee() != null) {
          this.setAnnee(newData.getAnnee());
      }
      if(newData.getGenre()!= null) {
          this.setGenre(newData.getGenre());
      }

      
    }
}
