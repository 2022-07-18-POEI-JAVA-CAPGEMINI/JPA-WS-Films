package com.poe.poe2220718.poe20220718.films;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RealisateurDAO {
    
    public static void create(Realisateur objectToCreate) {
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
                
        try {
            tx.begin();
            entityManager.persist(objectToCreate);
            tx.commit();
        }
        catch(Exception e) {
            System.out.println("Exception dans create() : "+e.getMessage());
            tx.rollback();
        }
    }
    
    public static Realisateur findById(Long id){
         EntityManager entityManager = EntityManagerSingleton.getEntityManager();
         
         return entityManager.find(Realisateur.class, id);
    }
    
    public static List<Realisateur> findAll(){
        
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();     
        
        Query query = entityManager.createQuery("SELECT r from Realisateur r");
        return query.getResultList();
    }
    
    public static void delete(Realisateur r){
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
        Query query = entityManager.createQuery("DELETE from Realisateur c where c.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        tx.commit();
    }
    
    public static void update(Long id, Realisateur newData){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        
        Realisateur objectToUpdate = findById(id);
        
        objectToUpdate.setNotNullData(newData);
        
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(objectToUpdate);
        tx.commit();
    }
}
