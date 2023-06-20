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
import com.doranco.metier.Commande;
import com.doranco.metier.Commentaire;
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class CommentaireDaoImpl implements Dao<Commentaire>{

    private DaoFactory daoFactory;
    
    public CommentaireDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(Commentaire C) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(C);
            
            entityTransaction.commit();
            System.out.println("*** Commentaire post success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur post commentaire !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public Commentaire findBy(int id) {
        
        EntityManager entityManager = null;
        
        Commentaire commentaire = new Commentaire();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            commentaire = entityManager.find(Commentaire.class, id);
            if(commentaire == null)
                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
        }catch(Exception e) {
            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return commentaire;
    }

    @Override
    public void update(Commentaire c, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Commentaire commentDB = entityManager.find(Commentaire.class, id);
            if(commentDB == null) {
                System.out.println("Le commentaire avec l'id " + id + " est inexistant en base !");
            }else {
            	commentDB.setTexte(c.getTexte());
            	commentDB.setNote(c.getNote());
            	commentDB.setArticle(c.getArticle());
            	commentDB.setUtilisateur(c.getUtilisateur());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(commentDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur mise à jour commentaire ");
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
            Commentaire comment = entityManager.find(Commentaire.class, id);
            if (comment == null) {
                System.out.println("Commande avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(comment);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'une commentaire avec l'id " + id);
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
    public List<Commentaire> findAll() {
        EntityManager entityManager = null;
        List<Commentaire> comment = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT c FROM CB c");
            comment = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur recherche liste commentaire !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return comment;
    }

}
