package com.doranco.webservices.ressources;

import java.util.HashMap;

import javax.enterprise.inject.Produces;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;



@Path("/commande")
public class CommandeRessource {
	

	@GET
	@Path("/city")
	
	public String getNbCommandesParVille() {
		
		HashMap<String, Integer> nbCommande = new HashMap<String, Integer>();
		
		//LOGIN USER 
		
		//CREATE LIST<ville> 
		
		//FOREACH VILLE IN LIST VILLES 
		
		// SELECT COUNT COMMANDES WHERE VILLE = VILLE 
		
		// HASHMAP.Add(Ville, NB COMMANDES)
		
		//FOREACH VILLE IN 
		
		
		try {
			// TODO: Import DAO commentaires impl et query tous les commentaires

		} catch (Exception ex) {

		} 
		
		return "OK commande";
		
		
	}
	

	@GET
	public Object getUtilisateursAvecPanierNonVide(@PathParam("login") String login, @PathParam("password") String password ) {
		
		HashMap<Object, Object> listUtilisateurAvecPanier = new HashMap<Object, Object>(); 
		
		//LOGIN USER 
		
		//CHECKER SI USER A LE PROFIL WEB SERVICE MARKETING
		
		//SELECT UTILISATRUR WHERE PANIER.LENGTH > 0 
		
		//FOREACH UTILISATEUR IN LIST UTILISATEUR 
			// CREATE POJO UTILISATEUR 
			// CREATE LIST POJO ARTICLES
		
			// FOREACH ARTICLE IN LIST PANIER  
			// CREATE POJO ARTICLE 
			// ADD POJO ARTICLE TO LIST POJO 	
			
			//listUtilisateurAvecPanier.Add (POJO Utilisateur, List<POJO_PANIER>)
		
		
		return listUtilisateurAvecPanier;
		
	}
}
