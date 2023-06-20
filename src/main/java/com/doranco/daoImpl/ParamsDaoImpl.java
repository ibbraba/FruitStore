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
import com.doranco.metier.LigneDeCommande;
import com.doranco.metier.Params;
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class ParamsDaoImpl implements Dao<Params>{

    private DaoFactory daoFactory;
    
    public ParamsDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(Params P) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(P);
            
            entityTransaction.commit();
            System.out.println("*** Paramètre crée success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur création paramètre !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public Params findBy(int id) {
        
        EntityManager entityManager = null;
        
        Params params = new Params();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            params = entityManager.find(Params.class, id);
            if(params == null)
                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
        }catch(Exception e) {
            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return params;
    }

    @Override
    public void update(Params p, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Params paramsDB = entityManager.find(Params.class, id);
            if(paramsDB == null) {
                System.out.println("Le paramètre avec l'id " + id + " est inexistant en base !");
            }else {
            	paramsDB.setCle_cryptage_pwd(p.getCle_cryptage_pwd());
            	paramsDB.setCle_cryptage_cp(p.getCle_cryptage_cp());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(paramsDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur mise à jour du paramètre ");
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
            Params params = entityManager.find(Params.class, id);
            if (params == null) {
                System.out.println("Le paramètre avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(params);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'un paramètre avec l'id " + id);
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
    public List<Params> findAll() {
        EntityManager entityManager = null;
        List<Params> params = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT p FROM PARAMETRE p");
            params = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur recherche liste parametres !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return params;
    }

}
