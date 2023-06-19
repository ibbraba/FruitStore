package com.doranco.metier;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private int numero; 
	
	private LocalDateTime dateCreation; 
	
	private LocalDateTime dateLivraison;
	
	private double totalRemise; 
	
	private double fraisExpedition; 
	
	private double totalGeneral; 
	
	private Adresse adresseFacturation; 
	
	private Adresse adresseLivraison; 
	
	private CartePaiement cartePaiementDefaut; 
	
	private Utilisateur utilisateur; 
	
	private LigneDeCommande ligneCommande;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(LocalDateTime dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public double getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(double totalRemise) {
		this.totalRemise = totalRemise;
	}

	public double getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(double fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public double getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(double totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public CartePaiement getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}

	public void setCartePaiementDefaut(CartePaiement cartePaiementDefaut) {
		this.cartePaiementDefaut = cartePaiementDefaut;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public LigneDeCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneDeCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	
	
	

}
