package com.doranco.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import com.doranco.dao.Dao;
import com.doranco.dao.DaoFactory;

/**
 *
 * @author celes
 */
public class UtilisateurDaoImpl implements Dao<Utilisateur>{

    private DaoFactory daoFactory;
    
    public ArticleDaoImpl() {
        this.daoFactory = DaoFactory.getInstance();
    }
    
    @Override
    public void create(Utilisateur U) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.persist(U);
            
            entityTransaction.commit();
            System.out.println("*** Création Success ! **");
        }catch(Exception e) {
            System.out.println("*** Erreur lors de la création d'un utilisateur !! ***");
            System.out.println("Message: " + e.getMessage());
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        
    }

    @Override
    public Utilisateur findBy(int id) {
        
        EntityManager entityManager = null;
        
        Utilisateur user = new Utilisateur();
        
        try{
            entityManager = daoFactory.getEntityManager();
            
            user = entityManager.find(Utilisateur.class, id);
            if(user == null)
                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
        }catch(Exception e) {
            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return user;
    }

    @Override
    public void update(Utilisateur u, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Utilisateur userDB = entityManager.find(Utilisateur.class, id);
            if(userDB == null) {
                System.out.println("L'utilisateur avec l'id " + id + " est inexistant en base !");
            }else {
            	userDB.setTitre(u.getTitre());
            	userDB.setDescription(u.getDescription());
            	userDB.setIsbn(u.getIsbn());
                
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                
                entityManager.persist(userDB);
                entityTransaction.commit();
            }
        }catch(Exception e) {
                System.out.println("Erreur update livre ");
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
            Utilisateur userDB = entityManager.find(Utilisateur.class, id);
            if (userDB == null) {
                System.out.println("Livre avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(userDB);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println ("Erreur lors de la suppression d'un utilisateur avec l'id " + id);
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
    public List<Utilisateur> findAll() {
        EntityManager entityManager = null;
        List<Utilisateur> listeUsers = new ArrayList<>();
        
        try {
            entityManager = daoFactory.getEntityManager();
            
            Query query = entityManager.createQuery("SELECT e FROM User e");
            listeUsers = query.getResultList();
            
        }catch(Exception e) {
            System.out.println("Erreur édition liste livres !");
            System.out.println("Message: " + e.getMessage());
        }
        
        return listeUsers;
    }

}
