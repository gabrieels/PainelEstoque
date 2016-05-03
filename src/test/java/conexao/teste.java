package conexao;

import java.util.List;

import persistencia.jdbc.MaterialDAO;
import persistencia.entidade.Material;

public class teste {

	public static void main(String[] args) {
		testBuscarTodos();

	}	
		private static void testBuscarTodos() {
			MaterialDAO materialDAO = new MaterialDAO();
			List<Material> lista = materialDAO.buscarTodos();
			for (Material m: lista){
				System.out.println(m);
			}
		}
	}


