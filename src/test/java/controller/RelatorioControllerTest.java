package controller;

import controller.RelatorioController;
import persistencia.jdbc.RelatorioDAO;

public class RelatorioControllerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RelatorioController relatorioController = new RelatorioController();
		
		System.out.println(relatorioController.obterAno());

	}

}
