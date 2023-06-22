package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.CategorieDaoImpl;
import com.doranco.metier.Categorie;
import com.doranco.metier.Utilisateur;

public class CategorieDao {
	
	private CategorieDaoImpl uDaoImpl = new CategorieDaoImpl();
	private Categorie categorie = new Categorie();
	
	public Categorie createCategorie() { // ROLE : ADMIN 
		uDaoImpl.create(categorie);
		return categorie;
	}
	
	public void editCategorie() { // ROLE : ADMIN 
		uDaoImpl.update(categorie, categorie.getId());
	}
	
	public void deleteCategorie() { // ROLE : ADMIN
		uDaoImpl.delete(categorie.getId());
	}
	
	public List<Utilisateur> findAllCategories() { // ROLE : ADMIN, MAGASINIER, CLIENT
		List<Utilisateur> categorieList = new ArrayList<>();
		uDaoImpl.findAll();
		return categorieList;
	}
	
}
