package com.doranco.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import com.doranco.dao.Dao;
import com.doranco.dao.DaoFactory;
import com.doranco.metier.CartePaiement;
import com.doranco.metier.Categorie;
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class CategorieDaoImpl implements Dao<Categorie>{

    private DaoFactory daoFactory;
    
    public CategorieDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(Categorie C) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(C);
            
            entityTransaction.commit();
            System.out.println("*** Creation categorie  success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur creation catégorie !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public Categorie findBy(int id) {
        
        EntityManager entityManager = null;
        
        Categorie paiement = new Categorie();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            paiement = entityManager.find(Categorie.class, id);
            if(paiement == null)
                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
        }catch(Exception e) {
            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return paiement;
    }

    @Override
    public void update(Categorie c, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Categorie categorieDB = entityManager.find(Categorie.class, id);
            if(categorieDB == null) {
                System.out.println("La categorie avec l'id " + id + " est inexistant en base !");
            }else {
            	categorieDB.setNom(c.getNom());
            	categorieDB.setRemise(c.getRemise());
            	categorieDB.setRemiseCumulable(c.isRemiseCumulable());
            	categorieDB.setPhoto(c.getPhoto());
            	categorieDB.setArticles(c.getArticles());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(categorieDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur mise à jour categorie ");
                System.out.println("Message: " + e.getMessage());
                if(entityTransaction != null)
                    entityTransaction.rollback();
            }finally {
            if(entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public void delete(int id) {
     EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = daoFactory.getEntityManager();
            Categorie categorieDB = entityManager.find(Categorie.class, id);
            if (categorieDB == null) {
                System.out.println("Categorie avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(categorieDB);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'une categorie avec l'id " + id);
            System.out.println("Message : " + e.getMessage());
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Categorie> findAll() {
        EntityManager entityManager = null;
        List<Categorie> categorie = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT c FROM CATEGORIE c");
            categorie = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur recherche liste categories !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return categorie;
    }

}
