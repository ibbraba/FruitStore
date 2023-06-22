package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.CartePaiementDaoImpl;
import com.doranco.metier.CartePaiement;
import com.doranco.metier.Utilisateur;

public class CartePaiementDao {
	
	private CartePaiementDaoImpl uDaoImpl = new CartePaiementDaoImpl();
	private CartePaiement carte = new CartePaiement();
	
	public CartePaiement createCarte() { // ROLE : CLIENT
		uDaoImpl.create(carte);
		return carte;
	}
	
	public void editCarte() { // ROLE : ADMIN, CLIENT
		uDaoImpl.update(carte, carte.getId());
	}
	
	public void deleteCarte() { // ROLE : ADMIN, CLIENT
		uDaoImpl.delete(carte.getId());
	}
	
	public List<Utilisateur> findAllCartes() { // ROLE : ADMIN, CLIENT (Voir ses differentes carte de paiement)
		List<Utilisateur> carteList = new ArrayList<>();
		uDaoImpl.findAll();
		return carteList;
	}
	
}
