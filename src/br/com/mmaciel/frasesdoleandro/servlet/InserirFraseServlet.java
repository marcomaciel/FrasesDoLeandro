package br.com.mmaciel.frasesdoleandro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Marco Antonio Maciel
 */
public class InserirFraseServlet extends HttpServlet {

	private static final long serialVersionUID = -6256054408606827152L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("inserir.jsp");			
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	@Override
	public String getServletInfo() {
		return "frases";
	}
}
