package com.doranco.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Logout request");	
		HttpSession session = req.getSession(); 
		session.removeAttribute("utilisateur");
		
		//TODO: Vider Panier
		getServletContext().getRequestDispatcher("/WEB-INF/login-utilisateur.xhtml").forward(req, resp);
	
	}
	
	
	
}
