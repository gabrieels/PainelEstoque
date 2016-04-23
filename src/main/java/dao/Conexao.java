package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	private Connection connection;
	private String url;
	private String user;
	private String password;

	// designer patterns Singleton
	private static Conexao anInstance = null;

	public Conexao() {
		this.url = "jdbc:postgresql://localhost:5432/dbPainelEstoque";
		this.user = "postgres";
		this.password = "projetoufs";
	}

	public static Conexao getInstance() {
		if (anInstance == null) {
			anInstance = new Conexao();
		}
		return anInstance;
	}

	public Connection getConnection() {
		try {
			// obter o drive de conexao do postgreSQL
			// Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException ex) {
			System.out.println("Erro na conexao: " + ex.getMessage());
		}
		return this.connection;
	}
}
