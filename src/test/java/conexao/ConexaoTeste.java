/*package conexao;
import java.sql.Connection;
import java.sql.SQLException;

import persistencia.jdbc.Conexao;

public class ConexaoTeste {

	public static void main(String[] args) {
		System.out.println("Abrindo conexao...");
		Connection connectionManager = Conexao.getInstance().getConnection();
		System.out.println("Conexao sucedida!");
		System.out.println("Conexao sendo encerrada..");
		try {
			connectionManager.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conexao encerrada!");
	}
}
*/