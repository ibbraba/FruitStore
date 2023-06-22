package com.doranco.services;

import java.util.ArrayList;
import java.util.List;

import com.doranco.fixtures.UtilisateurFixtures;
import com.doranco.metier.Utilisateur;

public class UtilisateurService {

	public Utilisateur findUtilisateur(String email, String password) {
		
		List<Utilisateur> utilisateurs = UtilisateurFixtures.getAllUtilisateurs(); 
	
		for (Utilisateur utilisateur  : utilisateurs) {
			if(utilisateur.getEmail().equals(email) && utilisateur.getPassword().equals(password)) {
				
				return utilisateur;
			}
		}
		return null;
		
	}
}
