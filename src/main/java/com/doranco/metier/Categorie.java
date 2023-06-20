package com.doranco.metier;

import java.nio.file.Path;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom; 
	
	private int remise; 
	
	private boolean isRemiseCumulable; 
	
	//private Path photo;
	//TODO: MODIF TEMP pour test BDD
	private String photo;
	
	@OneToMany(mappedBy = "categorie")
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

//	public Path getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(Path photo) {
//		this.photo = photo;
//	}
	
	//TODO: MODIF TEMP pour test BDD
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
