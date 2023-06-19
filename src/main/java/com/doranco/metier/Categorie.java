package com.doranco.metier;

import java.nio.file.Path;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom; 
	
	private int remise; 
	
	private boolean isRemiseCumulable; 
	
	private Path photo;
	
	private List<Article> articles;

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

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public boolean isRemiseCumulable() {
		return isRemiseCumulable;
	}

	public void setRemiseCumulable(boolean isRemiseCumulable) {
		this.isRemiseCumulable = isRemiseCumulable;
	}

	public Path getPhoto() {
		return photo;
	}

	public void setPhoto(Path photo) {
		this.photo = photo;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
	

}
