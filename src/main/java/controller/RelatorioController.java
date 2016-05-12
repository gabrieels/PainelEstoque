package controller;


 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class RelatorioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
    private LineChartModel lineModel;
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel() {
        return lineModel;
    }
 
    
    
     
    private void createLineModels() {
        lineModel = initLinearModel();
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        lineModel.setTitle(obterAno());
        lineModel.setLegendPosition("e");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setLabel("Consumo");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Linha de consumo");
                
        series.set("Janeiro", 2);
        series.set("Fevereiro", 3);
        series.set("Março", 10);
        series.set("Abril", 50);
        series.set("Maio", 10); 
        series.set("Junho", 170);
        series.set("Julho", 80);
        series.set("Agosto", 35);
        series.set("Setembro", 35);
        series.set("Outrubro", 35);
        series.set("Novembro", 35);
        series.set("Dezembro", 35);
        model.addSeries(series);
        
         
        return model;
    }
     
    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries mes = new ChartSeries();
        String ano = obterAno();
        mes.setLabel("Linha de Consumo " + ano);
        
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
 


	// retorna o ano atual do sistema
	public String obterAno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		date = new Date();
		String ano = sdf.format(date);

		return ano;
	}
}
