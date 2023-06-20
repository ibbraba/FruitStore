package com.doranco.metier;

import java.nio.file.Path;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@javax.persistence.Table(name="Article")
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
	
	private Path photos; 
	
	private Path videos; 
	
	private String commentaires;

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

	public Path getPhotos() {
		return photos;
	}

	public void setPhotos(Path photos) {
		this.photos = photos;
	}

	public Path getVideos() {
		return videos;
	}

	public void setVideos(Path videos) {
		this.videos = videos;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	} 
	
	
	
	
}
