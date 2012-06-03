package frasesdoleandro.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.mmaciel.frasesdoleandro.model.Frase;

import frasesdoleandro.controller.FraseController;
import frasesdoleandro.dao.FraseDAO;

/**
 * 
 * @author Marco Antonio Maciel
 */
public class FraseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(FraseServlet.class
			.getName());

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FraseDAO fd = new FraseDAO();

		String acao = request.getParameter("acao");
		String id = request.getParameter("id");

		if (id != null) {
			Frase frase = FraseController.getInstance().obterFrasePorId(
					Integer.parseInt(id));
			HttpSession sessao = request.getSession();
			sessao.setAttribute("id", frase.getId());
			sessao.setAttribute("frase", frase.getTexto());
			response.sendRedirect("frase.jsp");
		} else if (acao == null){
			Frase frase = FraseController.getInstance().selecionaFraseAleatoria();
			HttpSession sessao = request.getSession();
			sessao.setAttribute("id", frase.getId());
			sessao.setAttribute("frase", frase.getTexto());
			response.sendRedirect("frase.jsp");
			
		} else if (acao.equals("inserir")) {
			String mensagem = null;
			String texto = request.getParameter("texto");
			if (!texto.equals("")) {
				Frase frase = new Frase();
				frase.setTexto(request.getParameter("texto"));
				boolean retorno;
				retorno = fd.inserirFrase(frase);
				if (retorno) {
					mensagem = "OK - Frase inserida com sucesso!";
					response.sendRedirect("ok.jsp?mensagem=" + mensagem);
				}
			} else {
				mensagem = "Erro - Frase n‹o inserida!";
				response.sendRedirect("erro.jsp?mensagem=" + mensagem);
			}
		} else if (acao.equals("alterar")) {
			Frase frase = new Frase();
			frase.setTexto(request.getParameter("texto"));
			frase.setId(Long.parseLong(request.getParameter("id")));
			System.out.println(frase);
			String mensagem = null;
			boolean retorno;
			retorno = fd.alterarFrase(frase);
			if (retorno) {
				mensagem = "OK - Frase alterada com sucesso!";
				response.sendRedirect("ok.jsp?mensagem=" + mensagem);
			} else {
				mensagem = "Erro - Frase n‹o alterada!";
				response.sendRedirect("erro.jsp?mensagem=" + mensagem);
			}

		} else if (acao.equals("excluir")) {
			Frase frase = new Frase();
			frase.setId(Long.parseLong(request.getParameter("id")));
			String mensagem = null;
			boolean retorno;
			retorno = fd.apagrarFrase(frase);
			if (retorno) {
				mensagem = "OK - Frase exclu’da com sucesso!";
				log.fine(mensagem);
				response.sendRedirect("ok.jsp?mensagem=" + mensagem);
			} else {
				mensagem = "Erro - Frase n‹o exclu’da!";
				log.info(mensagem);
				response.sendRedirect("erro.jsp?mensagem=" + mensagem);
			}

		} else if (acao.equals("listar")) {
			List<Frase> frases = new ArrayList<Frase>();
			frases = fd.listarFrases();
			HttpSession sessao = request.getSession();
			sessao.setAttribute("frases", frases);
			response.sendRedirect("listar.jsp");

		} else if (acao.equals("admin")) {
			List<Frase> frases = new ArrayList<Frase>();
			frases = fd.listarFrases();
			HttpSession sessao = request.getSession();
			sessao.setAttribute("frases", frases);
			response.sendRedirect("admin.jsp");

		} 
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "frases";
	}
}
