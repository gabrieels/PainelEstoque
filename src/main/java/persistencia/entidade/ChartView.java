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
	//private LineChartModel lineModel;
	private MeterGaugeChartModel meterGaugeModel;
	private PieChartModel pieModel;
	int A = 20;
	int B = 30;
	int C = 50;
	@PostConstruct
	public void init() {
		createMeterGaugeModels();
		createPieModels();
		//createLineModels();

	}

	// View do grafico Curva ABC - Grafico de Pizza

	private void createPieModels() {
		createPieModel();
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}
	
	private void createPieModel() {
		pieModel = new PieChartModel();

		pieModel.set("Classe A", A);
		pieModel.set("Classe B", B);
		pieModel.set("Classe C", C);
		pieModel.setSeriesColors("66cc66,E7E658,cc6666");
		// pieModel1.setTitle("Curva ABC");
		pieModel.setLegendPosition("S");
	}
	// ####################################################################################################\\
	// View dos Indicadores

	private void createMeterGaugeModels() {

		meterGaugeModel = initMeterGaugeModel();
		meterGaugeModel.setSeriesColors("cc6666,E7E658,93b75f,66cc66");
		meterGaugeModel.setGaugeLabel("70%");
		meterGaugeModel.setGaugeLabelPosition("bottom");
		meterGaugeModel.setShowTickLabels(false);
		// meterGaugeModel.setLabelHeightAdjust(110);
		meterGaugeModel.setIntervalOuterRadius(100);
	}

	public MeterGaugeChartModel getMeterGaugeModel() {
		return meterGaugeModel;
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
/*	private void createLineModels() {
		lineModel = initLinearModel();

		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

		lineModel = initCategoryModel();
		// lineModel1.setTitle("Relatório Mensal");
		lineModel.setLegendPosition("e");
		lineModel.setShowPointLabels(true);
		lineModel.getAxes().put(AxisType.X, new CategoryAxis(""));
		yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setLabel("Consumo R$");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}*/

/*	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries mes = new ChartSeries();
		mes.setLabel("Linha de Consumo");
		mes.set("Janeiro", 50);
		mes.set("Feveiro", 170);
		mes.set("Marco", 80);
		mes.set("Abril", 35);
		mes.set("Maio", 50);
		mes.set("Junho", 170);
		mes.set("Julho", 80);
		mes.set("Agosto", 35);
		mes.set("Setembro", 35);
		mes.set("Outrubro", 35);
		mes.set("Novembro", 35);
		mes.set("Dezembro", 35);
		
		model.addSeries(mes);

		return model;
	}
*/
	/*private LineChartModel initLinearModel() {
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

	public LineChartModel getLineModel() {
		return lineModel;
	}
*/
	// ###################################################################################################################//

	// DESCOBRIR O QUE É ESTÁ FUNCAO//
	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
