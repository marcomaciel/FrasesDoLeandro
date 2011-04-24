package br.com.mmaciel.frasesdoleandro.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import br.com.mmaciel.frasesdoleandro.model.Frase;

import javax.jdo.Query;

/**
 * 
 * @author Marco Antonio Maciel
 * 
 */
public class FraseDAO {

	PersistenceManager pm = null;
	private static final Logger log = Logger
			.getLogger(FraseDAO.class.getName());

	public boolean inserirFrase(Frase frase) {
		pm = PMF.get().getPersistenceManager();
		boolean retorno = false;
		String texto = frase.getTexto();
		Frase f = new Frase(texto, new Date(), "Leando Coelho");
		try {
			pm.makePersistent(f);
			retorno = true;
		} catch (Exception e) {
			log.severe("Erro ao incluir frase.");
			e.printStackTrace();
			retorno = false;
		} finally {
			pm.close();
		}

		return retorno;
	}

	public boolean alterarFrase(Frase frase) {
		pm = PMF.get().getPersistenceManager();
		boolean retorno = false;
		try {
			String novoTexto = frase.getTexto();
			if (novoTexto != null) {
				Frase f = pm.getObjectById(Frase.class, frase.getId());
				f.setTexto(novoTexto);
				pm.makePersistent(f);
				retorno = true;
			} else {
				retorno = false;
				throw new Exception();
			}
		} catch (Exception e) {
			log.severe("Erro ao alterar.");
			e.printStackTrace();
			retorno = false;
		} finally {
			pm.close();
		}
		return retorno;
	}

	public boolean apagrarFrase(Frase frase) {
		pm = PMF.get().getPersistenceManager();
		boolean retorno = false;
		try {
			Frase f = pm.getObjectById(Frase.class, frase.getId());
			pm.deletePersistent(f);
			retorno = true;
		} catch (Exception e) {
			log.severe("Erro ao apagar frase.");
			e.printStackTrace();
			retorno = false;
		} finally {
			pm.close();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Frase> listarFrases() {
		pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Frase.class);
		List<Frase> frasesTemp = null;
		List<Frase> frases = new ArrayList<Frase>();
		try {
			frasesTemp = (List<Frase>) query.execute();
			frases.addAll(frasesTemp);
		} catch (Exception e) {
			log.severe("Erro ao listar Frases.");
			e.printStackTrace();
		} finally {
			query.closeAll();
		}

		return frases;

	}

}
