package ui.statics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import ui.main.MyAbstractJPanel;

public class PieCharPannel extends MyAbstractJPanel {

	private static final long serialVersionUID = -2290370711311647101L;

	List<String> elem ;
	
	public PieCharPannel(String title,List<String> elem,List<Float> value) {
		DefaultPieDataset piedataset = new DefaultPieDataset();
		for (int i = 0; i < elem.size(); i++) {
			piedataset.setValue(elem.get(i), value.get(i));
		}
		
        JFreeChart jfreechart=createChart(title, piedataset); 
        ChartPanel chartpanel = new ChartPanel(jfreechart); 
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(chartpanel, BorderLayout.CENTER);
	}

	private JFreeChart createChart(String title,PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart(title, piedataset, true, true, false); 
        jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));

        PiePlot pieplot = (PiePlot)jfreechart.getPlot(); 
        pieplot.setLabelFont(new Font("宋体", 0, 12)); 
        pieplot.setNoDataMessage("No data available"); 
        pieplot.setCircular(false); 
        pieplot.setLabelGap(0.02D); 
        jfreechart.getLegend().setItemFont(new Font("宋体", 0,10)); 
        
		return jfreechart;
	}

}
