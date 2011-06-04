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
		String acao = request.getParameter("acao");
		if (acao == null) {
			acao = "nova";
		}

		if (acao.equals("inserir")) {
			String mensagem = null;
			String texto = request.getParameter("texto");
			if (!texto.equals("")) {
				Frase frase = new Frase();
				frase.setTexto(request.getParameter("texto"));
				log.fine(frase.toString());
				log.info(frase.toString());

				log.info("Inserindo frase.");
				boolean retorno;
				retorno = fd.inserirFrase(frase);
				if (retorno) {
					mensagem = "OK - Frase inserida com sucesso!";
					log.fine(mensagem);
					response.sendRedirect("ok.jsp?mensagem=" + mensagem);
				}
			} else {
				mensagem = "Erro - Frase não inserida!";
				log.info(mensagem);
				response.sendRedirect("erro.jsp?mensagem=" + mensagem);
			}
		}
		if (acao.equals("alterar")) {
			Frase frase = new Frase();
			frase.setTexto(request.getParameter("texto"));
			frase.setId(Long.parseLong(request.getParameter("id")));
			log.fine(frase.toString());
			System.out.println(frase);
			String mensagem = null;
			log.info("Alterando frase.");
			boolean retorno;
			retorno = fd.alterarFrase(frase);
			if (retorno) {
				mensagem = "OK - Frase alterada com sucesso!";
				log.fine(mensagem);
				response.sendRedirect("ok.jsp?mensagem=" + mensagem);
			} else {
				mensagem = "Erro - Frase não alterada!";
				log.info(mensagem);
				response.sendRedirect("erro.jsp?mensagem=" + mensagem);
			}

		} else if (acao.equals("excluir")) {
			Frase frase = new Frase();
			frase.setId(Long.parseLong(request.getParameter("id")));
			log.fine(frase.toString());
			String mensagem = null;
			log.info("Excluindo frase.");
			boolean retorno;
			retorno = fd.apagrarFrase(frase);
			if (retorno) {
				mensagem = "OK - Frase excluída com sucesso!";
				log.fine(mensagem);
				response.sendRedirect("ok.jsp?mensagem=" + mensagem);
			} else {
				mensagem = "Erro - Frase não excluída!";
				log.info(mensagem);
				response.sendRedirect("erro.jsp?mensagem=" + mensagem);
			}

		} else if (acao.equals("nova")) {
			log.info("Obtendo frase do controlador.");
			String frase = FraseController.getInstance()
					.selecionaFraseAleatoria();
			log.info("Gravando frase na sessao.");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("frase", frase);
			response.sendRedirect("frase.jsp");

		} else if (acao.equals("listar")) {
			List<Frase> frases = new ArrayList<Frase>();
			log.info("Obtendo lista de frases.");
			frases = fd.listarFrases();
			HttpSession sessao = request.getSession();
			sessao.setAttribute("frases", frases);
			response.sendRedirect("listar.jsp");

		} else if (acao.equals("admin")) {
			List<Frase> frases = new ArrayList<Frase>();
			log.info("Administração de frases.");
			frases = fd.listarFrases();
			HttpSession sessao = request.getSession();
			sessao.setAttribute("frases", frases);
			response.sendRedirect("ADM.jsp");
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
