package com.doranco.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="params")
public class Params {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cle_cryptage_pwd;
	private String cle_cryptage_cp;
	
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
