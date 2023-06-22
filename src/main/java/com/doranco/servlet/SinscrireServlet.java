package com.doranco.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doranco.metier.Utilisateur;

public class SinscrireServlet extends HttpServlet {
	
	public SinscrireServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//CHECK IF USER IS NULL 
		System.out.println("REGISTER SERVLET");	
			getServletContext().getRequestDispatcher("/WEB-INF/add-utilisateur.xhtml");
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//REGISTER FORM
	}
	
}
