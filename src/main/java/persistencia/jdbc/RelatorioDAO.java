package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidade.Relatorio;

public class RelatorioDAO {
	private Connection con = Conexao.getConnection();

	public List<Relatorio> gerarRelatorio() {

		String sql = "Select * from tb_relatorio t1 join tb_material t2 on t1.id_material = t2.id_material";
		List<Relatorio> lista = new ArrayList<Relatorio>();
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Relatorio relatorio = new Relatorio();
				relatorio.setIdRelatorio(resultado.getInt("id_relatorio"));
				relatorio.setIdMaterial(resultado.getInt("id_material"));
				relatorio.setDescricao(resultado.getString("cv_descricao"));
				relatorio.setPrecoMedio(resultado.getDouble("db_preco_medio"));
				relatorio.setDtSaida(resultado.getTimestamp("dt_saida"));
				relatorio.setQnt_saida(resultado.getInt("in_qnt_saida"));
				relatorio.setMes_saida(resultado.getString("dt_mes_saida"));
				relatorio.setValor_consumido(resultado.getDouble("db_valor_consumido"));
				
				// Adicionando usuario na lista
				lista.add(relatorio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
