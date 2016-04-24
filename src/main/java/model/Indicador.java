package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_indicador database table.
 * 
 */
@Entity
@Table(name="tb_indicador")
@NamedQuery(name="Indicador.findAll", query="SELECT i FROM Indicador i")
public class Indicador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_indicador")
	private Integer idIndicador;

	@Column(name="db_consumo_medio")
	private double dbConsumoMedio;

	@Column(name="tb_indicador")
	private String tbIndicador;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="id_material")
	private Material tbMaterial;

	public Indicador() {
	}

	public Integer getIdIndicador() {
		return this.idIndicador;
	}

	public void setIdIndicador(Integer idIndicador) {
		this.idIndicador = idIndicador;
	}

	public double getDbConsumoMedio() {
		return this.dbConsumoMedio;
	}

	public void setDbConsumoMedio(double dbConsumoMedio) {
		this.dbConsumoMedio = dbConsumoMedio;
	}

	public String getTbIndicador() {
		return this.tbIndicador;
	}

	public void setTbIndicador(String tbIndicador) {
		this.tbIndicador = tbIndicador;
	}

	public Material getTbMaterial() {
		return this.tbMaterial;
	}

	public void setTbMaterial(Material tbMaterial) {
		this.tbMaterial = tbMaterial;
	}

}