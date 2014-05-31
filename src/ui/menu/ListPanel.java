package ui.menu;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -980080397623073456L;

	JList<String> jlist;
	public ListPanel(String[] lists){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(String s:lists){
			listModel.addElement(s);
		}
	    
		jlist = new JList<String>(listModel);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setSelectedIndex(0);
		JScrollPane scrollPane = new JScrollPane(jlist);
		jlist.setVisibleRowCount(4);
		add(scrollPane);
	}
	
	public JList<String> getList(){
		return jlist;
	}
}
