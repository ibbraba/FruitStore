package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.ArticlePanierDaoImpl;
import com.doranco.metier.ArticlePanier;
import com.doranco.metier.Utilisateur;

public class ArticlePanierDao {
	
	private ArticlePanierDaoImpl uDaoImpl = new ArticlePanierDaoImpl();
	private ArticlePanier panier = new ArticlePanier();
	
	public ArticlePanier createPanier() { // ROLE : CLIENT
		uDaoImpl.create(panier);
		return panier;
	}
	
	public void editPanier() { // ROLE : CLIENT
		uDaoImpl.update(panier, panier.getId());
	}
	
	public void deletePanier() { // ROLE : CLIENT, panier en bbd donc si délai projet OK check pour durée de vie du panier
		uDaoImpl.delete(panier.getId());
	}
	
	public List<Utilisateur> findAllPaniers() { // ROLE: ADMIN, CLIENT
		List<Utilisateur> panierList = new ArrayList<>();
		uDaoImpl.findAll();
		return panierList;
	}
	
}
