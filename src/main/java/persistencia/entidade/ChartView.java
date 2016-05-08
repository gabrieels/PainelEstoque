package persistencia.entidade;

import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ChartView implements Serializable {

	private static final long serialVersionUID = 1L;
	private LineChartModel lineModel1;
	
	private MeterGaugeChartModel meterGaugeModel1;
	private MeterGaugeChartModel meterGaugeModel2;

	private PieChartModel pieModel1;

	@PostConstruct
	public void init() {
		createMeterGaugeModels();
		createPieModels(); 
		createLineModels();

	}

	
	
	// View do grafico Curva ABC - Grafico de Pizza

	private void createPieModels() {
		createPieModel1();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Classe A", 20);
		pieModel1.set("Classe B", 30);
		pieModel1.set("Classe C", 50);
		pieModel1.setSeriesColors("66cc66,E7E658,cc6666");
		//pieModel1.setTitle("Curva ABC");
		pieModel1.setLegendPosition("w");
	}
	// ####################################################################################################\\
	// View dos Indicadores

	private void createMeterGaugeModels() {

		meterGaugeModel2 = initMeterGaugeModel();
		meterGaugeModel2.setSeriesColors("cc6666,E7E658,93b75f,66cc66");
		meterGaugeModel2.setGaugeLabel("70%");
		meterGaugeModel2.setGaugeLabelPosition("bottom");
		meterGaugeModel2.setShowTickLabels(false);
		//meterGaugeModel2.setLabelHeightAdjust(110);
		meterGaugeModel2.setIntervalOuterRadius(100);
	}

	public MeterGaugeChartModel getMeterGaugeModel1() {
		return meterGaugeModel1;
	}

	public MeterGaugeChartModel getMeterGaugeModel2() {
		return meterGaugeModel2;
	}

	private MeterGaugeChartModel initMeterGaugeModel() {
		List<Number> intervals = new ArrayList<Number>() {
			{
				add(20);
				add(50);
				add(120);
				add(220);
			}
		};

		return new MeterGaugeChartModel(140, intervals);
	}

	// ####################################################################################################\\
	// View do Relatorio Mensal
	private void createLineModels() {
		lineModel1 = initLinearModel();

		Axis yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

		lineModel1 = initCategoryModel();
		//lineModel1.setTitle("Relatório Mensal");
		lineModel1.setLegendPosition("e");
		lineModel1.setShowPointLabels(true);
		lineModel1.getAxes().put(AxisType.X, new CategoryAxis(""));
		yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setLabel("Consumo R$");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Linha de Consumo");
		boys.set("Janeiro", 120);
		boys.set("Feveiro", 100);
		boys.set("Marco", 44);
		boys.set("Abril", 150);

		model.addSeries(boys);

		return model;
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();
		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Series 2");

		series2.set(1, 6);
		series2.set(2, 3);
		series2.set(3, 2);
		series2.set(4, 7);
		series2.set(5, 9);

		model.addSeries(series2);

		return model;
	}
	public LineChartModel getLineModel1() {
		return lineModel1;
	}

	

	
	//###################################################################################################################//
	
	// DESCOBRIR O QUE É ESTÁ FUNCAO//
	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
