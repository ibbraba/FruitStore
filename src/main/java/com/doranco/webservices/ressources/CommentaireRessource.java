package com.doranco.webservices.ressources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doranco.metier.Article;
import com.doranco.metier.Commentaire;




@Path("/commentaire")
public class CommentaireRessource {

	
	
	@GET
	@Path("/test")
	public String testWebService(){
		return "OK Web Service";
	}
	
	
	@GET
	@Path("/article")
	@PathParam("{articleId}")
	
	public List<Commentaire> getCommentairesArticle(@PathParam("id") int id) throws SQLException {

		List<Commentaire> listCommentaires = new ArrayList<Commentaire>(); 

		try {
			// TODO: Import DAO commentaires impl et query commentaires de l'article

		} catch (Exception ex) {

		}

		return listCommentaires;

	}
	
	
	
	@GET
	@Path("/getall")
	public Object getCommentaires(@PathParam("login") String login, @PathParam("password") String password) {

		HashMap<Article, ArrayList<Commentaire>> listCommentaires = new HashMap<Article, ArrayList<Commentaire>>();
		

		try {
			//LOGIN USER 
			
			//CHECKER SI USER A LE PROFIL WEBSERVICE COMMENTAIRE
			
			//GET ALL ARTICLES 
			
			//FOREACH ARTICLE IN ARTICLES 
			
			//NEW LIST COMMENTAIRE
			
			//GET ARTICLES COMMENTAIRES
			
			//listCommentaires.Add(ARTICLE, LIST COMMENTAIRES)
			
			// TODO: Import DAO commentaires impl et query tous les commentaires

		} catch (Exception ex) {

		}

		return listCommentaires;

	}

	
		
	
	
	
	

	

}
