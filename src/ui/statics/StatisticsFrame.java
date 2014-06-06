package ui.statics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatisticsFrame extends JFrame {
	
	public  StatisticsFrame(Object[][] data){
		super();
		setSize(800, 700);
		
        JPanel jp2 = new JPanel(new GridLayout(3,1));
        int i = 1;

        List<Float> list = new ArrayList<Float>();
        list.add( (float) ((int)data[i][3]));
        list.add((float) ((int)data[i][4]));       
        
        List<Float> list2 = new ArrayList<Float>();
        list2.add( (float) ((int)data[i][3]));
        list2.add((float) ((int)data[i][5]));
        
        jp2.add(new PieCharPannel((data[i][0]+""),list),BorderLayout.CENTER);
        jp2.add(new PieCharPannel("aaa",list),BorderLayout.CENTER);
        jp2.add(new PieCharPannel("aaa",list),BorderLayout.CENTER);

        
	    setLayout(new BorderLayout());
        add(new TablePannel(data), BorderLayout.WEST);
        add(jp2,BorderLayout.CENTER);
        
		setVisible(true);
	}
}
