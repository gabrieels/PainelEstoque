package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidade.Material;

public class RelatorioDAO {
	private Connection con = Conexao.getConnection();

	public List<Material> geraRelatorio() {

		String sql = "Select id_material, dt_saida, in_qnt_saida, db_preco_medio, cv_descricao from tb_relatorio t1 join tb_material t2 on t1.id_material = t2.id_material";
		List<Material> lista = new ArrayList<Material>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Material material = new Material();
				material.setIdMaterial(resultado.getInt("id_material"));
				material.setDescricao(resultado.getString("cv_descricao"));
				material.setPrecoMedio(resultado.getDouble("db_preco_medio"));
				material.setVencimento(resultado.getTimestamp("dt_vencimento"));
				material.setQntEstoque(resultado.getInt("nu_qnt_estoque"));
				material.setQntMinima(resultado.getInt("nu_qnt_minima"));
				material.setTipoMaterial(resultado.getString("tp_material"));
				material.setUnidade(resultado.getString("und_material"));

				// Adicionando usuario na lista
				lista.add(material);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
