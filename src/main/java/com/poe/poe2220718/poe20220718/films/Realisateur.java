package com.poe.poe2220718.poe20220718.films;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="realisateurs")
public class Realisateur {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    private String nom;
    private String prenom;
    private String nationalite;

    public Realisateur() {
      
    }
        
    public Realisateur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @Override
    public String toString() {
        return "Realisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nationalite=" + nationalite + '}';
    }
    
    public void setNotNullData(Realisateur newData){
        
      if(newData.getNom() != null) {
          this.setNom(newData.getNom());
      }
      if(newData.getPrenom() != null) {
          this.setPrenom(newData.getPrenom());
      }
      if(newData.getNationalite()!= null) {
          this.setNationalite(newData.getNationalite());
      }

    }
}
