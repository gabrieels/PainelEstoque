package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidade.Material;



public class MaterialDAO {
	private Connection con = Conexao.getConnection();

	public List<Material> buscarTodos() {

		String sql = "Select * from tb_material";
		List<Material> lista = new ArrayList<Material>();
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Material material = new Material();
				material.setIdMaterial(resultado.getInt("id_material"));
				material.setDescricao(resultado.getString("cv_descricao"));
				material.setFamilia(resultado.getString("cv_familia"));
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
