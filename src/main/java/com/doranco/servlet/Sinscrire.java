package com.doranco.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doranco.metier.Utilisateur;

public class Sinscrire extends HttpServlet {
	
	public Sinscrire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//CHECK IF USER IS NULL 
		HttpSession session = req.getSession();
		
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		if(utilisateur == null ) {
			
			getServletContext().getRequestDispatcher("/WEB-INF/add-utilisateur.xhtml");
			
		}else {
			getServletContext().getRequestDispatcher("/WEB-INF/acceuil.xhtml");
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
