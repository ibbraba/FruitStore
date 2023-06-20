package com.doranco.metier;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private int numero; 
	
	private LocalDateTime dateCreation; 
	
	//@OneToOne : "Association 'com.doranco.metier.Commande.dateLivraison' targets an unknown entity named 'java.time.LocalDateTime"
	private LocalDateTime dateLivraison;
	
	private double totalRemise; 
	
	private double fraisExpedition; 
	
	private double totalGeneral; 
	
	@OneToOne
	private Adresse adresseFacturation; //Check logique adresse Facturation et Livraison .....
	
	@OneToOne
	private Adresse adresseLivraison; 
	
	@OneToOne  // NO relation stipulé dans le PDF ??
	private CartePaiement cartePaiementDefaut; 
	
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur; 
	
	@OneToMany(mappedBy = "commande")
	private List<LigneDeCommande> ligneCommande;
	//private LigneDeCommande ligneCommande;

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

//	public LigneDeCommande getLigneCommande() {
//		return ligneCommande;
//	}
//
//	public void setLigneCommande(LigneDeCommande ligneCommande) {
//		this.ligneCommande = ligneCommande;
//	}
	
	public void setLigneCommande(List<LigneDeCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	public List<LigneDeCommande> getLigneCommande() {
		return ligneCommande;
	}
	
}
