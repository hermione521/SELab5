package ui.statics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatisticsFrame extends JFrame {
	
	private static final long serialVersionUID = 2886135048381319854L;
// {"词库名","单词数","已背单词数","正确单词数","错误单词数","正确率"};

	public  StatisticsFrame(Object[][] data){
		super();
		setSize(800, 700);
		
        JPanel jp2 = new JPanel(new GridLayout(3,1));
        int i = 0;

        List<Float> list = new ArrayList<Float>();
        list.add( (float) ((int)data[i][3]));
        list.add((float) ((int)data[i][4]));       
        List<String> elem = new ArrayList<String>();
		elem.add("正确单词"); elem.add("错误单词");
		
        List<Float> list2 = new ArrayList<Float>();
        list2.add( (float) ((int)data[i][2]));
        list2.add((float) ((int)data[i][1]-(int)data[i][2]));
		List<String> elem2 = new ArrayList<String>();
		elem2.add("已背单词"); elem2.add("未背单词");
		
        List<HistogramData> hd = new ArrayList<HistogramData>();
		for(int j=0;j<data.length-1;j++){
			hd.add(new HistogramData( (float)((int)data[j][3]), "正确单词",(String)data[j][0]));
			hd.add(new HistogramData( (float)((int)data[j][1]), "单词总数",(String)data[j][0]));
		}

        
        jp2.add(new PieCharPannel((String) (data[i][0]),elem, list),BorderLayout.CENTER);
        jp2.add(new PieCharPannel("",elem2, list2),BorderLayout.CENTER);
		jp2.add(new HistogramJPanel("aaa",hd,data.length-1),BorderLayout.CENTER);

        
	    setLayout(new BorderLayout());
        add(new TablePannel(data), BorderLayout.WEST);
        add(jp2,BorderLayout.CENTER);
        
		setVisible(true);
	}
}
