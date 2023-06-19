package com.doranco.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ArticlePanier")
public class ArticlePanier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private Article article; 
	
	private int quantite; 
	
	private Utilisateur utilisateur; 
	

}
