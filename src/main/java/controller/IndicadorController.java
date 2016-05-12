package controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.MeterGaugeChartModel;

@ManagedBean
public class IndicadorController implements Serializable {

	private static final long serialVersionUID = 1L;
	private MeterGaugeChartModel meterGaugeModel;

	@PostConstruct
	public void init() {
		createMeterGaugeModels();
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

	private void createMeterGaugeModels() {

		meterGaugeModel = initMeterGaugeModel();
		meterGaugeModel.setSeriesColors("cc6666,E7E658,93b75f,66cc66");
		meterGaugeModel.setGaugeLabelPosition("bottom");
		meterGaugeModel.setShowTickLabels(false);
		meterGaugeModel.setLabelHeightAdjust(110);
		meterGaugeModel.setIntervalOuterRadius(100);
	}
}
