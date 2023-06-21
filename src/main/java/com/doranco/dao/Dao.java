package com.doranco.dao;
import java.util.List;

/**
 *
 * @author celes
 */
public interface Dao<A> {
    
    /**
     *  Créer un élément
     * @param a 
     */
    void create(A a);
    
    /**
     * Recherche un élément
     * @param id
     * @return 
     */
     A findBy(int id);
     
     /**
      * Mettre à jour un élément
      * @param t
      * @param id 
      */
     void update(A a, int id);
     
     /**
      * Supprimer un élément
      * @param id 
      */
     void delete(int id);
     
     /**
      * Rechercher tous les élément
      * @return 
      */
     List<A> findAll();
}
