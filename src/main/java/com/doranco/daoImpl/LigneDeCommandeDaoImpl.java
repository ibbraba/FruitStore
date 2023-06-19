package com.doranco.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import com.doranco.dao.Dao;
import com.doranco.dao.DaoFactory;
import com.doranco.metier.CartePaiement;
import com.doranco.metier.Categorie;
import com.doranco.metier.Commande;
import com.doranco.metier.Commentaire;
import com.doranco.metier.LigneDeCommande;
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class LigneDeCommandeDaoImpl implements Dao<LigneDeCommande>{

    private DaoFactory daoFactory;
    
    public LigneDeCommandeDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(LigneDeCommande L) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(L);
            
            entityTransaction.commit();
            System.out.println("*** Ligne de commande crée success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur création ligne de commande !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public LigneDeCommande findBy(int id) {
        
        EntityManager entityManager = null;
        
        LigneDeCommande ligneCommande = new LigneDeCommande();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            ligneCommande = entityManager.find(LigneDeCommande.class, id);
            if(ligneCommande == null)
                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
        }catch(Exception e) {
            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return ligneCommande;
    }

    @Override
    public void update(LigneDeCommande l, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            LigneDeCommande ligneCommandeDB = entityManager.find(LigneDeCommande.class, id);
            if(ligneCommandeDB == null) {
                System.out.println("La ligne de commande avec l'id " + id + " est inexistant en base !");
            }else {
            	ligneCommandeDB.setQuantite(l.getQuantite());
            	ligneCommandeDB.setPrixUnitaire(l.getPrixUnitaire());
            	ligneCommandeDB.setRemiseArticle(l.getRemiseArticle());
            	ligneCommandeDB.setCommande(l.getCommande());
            	ligneCommandeDB.setArticle(l.getArticle());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(ligneCommandeDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur mise à jour ligne de commande ");
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
            LigneDeCommande ligneCommande = entityManager.find(LigneDeCommande.class, id);
            if (ligneCommande == null) {
                System.out.println("Ligne de commande avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(ligneCommande);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'une ligne de commande avec l'id " + id);
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
    public List<LigneDeCommande> findAll() {
        EntityManager entityManager = null;
        List<LigneDeCommande> ligneCommande = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT l FROM LIGNE_COMMANDE l");
            ligneCommande = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur recherche liste ligne de commande !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return ligneCommande;
    }

}
