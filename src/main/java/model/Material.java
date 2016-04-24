package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tb_material database table.
 * 
 */
@Entity
@Table(name="tb_material")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_material")
	private Integer idMaterial;

	@Column(name="cv_descricao")
	private String cvDescricao;

	@Column(name="cv_familia")
	private String cvFamilia;

	@Column(name="db_preco_medio")
	private double dbPrecoMedio;

	@Column(name="dt_vencimento")
	private Timestamp dtVencimento;

	@Column(name="nu_qnt_estoque")
	private Integer nuQntEstoque;

	@Column(name="nu_qnt_minima")
	private Integer nuQntMinima;

	@Column(name="tp_material")
	private String tpMaterial;

	@Column(name="und_material")
	private String undMaterial;

	//bi-directional many-to-one association to CurvaAbc
	@OneToMany(mappedBy="tbMaterial")
	private List<CurvaAbc> tbCurvaAbcs;

	//bi-directional many-to-one association to Indicador
	@OneToMany(mappedBy="tbMaterial")
	private List<Indicador> tbIndicadors;

	//bi-directional many-to-one association to Relatorio
	@OneToMany(mappedBy="tbMaterial")
	private List<Relatorio> tbRelatorios;

	public Material() {
	}

	public Integer getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getCvDescricao() {
		return this.cvDescricao;
	}

	public void setCvDescricao(String cvDescricao) {
		this.cvDescricao = cvDescricao;
	}

	public String getCvFamilia() {
		return this.cvFamilia;
	}

	public void setCvFamilia(String cvFamilia) {
		this.cvFamilia = cvFamilia;
	}

	public double getDbPrecoMedio() {
		return this.dbPrecoMedio;
	}

	public void setDbPrecoMedio(double dbPrecoMedio) {
		this.dbPrecoMedio = dbPrecoMedio;
	}

	public Timestamp getDtVencimento() {
		return this.dtVencimento;
	}

	public void setDtVencimento(Timestamp dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Integer getNuQntEstoque() {
		return this.nuQntEstoque;
	}

	public void setNuQntEstoque(Integer nuQntEstoque) {
		this.nuQntEstoque = nuQntEstoque;
	}

	public Integer getNuQntMinima() {
		return this.nuQntMinima;
	}

	public void setNuQntMinima(Integer nuQntMinima) {
		this.nuQntMinima = nuQntMinima;
	}

	public String getTpMaterial() {
		return this.tpMaterial;
	}

	public void setTpMaterial(String tpMaterial) {
		this.tpMaterial = tpMaterial;
	}

	public String getUndMaterial() {
		return this.undMaterial;
	}

	public void setUndMaterial(String undMaterial) {
		this.undMaterial = undMaterial;
	}

	public List<CurvaAbc> getTbCurvaAbcs() {
		return this.tbCurvaAbcs;
	}

	public void setTbCurvaAbcs(List<CurvaAbc> tbCurvaAbcs) {
		this.tbCurvaAbcs = tbCurvaAbcs;
	}

	public CurvaAbc addTbCurvaAbc(CurvaAbc tbCurvaAbc) {
		getTbCurvaAbcs().add(tbCurvaAbc);
		tbCurvaAbc.setTbMaterial(this);

		return tbCurvaAbc;
	}

	public CurvaAbc removeTbCurvaAbc(CurvaAbc tbCurvaAbc) {
		getTbCurvaAbcs().remove(tbCurvaAbc);
		tbCurvaAbc.setTbMaterial(null);

		return tbCurvaAbc;
	}

	public List<Indicador> getTbIndicadors() {
		return this.tbIndicadors;
	}

	public void setTbIndicadors(List<Indicador> tbIndicadors) {
		this.tbIndicadors = tbIndicadors;
	}

	public Indicador addTbIndicador(Indicador tbIndicador) {
		getTbIndicadors().add(tbIndicador);
		tbIndicador.setTbMaterial(this);

		return tbIndicador;
	}

	public Indicador removeTbIndicador(Indicador tbIndicador) {
		getTbIndicadors().remove(tbIndicador);
		tbIndicador.setTbMaterial(null);

		return tbIndicador;
	}

	public List<Relatorio> getTbRelatorios() {
		return this.tbRelatorios;
	}

	public void setTbRelatorios(List<Relatorio> tbRelatorios) {
		this.tbRelatorios = tbRelatorios;
	}

	public Relatorio addTbRelatorio(Relatorio tbRelatorio) {
		getTbRelatorios().add(tbRelatorio);
		tbRelatorio.setTbMaterial(this);

		return tbRelatorio;
	}

	public Relatorio removeTbRelatorio(Relatorio tbRelatorio) {
		getTbRelatorios().remove(tbRelatorio);
		tbRelatorio.setTbMaterial(null);

		return tbRelatorio;
	}

}