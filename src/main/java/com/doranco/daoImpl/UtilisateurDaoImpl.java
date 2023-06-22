package com.doranco.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.doranco.dao.ConnectToDB;
import com.doranco.dao.Dao;
import com.doranco.dao.DaoFactory;
import com.doranco.metier.Utilisateur;

/**
 *
 * @author celes
 */
public class UtilisateurDaoImpl implements Dao<Utilisateur> {

    private DaoFactory daoFactory;

    public UtilisateurDaoImpl() {
  
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
        } catch (Exception e) {
            System.out.println("*** Erreur lors de la création d'un utilisateur !! ***");
            System.out.println("Message: " + e.getMessage());
            if (entityTransaction != null)
                entityTransaction.rollback();
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public Utilisateur findBy(int id) {

        EntityManager entityManager = null;

        Utilisateur user = new Utilisateur();

        try {
            entityManager = daoFactory.getEntityManager();

            user = entityManager.find(Utilisateur.class, id);
            if (user == null)
                System.out.println("Erreur avec l'id " + id + " n'existe pas en DB");
        } catch (Exception e) {
            System.out.println("Erreur de recherche id " + id + " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
        return user;
    }

    
    public Utilisateur findByCredentials(String email, String password) {
        

      	Utilisateur utilisateur = new Utilisateur(); 
        try{
        	
        	   Connection cnn = ConnectToDB.getConnection();
        	   PreparedStatement req = cnn.prepareStatement( "SELECT u FROM Utilisateur u WHERE email=? AND password=? ");
        	   req.setString(1, email);
        	   req.setString(2, password);
               ResultSet resultSet = req.executeQuery();
             
               utilisateur.setNom(resultSet.getString("nom"));
               utilisateur.setPrenom(resultSet.getString("prenom"));
               utilisateur.setEmail(resultSet.getString("email"));
               utilisateur.setPassword(resultSet.getString("password"));
               
               
            if(utilisateur == null) {
            	 System.out.println("User not found");
            	
            }
        }catch(Exception e) {
           // System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
            System.out.println("Message: " + e.getMessage());
         }
        
        return utilisateur;
    }
    
    @Override
    public void update(Utilisateur u, int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = daoFactory.getEntityManager();

            Utilisateur userDB = entityManager.find(Utilisateur.class, id);
            if (userDB == null) {
                System.out.println("L'utilisateur avec l'id " + id + " est inexistant en base !");
            } else {
                userDB.setNom(u.getNom());
                userDB.setNom(u.getPrenom());
                userDB.setDateNaissance(u.getDateNaissance());
                userDB.setActif(u.isActif());
                userDB.setProfil(u.getProfil());
                userDB.setEmail(u.getEmail());
                userDB.setEmail(u.getEmail());
                userDB.setPassword(u.getPassword());
                userDB.setPassword(u.getPassword());
                userDB.setTelephone(u.getTelephone());
                userDB.setAdresse(u.getAdresse());
                userDB.setCommande(u.getCommande());
                userDB.setCartesDePaiement(u.getCartesDePaiement());
                userDB.setCommentaires(u.getCommentaires());
                userDB.setPanier(u.getPanier());

                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();

                entityManager.persist(userDB);
                entityTransaction.commit();
            }
        } catch (Exception e) {
            System.out.println("Erreur mise à jour utilisateur");
            System.out.println("Message: " + e.getMessage());
            if (entityTransaction != null)
                entityTransaction.rollback();
        } finally {
            if (entityManager != null)
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
                System.out.println("Utilisateur avec id " + id + " inexistant !");
            } else {
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.remove(userDB);
                entityTransaction.commit();
                System.out.println("Suppression Success !");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression d'un utilisateur avec l'id " + id);
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

            Query query = entityManager.createQuery("SELECT u FROM UTILISATEUR u");
            listeUsers = query.getResultList();

        } catch (Exception e) {
            System.out.println("Erreur recherche liste utilisateurs !");
            System.out.println("Message: " + e.getMessage());
        }

        return listeUsers;
    }
    
    

}
