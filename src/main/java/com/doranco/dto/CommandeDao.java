package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.CommandeDaoImpl;
import com.doranco.metier.Commande;

public class CommandeDao {
	
	private CommandeDaoImpl uDaoImpl = new CommandeDaoImpl();
	private Commande commande = new Commande();
	
	public Commande createCommande() { // ROLE : ADMIN, CLIENT
		uDaoImpl.create(commande);
		return commande;
	}
	
	public void editCommande() { // ROLE : ADMIN, CLIENT
		uDaoImpl.update(commande, commande.getId());
	}
	
	public void deleteCommande() { // ROLE : ADMIN, CLIENT
		uDaoImpl.delete(commande.getId());
	}
	
	public List<Commande> findAllCommandes() { // ROLE : ADMIN, MAGASINIER, CLIENT
		List<Commande> commandeList = new ArrayList<>();
		uDaoImpl.findAll();
		return commandeList;
	}
	
}
