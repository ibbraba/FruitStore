package com.doranco.metier;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String nom; 
	
	private String prenom; 
	
	private LocalDateTime DateNaissance; 
	
	private boolean isActif; 
	
	private String profil; 
	
	private String email;
	
	private String password; 
	
	private String telephone;
	
	private Adresse adresse; 
	
	private Commande commande; 
	
	private CartePaiement cartesDePaiement; 
	
	private String commentaires; 
	
	private List<ArticlePanier> panier;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDateTime getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(LocalDateTime dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephine() {
		return telephone;
	}

	public void setTelephine(String telephine) {
		this.telephone = telephine;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public CartePaiement getCartesDePaiement() {
		return cartesDePaiement;
	}

	public void setCartesDePaiement(CartePaiement cartesDePaiement) {
		this.cartesDePaiement = cartesDePaiement;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public List<ArticlePanier> getPanier() {
		return panier;
	}

	public void setPanier(List<ArticlePanier> panier) {
		this.panier = panier;
	}
	
	
	
	
	
	
	
	
}
