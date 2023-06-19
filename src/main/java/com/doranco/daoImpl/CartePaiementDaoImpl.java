package com.doranco.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import com.doranco.dao.Dao;
import com.doranco.dao.DaoFactory;
import com.doranco.metier.CartePaiement;
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class CartePaiementDaoImpl implements Dao<CartePaiement>{

    private DaoFactory daoFactory;
    
    public CartePaiementDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(CartePaiement C) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(C);
            
            entityTransaction.commit();
            System.out.println("*** Carte de paiement créé avec success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur création carte de  paiement !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public CartePaiement findBy(int id) {
        
        EntityManager entityManager = null;
        
        CartePaiement paiement = new CartePaiement();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            paiement = entityManager.find(CartePaiement.class, id);
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
    public void update(CartePaiement c, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            CartePaiement cbDB = entityManager.find(CartePaiement.class, id);
            if(cbDB == null) {
                System.out.println("La carte de paiement avec l'id " + id + " est inexistant en base !");
            }else {
            	cbDB.setNomProprietaire(c.getNomProprietaire());
            	cbDB.setPrenomProprietaire(c.getPrenomProprietaire());
            	cbDB.setNumero(c.getNumero());
            	cbDB.setDateFinValidite(c.getDateFinValidite());
            	cbDB.setCryptogramme(c.getCryptogramme());
            	cbDB.setUtilisateur(c.getUtilisateur());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(cbDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur mise à jour carte de paiement ");
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
            CartePaiement cbDB = entityManager.find(CartePaiement.class, id);
            if (cbDB == null) {
                System.out.println("Carte de paiement avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(cbDB);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'une carte de paiement avec l'id " + id);
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
    public List<CartePaiement> findAll() {
        EntityManager entityManager = null;
        List<CartePaiement> cb = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT c FROM CARTE_PAIEMENT c");
            cb = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur recherche liste carte de paiement !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return cb;
    }

}
