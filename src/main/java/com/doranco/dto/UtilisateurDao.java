package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.UtilisateurDaoImpl;
import com.doranco.metier.Utilisateur;

public class UtilisateurDao {
	
	private UtilisateurDaoImpl uDaoImpl = new UtilisateurDaoImpl();
	private Utilisateur user = new Utilisateur();
	
	public Utilisateur createUser() { // ROLE : ADMIN, MAGASINIER
		uDaoImpl.create(user);
		return user;
	}
	
	public void editUser() { // ROLE : ADMIN, MAGASINIER, CLIENT
		uDaoImpl.update(user, user.getId());
	}
	
	public void deleteUser() { // ROLE : ADMIN, MAGASINIER (suppression compte, si délai projet OK), CLIENT(suppression compte, si délai projet OK)
		uDaoImpl.delete(user.getId());
	}
	
	public List<Utilisateur> findAllUsers() { // ROLE : ADMIN, si délai projet OK check filtre pour CLIENT search MAGASINIER en particulier
		List<Utilisateur> userList = new ArrayList<>();
		uDaoImpl.findAll();
		return userList;
	}
	
}
