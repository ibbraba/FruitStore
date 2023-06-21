package com.doranco.dto;

import java.util.ArrayList;
import java.util.List;

import com.doranco.daoImpl.ParamsDaoImpl;
import com.doranco.metier.Params;

public class ParamsDao {
	
	private ParamsDaoImpl uDaoImpl = new ParamsDaoImpl();
	private Params params = new Params();
	
	public Params createParams() { // ROLE : ADMIN
		uDaoImpl.create(params);
		return params;
	}
	
	public void editParams() { // ROLE : ADMIN
		uDaoImpl.update(params, params.getId());
	}
	
	public void deleteParams() { // ROLE : ADMIN
		uDaoImpl.delete(params.getId());
	}
	
	public List<Params> findAllParamss() { // ROLE : ADMIN
		List<Params> paramsList = new ArrayList<>();
		uDaoImpl.findAll();
		return paramsList;
	}
	
}
