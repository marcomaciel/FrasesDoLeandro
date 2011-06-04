/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mmaciel.frasesdoleandro;

import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.mmaciel.frasesdoleandro.controller.FraseController;
import br.com.mmaciel.frasesdoleandro.model.Frase;
import br.com.mmaciel.frasesdoleandro.util.ArquivoUtil;

/**
 *
 * @author Marco Antonio Maciel
 * 
 */
public class FrasesTest {	
	
    @Test
    public void leArquivoComSucesso() {
    	ArquivoUtil arquivoUtil = new ArquivoUtil();
        File f = arquivoUtil.obtemArquivo("frases.txt");
        Assert.assertTrue(f.exists());
    }
    
    @Test(expected = NullPointerException.class)
    public void caminhoDoArquivoComErro() {
        ArquivoUtil arquivoUtil = new ArquivoUtil();
        arquivoUtil.obtemArquivo("ArquivoQueNaoExiste.txt");
    }
    
    @Test
    public void retornaListaDeFrases(){
    	List<Frase> listaFrases = FraseController.getInstance().retornaListaDeFrasesDoArquivo("frases.txt");
    	Assert.assertNotNull(listaFrases);
    }    
    
    @Test
    public void buscaFraseAleatoriaComSucesso() throws IOException {
        String frase = FraseController.getInstance().selecionaFraseAleatoria();
        Assert.assertNotNull(frase);
    }     
      
    
}
