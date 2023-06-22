package com.doranco.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.doranco.metier.Utilisateur;

public class HomeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Home Filter START");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Utilisateur utilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");

		if (utilisateur != null) {
			System.out.println("Utilisateur connecté, redirection vers une des pages de gestion ");
			session.setAttribute("utilisateur", utilisateur);
		
			
			// TODO change to profil enum
			if (utilisateur.getProfil().equals("Magasinier")) {
				req.getRequestDispatcher("/WEB-INF/gestion-articles.jsp").forward(request, response);
			} else if (utilisateur.getProfil().equals("Admin")) {
				req.getRequestDispatcher("/WEB-INF/gestion-admin.xhtml").forward(request, response);

			} else {
				req.getRequestDispatcher("/WEB-INF/gestion-achats.xhtml").forward(request, response);
			}

		}else {
			System.out.println("Pas d'utilisateur connecté, retour à l'acceuil");
			req.getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);
		}

		System.out.println("Home Filter END");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
