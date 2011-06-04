package br.com.mmaciel.frasesdoleandro.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import br.com.mmaciel.frasesdoleandro.dao.FraseDAO;
import br.com.mmaciel.frasesdoleandro.model.Frase;
import br.com.mmaciel.frasesdoleandro.util.ArquivoUtil;

/**
*
* @author Marco Antonio Maciel
* 
*/
public class FraseController {
	
	private final String ARQUIVO_DE_FRASES = "frases.txt";
	private static FraseController fraseController = null;

	private String texto = null;
	private List<Frase> frases = new ArrayList<Frase>();
	private static final Logger log = Logger.getLogger(FraseController.class.getName());

	public FraseController() {
		frases = this.retornaListaDeFrasesDoBancoDeDados();
		
	}

	public String selecionaFraseAleatoria() throws IOException {
				
		Random random = new Random();
		int numDaEscolha = random.nextInt(this.frases.size());
		log.info("Frase escolhida: " + frases.get(numDaEscolha).toString() + " " + numDaEscolha);

		return frases.get(numDaEscolha).getTexto();
	}

	public List<Frase> retornaListaDeFrasesDoArquivo(String arquivo) {
				
		ArquivoUtil arquivoUtil = new ArquivoUtil();
		
		log.info("Abrindo arquivo de frases.");
		BufferedReader leitor = null;
		File arquivoDeFrases = arquivoUtil.obtemArquivo(arquivo);
		try {
			leitor = new BufferedReader(new FileReader(arquivoDeFrases));
			while (leitor.ready()) {
				texto = leitor.readLine();
				frases.add(new Frase(texto));
			}
		} catch (FileNotFoundException e) {
			log.severe("FileNotFoundException.");
			e.printStackTrace();
		} catch (IOException e) {
			log.severe("IOException.");
			e.printStackTrace();
		}

		log.info(frases.size() + " frases encontradas.");

		return frases;
	}
	
	public List<Frase> retornaListaDeFrasesDoBancoDeDados() {
		
		FraseDAO fraseDao = new FraseDAO();
		
		log.info("Obtendo frases no Banco de Dados.");
		frases = fraseDao.listarFrases();
		log.info(frases.size() + " frases encontradas.");
		return frases;
	}
	
	public static FraseController getInstance(){
		
		if (fraseController==null){
			fraseController = new FraseController();
		}
		return fraseController;
	}
}
