package ui.starter;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -980080397623073456L;

	private JList<String> list;

	public ListPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
	    list = new JList<String>(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		list.setVisibleRowCount(7);
		add(scrollPane);
		setPreferredSize(new Dimension(220, getPreferredSize().height));
	}
	
	public JList<String> getList(){
		return list;
	}
}
