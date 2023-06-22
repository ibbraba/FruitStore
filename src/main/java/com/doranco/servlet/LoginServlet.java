package com.doranco.servlet;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doranco.dao.DaoFactory;

import com.doranco.daoImpl.UtilisateurDaoImpl;
import com.doranco.metier.Utilisateur;
import com.doranco.services.UtilisateurService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Login Servlet");
		HttpSession session = req.getSession();
		if (session.getAttribute("utilisateur") != null) {
			getServletContext().getRequestDispatcher("/WEB-INF/acceuil.xhtml").forward(req, resp);

		} else {

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
		try {
			Utilisateur utilisateur = FindUtilisateur(login, password);

			HttpSession session = req.getSession();
			// FIND UTILISATEUR
			if (utilisateur != null) {
				session.setAttribute("nom", utilisateur.getNom());
				session.setAttribute("prenom", utilisateur.getPrenom());
				if (utilisateur.getProfil().equals("Magasinier")) {

					session.setAttribute("utilisateur", utilisateur);
					req.getRequestDispatcher("/WEB-INF/gestion-articles.jsp").forward(req, resp);

				} else if (utilisateur.getProfil().equals("Admin")) {

					session.setAttribute("utilisateur", utilisateur);
					req.getRequestDispatcher("/WEB-INF/gestion-admin.jsp").forward(req, resp);
				} else {

					System.out.println("Client connecté, redirection vers gestion achats ");
					session.setAttribute("utilisateur", utilisateur);
					req.getRequestDispatcher("/WEB-INF/gestion-achats.jsp").forward(req, resp);
				}
			} else {
				System.out.println("Utilisateur non trouvé");
				req.setAttribute("errorMessage", "idetifiants invalides");
				getServletContext().getRequestDispatcher("/WEB-INF/login-utilisateur.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Utilisateur FindUtilisateur(String email, String password) {

		try {
			UtilisateurService utilisateurService = new UtilisateurService();
			Utilisateur utilisateur = utilisateurService.findUtilisateur(email, password);
			System.out.println(utilisateur.getNom());
			return utilisateur;
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	;
	return null;

	}
}
