package persistencia.entidade;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ChartView implements Serializable {

	private static final long serialVersionUID = 1L;
	private LineChartModel lineModel1;
	private LineChartModel lineModel2;
	
	private MeterGaugeChartModel meterGaugeModel1;
    private MeterGaugeChartModel meterGaugeModel2;

	@PostConstruct
	public void init() {
		createLineModels();
		createMeterGaugeModels();
	}
	
	public LineChartModel getLineModel1() {
		return lineModel1;
	}

	public LineChartModel getLineModel2() {
		return lineModel2;
	}

	private void createLineModels() {
		lineModel1 = initLinearModel();
		lineModel1.setTitle("Linear Chart");
		lineModel1.setLegendPosition("e");
		Axis yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

		lineModel2 = initCategoryModel();
		lineModel2.setTitle("Category Chart");
		lineModel2.setLegendPosition("e");
		lineModel2.setShowPointLabels(true);
		lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		yAxis = lineModel2.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Series 1");

		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);

		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Series 2");

		series2.set(1, 6);
		series2.set(2, 3);
		series2.set(3, 2);
		series2.set(4, 7);
		series2.set(5, 9);

		model.addSeries(series1);
		model.addSeries(series2);

		return model;
	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 90);
		girls.set("2008", 120);

		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	public MeterGaugeChartModel getMeterGaugeModel1() {
        return meterGaugeModel1;
    }
     
    public MeterGaugeChartModel getMeterGaugeModel2() {
        return meterGaugeModel2;
    }
 
    private MeterGaugeChartModel initMeterGaugeModel() {
        List<Number> intervals = new ArrayList<Number>(){{
            add(20);
            add(50);
            add(120);
            add(220);
        }};
         
        return new MeterGaugeChartModel(140, intervals);
    }
 
    private void createMeterGaugeModels() {
        meterGaugeModel1 = initMeterGaugeModel();
        meterGaugeModel1.setTitle("MeterGauge Chart");
        meterGaugeModel1.setGaugeLabel("km/h");
         
        meterGaugeModel2 = initMeterGaugeModel();
        meterGaugeModel2.setTitle("Indicadores");
        meterGaugeModel2.setSeriesColors("cc6666,E7E658,93b75f,66cc66");
        //meterGaugeModel2.setGaugeLabel("km/h");
        meterGaugeModel2.setGaugeLabelPosition("bottom");
        meterGaugeModel2.setShowTickLabels(false);
        meterGaugeModel2.setLabelHeightAdjust(110);
        meterGaugeModel2.setIntervalOuterRadius(100);
    }

}
