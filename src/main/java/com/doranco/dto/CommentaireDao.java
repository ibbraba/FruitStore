package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.CommentaireDaoImpl;
import com.doranco.metier.Commentaire;

public class CommentaireDao {
	
	private CommentaireDaoImpl uDaoImpl = new CommentaireDaoImpl();
	private Commentaire commentaire = new Commentaire();
	
	public Commentaire createCommentaire() { // ROLE : ADMIN, CLIENT
		uDaoImpl.create(commentaire);
		return commentaire;
	}
	
	public void editCommentaire() { // ROLE : ADMIN, CLIENT
		uDaoImpl.update(commentaire, commentaire.getId());
	}
	
	public void deleteCommentaire() { // ROLE : ADMIN, CLIENT && (MAGASINIER si pas content du commentaire client)
		uDaoImpl.delete(commentaire.getId());
	}
	
	public List<Commentaire> findAllCommentaires() { // ROLE : ADMIN, MAGASINIER, CLIENT
		List<Commentaire> commentaireList = new ArrayList<>();
		uDaoImpl.findAll();
		return commentaireList;
	}
	
}
