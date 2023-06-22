package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.LigneDeCommandeDaoImpl;
import com.doranco.metier.LigneDeCommande;

public class LigneDeCommandeDao {
	
	private LigneDeCommandeDaoImpl uDaoImpl = new LigneDeCommandeDaoImpl();
	private LigneDeCommande ligneCommande = new LigneDeCommande();
	
	public LigneDeCommande createLigneCommande() { // ROLE : ADMIN, CLIENT
		uDaoImpl.create(ligneCommande);
		return ligneCommande;
	}
	
	public void editLigneCommande() { // ROLE : ADMIN, CLIENT
		uDaoImpl.update(ligneCommande, ligneCommande.getId());
	}
	
	public void deleteLigneCommande() { // ROLE : ADMIN, CLIENT
		uDaoImpl.delete(ligneCommande.getId());
	}
	
	public List<LigneDeCommande> findAllLigneCommandes() { // ROLE : ADMIN
		List<LigneDeCommande> commandeList = new ArrayList<>();
		uDaoImpl.findAll();
		return commandeList;
	}
	
}
