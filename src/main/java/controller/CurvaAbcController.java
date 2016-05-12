package controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class CurvaAbcController implements Serializable {

	final int A = 20;
	final int B = 30;
	final int C = 50;
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	private void createPieModels() {
		createPieModel();
	}

	private void createPieModel() {
		pieModel = new PieChartModel();

		pieModel = new PieChartModel();

		pieModel.set("Classe A", A);
		pieModel.set("Classe B", B);
		pieModel.set("Classe C", C);
		pieModel.setSeriesColors("66cc66,E7E658,cc6666");
		// pieModel1.setTitle("Curva ABC");
		pieModel.setLegendPosition("S");
	}
}
