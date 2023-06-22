package com.doranco.fixtures;

import java.util.ArrayList;
import java.util.List;

import com.doranco.metier.Adresse;
import com.doranco.metier.Utilisateur;

public class UtilisateurFixtures {

	public static Utilisateur createClient() {
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setId(1);
		utilisateur.setPrenom("John");
		utilisateur.setNom("Doe");
		utilisateur.setEmail("client@gmail.com");
		utilisateur.setProfil("Client");
		utilisateur.setPassword("password");
		
		return utilisateur;
	}
	
	public static Utilisateur createMagasinier() {
		Utilisateur utilisateur = new Utilisateur(); 
		utilisateur.setId(2);
		utilisateur.setPrenom("Paul");
		utilisateur.setNom("Paul");
		utilisateur.setEmail("magasinier@gmail.com");
		utilisateur.setProfil("Magasinier");
		utilisateur.setPassword("password");
		return utilisateur;
	}
	
	public static Utilisateur createAdmin() {
		Utilisateur utilisateur = new Utilisateur(); 
		utilisateur.setId(2);
		utilisateur.setPrenom("Jean");
		utilisateur.setNom("Pierre");
		utilisateur.setEmail("amdin@gmail.com");
		utilisateur.setProfil("Admin");
		utilisateur.setPassword("password");
		return utilisateur;
	}
	
	public static List<Utilisateur> getAllUtilisateurs(){

		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>(); 
		Utilisateur utilisateur =  createClient();
		Utilisateur utilisateur2 = createMagasinier();
		Utilisateur utilisateur3 = createAdmin();
		
		utilisateurs.add(utilisateur);
		utilisateurs.add(utilisateur2); 
		utilisateurs.add(utilisateur3);
		
		return utilisateurs;
	}
	
	
	
}
