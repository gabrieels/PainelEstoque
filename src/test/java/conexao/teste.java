package conexao;

import java.util.List;
import persistencia.jdbc.RelatorioDAO;
import persistencia.jdbc.MaterialDAO;
import persistencia.entidade.Material;
import persistencia.entidade.Relatorio;

public class teste {

	public static void main(String[] args) {
		//testGerarRelatorio();
		testBuscarTodos();

	}	
		private static void testBuscarTodos() {
			MaterialDAO materialDAO = new MaterialDAO();
			List<Material> lista = materialDAO.buscarTodos();
			for (Material m: lista){
				System.out.println(m);
			}
		}
		
		private static void testGerarRelatorio() {
			RelatorioDAO relatorioDAO = new RelatorioDAO();
			List<Relatorio> lista = relatorioDAO.gerarRelatorio();
			for (Relatorio m: lista){
				System.out.println(m);
			}
		}
	}


