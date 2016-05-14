package controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import persistencia.entidade.Relatorio;
import persistencia.jdbc.RelatorioDAO;

@ManagedBean
public class RelatorioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;

	private List<Relatorio> relatorios = null;
	private ChartSeries relatorioData;
	private LineChartModel lineModel;

	public List<Relatorio> gerarRelatorio() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		relatorios = relatorioDAO.gerarRelatorio();
		createLineModels();
		return relatorios;
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	@PostConstruct
	private LineChartModel initLineModel() {
		LineChartModel model = new LineChartModel();

		relatorioData = new ChartSeries();
		relatorioData.setLabel("Consumo");
		for (Relatorio relatorio : relatorios) {
			relatorioData.set(relatorio.getMes_saida(), relatorio.getValor_consumido());
		}

		model.addSeries(relatorioData);
		return model;
	}

	private void createLineModels() {
		lineModel = initLineModel();

		lineModel.setTitle("Relatorio 2016");
		lineModel.setLegendPosition("ne");

		Axis xAxis = lineModel.getAxis(AxisType.X);
		xAxis.setLabel("Mês");

		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setLabel("Consumo");
		yAxis.setMin(0);
		yAxis.setMax(1000);

	}

	// retorna o ano atual do sistema
	public String obterAno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		date = new Date();
		String ano = sdf.format(date);

		return ano;
	}
}
