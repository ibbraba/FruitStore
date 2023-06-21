package com.doranco.servlet;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doranco.metier.Utilisateur;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login Servlet");		
		HttpSession session=req.getSession(); 
		if(session.getAttribute("utilisateur")!= null ) {
			getServletContext().getRequestDispatcher("/WEB-INF/acceuil.xhtml").forward(req, resp);
			
		}else {
			
			getServletContext().getRequestDispatcher("/WEB-INF/login-utilisateur.xhtml").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		System.out.println("Login form sent");
		String login = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("login : " + login + " passowrd : " + password);
		
		Utilisateur utilisateur = new Utilisateur(); 
		utilisateur.setNom(login);
		utilisateur.setPassword(password);
		
		HttpSession session=req.getSession();
		//FIND UTILISATEUR
		if(login.equals("client")){
			
			utilisateur.setProfil("client");
			
			System.out.println("Client connecté, redirection vers l'acceuil ");
			session.setAttribute("utilisateur", utilisateur);
			req.getRequestDispatcher("/WEB-INF/gestion-achats.xhtml").forward(req, resp);
		}else if(login.equals("Magasinier")){
			
			utilisateur.setProfil("Magasinier");
			session.setAttribute("utilisateur", utilisateur);
			req.getRequestDispatcher("/WEB-INF/gestion-articles.xhtml").forward(req, resp);
			
		}else if (login.equals("Admin")){
			utilisateur.setProfil("Admin");
			
			session.setAttribute("utilisateur", utilisateur);
			req.getRequestDispatcher("/WEB-INF/gestion-admin.xhtml").forward(req, resp);
		}else {
			System.out.println("Utilisateur non trouvé");
			req.setAttribute("errorMessage", "idetifiants invalides");
			getServletContext().getRequestDispatcher("/WEB-INF/login-utilisateur.xhtml").forward(req, resp);
		}
		
		
		
	}
}
