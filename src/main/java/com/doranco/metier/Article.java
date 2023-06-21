package com.doranco.metier;

import java.nio.file.*;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name="article")
public class Article {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String nom; 
	
	private String description; 
	
	private double prix; 
	
	private int remise; 
	
	private int stock; 
	
	private boolean isVendable; 
	
	//private Path photos; 

	//private Path videos; 
	//TODO: MODIF TEMP pour test BDD
	private String photos; 
	//TODO: MODIF TEMP pour test BDD
	private String videos; 
	
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categorie;
	
	@OneToMany(mappedBy = "article") 
	private List<Commentaire> commentaires; // Non présent dans la table Article. A checker !! 
	//private String commentaires;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isVendable() {
		return isVendable;
	}

	public void setVendable(boolean isVendable) {
		this.isVendable = isVendable;
	}

//	public Path getPhotos() {
//		return photos;
//	}
//
//	public void setPhotos(Path photos) {
//		this.photos = photos;
//	}
	
	//TODO: MODIF TEMP pour test BDD
	public String getPhotos() {
		return photos;
	}
	
	public void setPhotos(String photos) {
		this.photos = photos;
	}

//	public Path getVideos() {
//		return videos;
//	}
//
//	public void setVideos(Path videos) {
//		this.videos = videos;
//	}
	
	//TODO: MODIF TEMP pour test BDD
	public String getVideos() {
		return videos;
	}
	
	public void setVideos(String videos) {
		this.videos = videos;
	}

//	public String getCommentaires() {
//		return commentaires;
//	}
//
//	public void setCommentaires(String commentaires) {
//		this.commentaires = commentaires;
//	} 
	
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
