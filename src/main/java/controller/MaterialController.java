package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistencia.entidade.Material;
import persistencia.jdbc.MaterialDAO;


@RequestScoped
@ManagedBean
public class MaterialController implements Serializable  {
	
	private List<Material> lista_material;
	@PostConstruct
	public void init() {
		System.out.println(" Bean executado! ");
	}
	
	
	public void carregar(){
		MaterialDAO md = new MaterialDAO();
		lista_material = md.buscarTodos();
	}
	
	public List<Material> getLista_material() {
		return lista_material;
	}
	public void setLista_material(List<Material> lista_material) {
		this.lista_material = lista_material;
	}


}
