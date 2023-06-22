package com.doranco.fixtures;

import java.time.LocalDateTime;

import com.doranco.metier.CartePaiement;

public class CartePaiementFixtures {

	public static CartePaiement createClientCartePaiement() {
		
		CartePaiement cartePaiement = new CartePaiement(); 
		cartePaiement.setId(1);
		cartePaiement.setNomProprietaire(UtilisateurFixtures.createClient().getNom());
		cartePaiement.setPrenomProprietaire(UtilisateurFixtures.createClient().getNom());
		cartePaiement.setNumero("4848-5555-8888-2222");
	    cartePaiement.setCryptogramme("545");
	    cartePaiement.setDateFinValidite(LocalDateTime.now().plusYears(2));
		
		
		return cartePaiement;
		
	}
	
}
