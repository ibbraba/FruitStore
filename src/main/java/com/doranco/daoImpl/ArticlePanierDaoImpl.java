package com.doranco.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import com.doranco.dao.Dao;
import com.doranco.dao.DaoFactory;
import com.doranco.metier.ArticlePanier;
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class ArticlePanierDaoImpl implements Dao<ArticlePanier>{

    private DaoFactory daoFactory;
    
    public ArticlePanierDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(ArticlePanier A) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(A);
            
            entityTransaction.commit();
            System.out.println("*** Création Success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur lors de l'ajout d'un article au panier !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public ArticlePanier findBy(int id) {
        
        EntityManager entityManager = null;
        
        ArticlePanier articlePanier = new ArticlePanier();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            articlePanier = entityManager.find(ArticlePanier.class, id);
            if(articlePanier == null)
                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
        }catch(Exception e) {
            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return articlePanier;
    }

    @Override
    public void update(ArticlePanier u, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            ArticlePanier articlePanierDB = entityManager.find(ArticlePanier.class, id);
            if(articlePanierDB == null) {
                System.out.println("Le panier  avec l'id " + id + " est inexistant en base !");
            }else {
            	articlePanierDB.setArticle(u.getArticle());
            	articlePanierDB.setQuantite(u.getQuantite());
            	articlePanierDB.setUtilisateur(u.getUtilisateur());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(articlePanierDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur mise à jour du panier ");
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
            ArticlePanier userDB = entityManager.find(ArticlePanier.class, id);
            if (userDB == null) {
                System.out.println("Le panier avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(userDB);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'un panier avec l'id " + id);
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
    public List<ArticlePanier> findAll() {
        EntityManager entityManager = null;
        List<ArticlePanier> panier = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT e FROM PANIER e");
            panier = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur recherche liste paniers !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return panier;
    }

}
