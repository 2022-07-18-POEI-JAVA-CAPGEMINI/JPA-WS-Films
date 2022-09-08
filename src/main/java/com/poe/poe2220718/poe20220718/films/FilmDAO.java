package com.poe.poe2220718.poe20220718.films;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class FilmDAO {
    
    public static void create(Film objectToCreate) {
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
                
        try {
            tx.begin();
            entityManager.persist(objectToCreate);
            entityManager.clear();
            tx.commit();
        }
        catch(Exception e) {
            System.out.println("Exception dans create() : "+e.getMessage());
            tx.rollback();
        }
    }
    
    public static Film findById(Long id){
         EntityManager entityManager = EntityManagerSingleton.getEntityManager();
         
         return entityManager.find(Film.class, id);
    }
    
    public static List<Film> findAll(){
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        
        Query query = entityManager.createQuery("SELECT f from Film f");
        return query.getResultList();
    }
    
    public static void delete(Film r){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
            EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        entityManager.remove(r);
        tx.commit();
    }
    
    public static void deleteById(Long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        EntityTransaction tx = entityManager.getTransaction();
        
        tx.begin();
        Query query = entityManager.createQuery("DELETE from Film c where c.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        tx.commit();
    }
    
    public static void update(Long id, Film newData){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        
        Film objectToUpdate = findById(id);
        
        objectToUpdate.setNotNullData(newData);
        Long realId = newData.getRealisateur().getId();
        Realisateur real = entityManager.find(Realisateur.class, realId);
        objectToUpdate.setRealisateur(real);
        
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(objectToUpdate);
        tx.commit();
    }
}
