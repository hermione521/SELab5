package ui.statics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatisticsFrame extends JFrame {
	
	private static final long serialVersionUID = 2886135048381319854L;
// {"词库名","单词数","已背单词数","正确单词数","错误单词数","正确率"};

    JPanel jpannel = new JPanel(new GridLayout(3,1));
	public  StatisticsFrame(final Object[][] data, final JFrame mf){
		super();
		setSize(800, 700);
        final TablePannel table = new TablePannel(data);

        paintPics(data,data.length-1);

        setLayout(new BorderLayout());
        
        add(table, BorderLayout.WEST);
        add(jpannel,BorderLayout.CENTER);
        
		setVisible(true);
		mf.setEnabled(false);
//		mf.setFocusable(false);

		table.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					paintPics(data,table.getTable().getSelectedRow());
				}
			}
		});
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				super.windowClosed(arg0);
				mf.setEnabled(true);
//				mf.setFocusable(true);
			}
		});

	}
	
	private void paintPics(Object[][] data,int i){
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

		jpannel.removeAll();
        jpannel.add(new PieCharPannel((String) (data[i][0]),elem, list),BorderLayout.CENTER);
        jpannel.add(new PieCharPannel("",elem2, list2),BorderLayout.CENTER);
		jpannel.add(new HistogramJPanel("全部词库柱状图统计",hd,data.length-1),BorderLayout.CENTER);
		
		revalidate();
	}
}
