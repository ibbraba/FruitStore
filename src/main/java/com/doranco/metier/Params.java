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
}
