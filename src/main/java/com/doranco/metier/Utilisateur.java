package com.doranco.metier;

import java.sql.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.doranco.utils.Role;

@Entity
@Table(name="utilisateur")
public class Utilisateur {

	//TODO: Check GESTION ROLE
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String nom; 
	
	private String prenom; 
	
	private Date DateNaissance; 
	
	private boolean isActif; 
	
	private String profil; 
	
	private String email;
	
	private String password; 
	
	private String telephone;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Adresse> adresse;
	//private Adresse adresse; 
	
	@OneToMany(mappedBy = "utilisateur")
	private List< Commande> commande; 
	//private Commande commande; 
	
	@OneToMany(mappedBy = "utilisateur")
	private List<CartePaiement> cartesDePaiement; 
	//private CartePaiement cartesDePaiement; 
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Commentaire> commentaires; 
	//private String commentaires; 
	
	@OneToMany(mappedBy = "utilisateur")
	private List<ArticlePanier> panier;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String nom, String prenom, Date dateNaissance, boolean isActif, String profil,
			String email, String password, String telephone, Role role, List<Adresse> adresse, List<Commande> commande,
			List<CartePaiement> cartesDePaiement, List<Commentaire> commentaires, List<ArticlePanier> panier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.DateNaissance = dateNaissance;
		this.isActif = isActif;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.role = role;
		this.adresse = adresse;
		this.commande = commande;
		this.cartesDePaiement = cartesDePaiement;
		this.commentaires = commentaires;
		this.panier = panier;
	}
	
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

	public Date getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
//	public Adresse getAdresse() {
//		return adresse;
//	}
//
//	public void setAdresse(Adresse adresse) {
//		this.adresse = adresse;
//	}
	
	public List<Adresse> getAdresse() {
		return adresse;
	}

	public void setAdresse(List<Adresse> adresse) {
		this.adresse = adresse;
	}

//	public Commande getCommande() {
//		return commande;
//	}
//
//	public void setCommande(Commande commande) {
//		this.commande = commande;
//	}
	
	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

//	public CartePaiement getCartesDePaiement() {
//		return cartesDePaiement;
//	}
//
//	public void setCartesDePaiement(CartePaiement cartesDePaiement) {
//		this.cartesDePaiement = cartesDePaiement;
//	}
	
	public List<CartePaiement> getCartesDePaiement() {
		return cartesDePaiement;
	}
	
	public void setCartesDePaiement(List<CartePaiement> cartesDePaiement) {
		this.cartesDePaiement = cartesDePaiement;
	}

//	public String getCommentaires() {
//		return commentaires;
//	}
//
//	public void setCommentaires(String commentaires) {
//		this.commentaires = commentaires;
//	}
	
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public List<ArticlePanier> getPanier() {
		return panier;
	}

	public void setPanier(List<ArticlePanier> panier) {
		this.panier = panier;
	}

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
	
}
