package persistencia.entidade;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
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
	private String descricao;

	@Column(name="cv_familia")
	private String familia;

	@Column(name="db_preco_medio")
	private double preco_medio;

	@Column(name="dt_vencimento")
	private Timestamp vencimento;

	@Column(name="nu_qnt_estoque")
	private Integer qnt_estoque;

	@Column(name="nu_qnt_minima")
	private Integer qnt_minima;

	@Column(name="tp_material")
	private String tipo_material;

	@Column(name="und_material")
	private String unidade;

	//bi-directional many-to-one association to CurvaAbc
	@OneToMany(mappedBy="tbMaterial")
	private List<CurvaAbc> tbCurvaAbcs = new ArrayList<>();

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

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String cvDescricao) {
		this.descricao = cvDescricao;
	}

	public String getFamilia() {
		return this.familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public double getPrecoMedio() {
		return this.preco_medio;
	}

	public void setPrecoMedio(double preco_medio) {
		this.preco_medio = preco_medio;
	}

	public Timestamp getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(Timestamp vencimento) {
		this.vencimento = vencimento;
	}

	public Integer getNuQntEstoque() {
		return this.qnt_estoque;
	}

	public void setQntEstoque(Integer qnt_estoque) {
		this.qnt_estoque = qnt_estoque;
	}

	public Integer getNuQntMinima() {
		return this.qnt_minima;
	}

	public void setQntMinima(Integer qnt_minima) {
		this.qnt_minima = qnt_minima;
	}

	public String getMaterial() {
		return this.tipo_material;
	}

	public void setTipoMaterial(String tipo_material) {
		this.tipo_material = tipo_material;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public List<CurvaAbc> getTbCurvaAbcs() {
		return this.tbCurvaAbcs;
	}

	public void setTbCurvaAbc(List<CurvaAbc> tbCurvaAbcs) {
		this.tbCurvaAbcs = tbCurvaAbcs;
	}

	public CurvaAbc addTbCurvaAbc(CurvaAbc tbCurvaAbc) {
		getTbCurvaAbcs().add(tbCurvaAbc);
		tbCurvaAbc.setTbMaterial(this);

		return tbCurvaAbc;
	}

	@Override
	public String toString() {
		return "Material [idMaterial=" + idMaterial + ", descricao=" + descricao + ", familia=" + familia
				+ ", preco_medio=" + preco_medio + ", vencimento=" + vencimento + ", qnt_estoque=" + qnt_estoque
				+ ", qnt_minima=" + qnt_minima + ", tipo_material=" + tipo_material + ", unidade=" + unidade
				+ ", tbCurvaAbcs=" + tbCurvaAbcs + ", tbIndicadors=" + tbIndicadors + ", tbRelatorios=" + tbRelatorios
				+ "]";
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