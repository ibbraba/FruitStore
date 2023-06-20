package com.doranco.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Params")
public class Params {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public String cle_cryptage_pwd;
	
	public String cle_cryptage_cp;
}
