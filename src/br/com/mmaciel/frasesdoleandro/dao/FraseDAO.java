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

	public boolean insereFrase(Frase frase) {
		pm = PMF.get().getPersistenceManager();
		boolean retorno = false;
		String texto = frase.getTexto();
		if (texto != null) {
			Frase f = new Frase(texto, new Date(), "Leando Coelho");
			try {
				pm.makePersistent(f);
				retorno = true;
			} catch (Exception e) {
				log.severe("Exception.");
				e.printStackTrace();
				retorno = false;
			} finally {
				pm.close();
			}
		}else{
			retorno = false;
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Frase> listaFrases() {
		pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Frase.class);
		List<Frase> frasesTemp = null;
		List<Frase> frases = new ArrayList<Frase>();
		try {
			frasesTemp = (List<Frase>) query.execute();
			frases.addAll(frasesTemp);			
			
		} finally {
			query.closeAll();
		}

		return frases;

	}

}
