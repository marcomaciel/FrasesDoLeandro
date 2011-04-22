package br.com.mmaciel.frasesdoleandro;

import java.io.IOException;

import br.com.mmaciel.frasesdoleandro.controller.FraseController;

public class TesteConsole {

	public static void main(String x[]) throws IOException{
	
		System.out.println(FraseController.getInstance().selecionaFraseAleatoria());
		System.out.println(FraseController.getInstance().selecionaFraseAleatoria());
		System.out.println(FraseController.getInstance().selecionaFraseAleatoria());
		System.out.println(FraseController.getInstance().selecionaFraseAleatoria());
		
	}
	
}
