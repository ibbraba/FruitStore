package com.doranco.metier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Params")
public class Params {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public String cle_cryptage_pwd;
	public String cle_cryptage_cp;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCle_cryptage_pwd() {
		return cle_cryptage_pwd;
	}

	public void setCle_cryptage_pwd(String cle_cryptage_pwd) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
	}

	public String getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}

	public void setCle_cryptage_cp(String cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}

}
