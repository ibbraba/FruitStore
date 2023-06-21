package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.AdresseDaoImpl;
import com.doranco.metier.Adresse;

public class AdresseDao {
	
	private AdresseDaoImpl uDaoImpl = new AdresseDaoImpl();
	private Adresse adresse = new Adresse();
	
	public Adresse createAdresse() { // ROLE : ADMIN, MAGASINIER, CLIENT
		uDaoImpl.create(adresse);
		return adresse;
	}
	
	public void editAdresse() { // ROLE : ADMIN, MAGASINIER, CLIENT
		uDaoImpl.update(adresse, adresse.getId()); 
	}
	
	public void deleteAdresse() { // ROLE : ADMIN, MAGASINIER, CLIENT
		uDaoImpl.delete(adresse.getId()); // Check logique adresse Fac et Liv
	}
	
	public List<Adresse> findAllAdresses() { // ROLE : ADMIN
		List<Adresse> adresseList = new ArrayList<>(); // Check logique && utilité adresses LIST
		uDaoImpl.findAll();
		return adresseList;
	}
}
