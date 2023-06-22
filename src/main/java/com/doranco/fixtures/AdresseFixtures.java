package com.doranco.fixtures;

import com.doranco.metier.Adresse;

public class AdresseFixtures {
	
	public static Adresse getClientAdresse() {
		
		Adresse adresse = new Adresse();
		adresse.setId(1);
		adresse.setNumero(4);
		adresse.setRue("Rue de Doranco"); 
		adresse.setVille("Bordeaux");
		adresse.setUtilisateur(UtilisateurFixtures.createClient());
		adresse.setCodePostal(33000);
		
		return adresse; 
		
		
	}
	

}
