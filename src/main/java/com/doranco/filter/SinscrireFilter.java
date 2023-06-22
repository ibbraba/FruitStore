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

public class SinscrireFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Register Filter BEGIN");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur"); 
		if(utilisateur != null) {
			System.out.println("Utilisateur déja connecté, retour à l'acceuil");
			req.getRequestDispatcher("/WEB-INF/acceuil.jsp").forward(request, response);

		}else {
			req.getRequestDispatcher("/WEB-INF/add-utilisateur.jsp").forward(request, response);
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
