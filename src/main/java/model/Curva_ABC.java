package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="curva_abc")
public class Curva_ABC {
	private Long id_curva;
	private List<Material> materiais;
	private char classificao;
}
