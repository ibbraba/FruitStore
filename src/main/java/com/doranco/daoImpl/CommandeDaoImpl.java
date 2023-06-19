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
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class CommandeDaoImpl implements Dao<Commande>{

    private DaoFactory daoFactory;
    
    public CommandeDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(Commande C) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(C);
            
            entityTransaction.commit();
            System.out.println("*** Validation commande  success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur validation commande !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public Commande findBy(int id) {
        
        EntityManager entityManager = null;
        
        Commande commande = new Commande();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            commande = entityManager.find(Commande.class, id);
            if(commande == null)
                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
        }catch(Exception e) {
            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return commande;
    }

    @Override
    public void update(Commande c, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Commande commandeDB = entityManager.find(Commande.class, id);
            if(commandeDB == null) {
                System.out.println("La commande avec l'id " + id + " est inexistant en base !");
            }else {
            	commandeDB.setNumero(c.getNumero());
            	commandeDB.setDateCreation(c.getDateCreation());
            	commandeDB.setDateLivraison(c.getDateLivraison());
            	commandeDB.setTotalRemise(c.getTotalRemise());
            	commandeDB.setFraisExpedition(c.getFraisExpedition());
            	commandeDB.setTotalGeneral(c.getTotalGeneral());
            	commandeDB.setAdresseFacturation(c.getAdresseFacturation());
            	commandeDB.setAdresseLivraison(c.getAdresseLivraison());
            	commandeDB.setCartePaiementDefaut(c.getCartePaiementDefaut());
            	commandeDB.setUtilisateur(c.getUtilisateur());
            	commandeDB.setLigneCommande(c.getLigneCommande());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(commandeDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur mise à jour commande ");
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
            Commande commande = entityManager.find(Commande.class, id);
            if (commande == null) {
                System.out.println("Commande avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(commande);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'une commande avec l'id " + id);
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
    public List<Commande> findAll() {
        EntityManager entityManager = null;
        List<Commande> commande = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT c FROM COMMANDE c");
            commande = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur recherche liste des commandes !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return commande;
    }

}
