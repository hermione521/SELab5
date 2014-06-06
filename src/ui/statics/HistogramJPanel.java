package ui.statics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
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
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;

import ui.main.MyAbstractJPanel;

public class HistogramJPanel extends MyAbstractJPanel { 
    private String verticallyTitle = "单词数";
    private String horizontalTitle = "";
    private List<String> elem = new ArrayList<String>();// 内容初始值 （每个类型显示文字） 
 
    public HistogramJPanel(String title,List<Float> value) { 
    	elem = new ArrayList<String>();
    	elem.add("正确单词");
    	elem.add("总词数");
        
        DefaultCategoryDataset categorydataset = new DefaultCategoryDataset();// 缺省类型数据设置 
        for (int i = 0; i < elem.size(); i++) { 
        	categorydataset.addValue(value.get(i),"PanelByHistogram", elem.get(i)); 
        	categorydataset.addValue(value.get(i*2),"a", elem.get(i)); 
        } 
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(categorydataset, 0, elem.size()); 

        JFreeChart jfreechart = createChart(title, dataset); 
        ChartPanel chartpanel = new ChartPanel(jfreechart); 
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(chartpanel, BorderLayout.CENTER);
    } 
    
    private JFreeChart createChart(String title,CategoryDataset categorydataset)   { 
        JFreeChart jfreechart = ChartFactory.createBarChart(title,  horizontalTitle, verticallyTitle, categorydataset, PlotOrientation.VERTICAL, true, true, false); 

        TextTitle t = jfreechart.getTitle(); 
//        t.setFont(new Font("宋体", Font.BOLD, 30)); 

        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot(); 

        CategoryAxis categoryaxis = categoryplot.getDomainAxis();// X轴 
        categoryaxis.setMaximumCategoryLabelWidthRatio(0.8F); 
        categoryaxis.setLowerMargin(0.15D); 
        categoryaxis.setUpperMargin(0.15D); 
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
        
        barrenderer.setSeriesPaint(1, Color.blue); 
        return jfreechart; 
    } 
} 