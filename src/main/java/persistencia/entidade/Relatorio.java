package persistencia.entidade;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_relatorio database table.
 * 
 */
@Entity
@Table(name="tb_relatorio")
@NamedQuery(name="Relatorio.findAll", query="SELECT r FROM Relatorio r")
public class Relatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_relatorio")
	private Integer idRelatorio;

	@Column(name="dt_final")
	private Timestamp dtFinal;

	@Column(name="dt_inicial")
	private Timestamp dtInicial;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="id_material")
	private Material tbMaterial;

	public Relatorio() {
	}

	public Integer getIdRelatorio() {
		return this.idRelatorio;
	}

	public void setIdRelatorio(Integer idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public Timestamp getDtFinal() {
		return this.dtFinal;
	}

	public void setDtFinal(Timestamp dtFinal) {
		this.dtFinal = dtFinal;
	}

	public Timestamp getDtInicial() {
		return this.dtInicial;
	}

	public void setDtInicial(Timestamp dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Material getTbMaterial() {
		return this.tbMaterial;
	}

	public void setTbMaterial(Material tbMaterial) {
		this.tbMaterial = tbMaterial;
	}

}