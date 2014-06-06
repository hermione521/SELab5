package ui.statics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;

import ui.main.MyAbstractJPanel;

public class HistogramJPanel extends MyAbstractJPanel { 
	private static final long serialVersionUID = -6005809209990192630L;
	private String verticallyTitle = "单词数";
    private String horizontalTitle = "";
 
    public HistogramJPanel(String title,List<HistogramData> data,int elemsize) { 

        DefaultCategoryDataset categorydataset = new DefaultCategoryDataset();// 缺省类型数据设置 
        for (int i = 0; i < data.size(); i++) { 
        	categorydataset.addValue(data.get(i).getValue(),data.get(i).getType(), data.get(i).getBelong()); 
        } 
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(categorydataset, 0, elemsize); 

        JFreeChart jfreechart = createChart(title, dataset); 
        ChartPanel chartpanel = new ChartPanel(jfreechart); 
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(chartpanel, BorderLayout.CENTER);
    } 
    
    private JFreeChart createChart(String title,CategoryDataset categorydataset)   { 
        JFreeChart jfreechart = ChartFactory.createBarChart(title,  horizontalTitle, verticallyTitle, categorydataset, PlotOrientation.VERTICAL, true, true, false); 

       jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 30)); 

        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot(); 

        CategoryAxis categoryaxis = categoryplot.getDomainAxis();// X轴 
        categoryaxis.setMaximumCategoryLabelWidthRatio(0.8F); 
        categoryaxis.setLowerMargin(0.05D); 
        categoryaxis.setUpperMargin(0.05D); 
//        categoryaxis.setLabelFont(new Font("宋体", Font.BOLD, 20));// x轴标题文字 
        categoryaxis.setTickLabelFont(new Font("黑体", Font.BOLD, 10));// x轴坐标上文字 
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();// Y轴 
        numberaxis.setLabelFont(new Font("宋体", Font.BOLD, 20));// x轴标题文字 
        numberaxis.setTickLabelFont(new Font("黑体", Font.BOLD, 10));// x轴坐标上文字 
        numberaxis.setUpperMargin(0.15D); 
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); //整数显示

        BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer(); 
        barrenderer.setDrawBarOutline(false); 
         
        barrenderer.setItemLabelAnchorOffset(5D); 
        barrenderer.setBaseItemLabelsVisible(true); 
        barrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
        barrenderer.setItemMargin(-0.1);
        
        jfreechart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 10));
        
        barrenderer.setSeriesPaint(1, Color.blue); 
        return jfreechart; 
    } 
} 