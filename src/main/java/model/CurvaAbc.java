package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_curva_abc database table.
 * 
 */
@Entity
@Table(name="tb_curva_abc")
@NamedQuery(name="CurvaAbc.findAll", query="SELECT c FROM CurvaAbc c")
public class CurvaAbc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_curva")
	private Integer idCurva;

	@Column(name="cv_classificacao")
	private String cvClassificacao;

	@Column(name="db_acumulado")
	private double dbAcumulado;

	@Column(name="db_custo_anual")
	private double dbCustoAnual;

	@Column(name="per_acumulado")
	private double perAcumulado;

	@Column(name="per_anual")
	private double perAnual;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="id_material")
	private Material tbMaterial;

	public CurvaAbc() {
	}

	public Integer getIdCurva() {
		return this.idCurva;
	}

	public void setIdCurva(Integer idCurva) {
		this.idCurva = idCurva;
	}

	public String getCvClassificacao() {
		return this.cvClassificacao;
	}

	public void setCvClassificacao(String cvClassificacao) {
		this.cvClassificacao = cvClassificacao;
	}

	public double getDbAcumulado() {
		return this.dbAcumulado;
	}

	public void setDbAcumulado(double dbAcumulado) {
		this.dbAcumulado = dbAcumulado;
	}

	public double getDbCustoAnual() {
		return this.dbCustoAnual;
	}

	public void setDbCustoAnual(double dbCustoAnual) {
		this.dbCustoAnual = dbCustoAnual;
	}

	public double getPerAcumulado() {
		return this.perAcumulado;
	}

	public void setPerAcumulado(double perAcumulado) {
		this.perAcumulado = perAcumulado;
	}

	public double getPerAnual() {
		return this.perAnual;
	}

	public void setPerAnual(double perAnual) {
		this.perAnual = perAnual;
	}

	public Material getTbMaterial() {
		return this.tbMaterial;
	}

	public void setTbMaterial(Material tbMaterial) {
		this.tbMaterial = tbMaterial;
	}

}