package com.doranco.dao;
import java.util.List;

/**
 *
 * @author celes
 */
public interface Dao<A> {
    
    /**
     *  Créer un article
     * @param a 
     */
    void create(A a);
    
    /**
     * Recherche un article
     * @param id
     * @return 
     */
     A findBy(int id);
     
     /**
      * Mettre à jour un article
      * @param t
      * @param id 
      */
     void update(A a, int id);
     
     /**
      * Supprimer un article
      * @param id 
      */
     void delete(int id);
     
     /**
      * Rechercher tous les articles
      * @return 
      */
     List<A> findAll();
}
