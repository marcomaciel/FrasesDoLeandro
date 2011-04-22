package br.com.mmaciel.frasesdoleandro.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.mmaciel.frasesdoleandro.controller.FraseController;
import br.com.mmaciel.frasesdoleandro.dao.FraseDAO;
import br.com.mmaciel.frasesdoleandro.model.Frase;

/**
 * 
 * @author Marco Antonio Maciel
 */
public class FraseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(FraseServlet.class
			.getName());

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		       
		FraseDAO fd = new FraseDAO();
		String acao = request.getParameter("f");
		if (acao == null){
			acao = "nova";
		}
		
		if (acao.equals("inserir")) {
			Frase frase = new Frase();	
			frase.setTexto(request.getParameter("texto"));
			log.fine(frase.toString());
			System.out.println(frase);
			
			log.info("Inserindo frase.");
			boolean retorno;
			retorno = fd.insereFrase(frase);		
			if (retorno){
				log.fine("OK - Frase inserida com sucesso.");
				response.sendRedirect("ok.jsp");
			} else {
				log.info("Erro - Frase não inserida.");
				response.sendRedirect("erro.jsp");
			}
		} else if(acao.equals("nova"))  {

			System.out.println("Obtendo frase do controlador.");
			String frase = FraseController.getInstance().selecionaFraseAleatoria();
			log.info("Gravando frase na sessao.");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("frase", frase);

			response.sendRedirect("frase.jsp");
		} else if(acao.equals("listar"))  {

			List<Frase> frases = new ArrayList<Frase>();
			System.out.println("Obtendo lista de frases.");			
			frases = fd.listaFrases();

			HttpSession sessao = request.getSession();
			sessao.setAttribute("frases", frases);

			response.sendRedirect("listar.jsp");
		}
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "frases";
	}
}
