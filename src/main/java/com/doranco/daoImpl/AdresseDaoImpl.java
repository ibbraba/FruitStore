package com.doranco.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.doranco.dao.Dao;
import com.doranco.dao.DaoFactory;
import com.doranco.metier.Adresse;
import com.doranco.metier.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AdresseDaoImpl implements Dao<Adresse>{

	  private DaoFactory daoFactory;
	    
	    public AdresseDaoImpl() {
	        this.daoFactory = DaoFactory.getInstance();
	    }
	 @Override
	    public void create(Adresse A) {
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
	            System.out.println("*** Erreur lors de la création d'une adresse !! ***");
	            System.out.println("Message: " + e.getMessage());
	            if(entityTransaction != null)
	                entityTransaction.rollback();
	        }finally {
	            if(entityManager != null)
	                entityManager.close();
	        }
	        
	    }

	    @Override
	    public Adresse findBy(int id) {
	        
	        EntityManager entityManager = null;
	        
	        Adresse adresse = new Adresse();
	        
	        try{
	            entityManager = daoFactory.getEntityManager();
	            
	            adresse = entityManager.find(Adresse.class, id);
	            if(adresse == null)
	                System.out.println("Erreur avec l'id "+id+ " n'existe pas en DB");
	        }catch(Exception e) {
	            System.out.println("Erreur de recherche id " + id+ " inexistant en DB");
	            System.out.println("Message: " + e.getMessage());
	         }finally {
	            if(entityManager != null)
	                entityManager.close();
	        }
	        return adresse;
	    }

	    @Override
	    public void update(Adresse a, int id) {
	        EntityManager entityManager = null;
	        EntityTransaction entityTransaction = null;
	        
	        try {
	            entityManager = daoFactory.getEntityManager();
	            
	            Adresse adresseDB = entityManager.find(Adresse.class, id);
	            if(adresseDB == null) {
	                System.out.println("L'adresse avec l'id " + id + " est inexistant en base !");
	            }else {
	            	adresseDB.setNumero(a.getNumero());
	            	adresseDB.setRue(a.getRue());
	            	adresseDB.setVille(a.getVille());
	            	adresseDB.setCodePostal(a.getCodePostal());
	            	adresseDB.setUtilisateur(a.getUtilisateur());
	                
	                entityTransaction = entityManager.getTransaction();
	                entityTransaction.begin();
	                
	                entityManager.persist(adresseDB);
	                entityTransaction.commit();
	            }
	        }catch(Exception e) {
	                System.out.println("Erreur mise à jour adresse ");
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
	            Adresse adresseDB = entityManager.find(Adresse.class, id);
	            if (adresseDB == null) {
	                System.out.println("Adresse avec id " + id + " inexistant !");
	            } else {
	                entityTransaction = entityManager.getTransaction();

	                entityTransaction.begin();
	                entityManager.remove(adresseDB);
	                entityTransaction.commit();
	                System.out.println("Suppression Success !");
	            }
	        } catch (Exception e) {
	            System.out.println ("Erreur lors de la suppression d'une adresse avec l'id " + id);
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
	    public List<Adresse> findAll() {
	        EntityManager entityManager = null;
	        List<Adresse> listeAdresses = new ArrayList<>();
	        
	        try {
	            entityManager = daoFactory.getEntityManager();
	            
	            Query query = entityManager.createQuery("SELECT a FROM ADRESSE a");
	            listeAdresses = query.getResultList();
	            
	        }catch(Exception e) {
	            System.out.println("Erreur recherche liste d'adresses !");
	            System.out.println("Message: " + e.getMessage());
	        }
	        
	        return listeAdresses;
	    }

}
