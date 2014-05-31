package ui.statics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ui.main.MyAbstractJPanel;

public class TablePannel extends MyAbstractJPanel{
	private static final long serialVersionUID = 5136760351632542148L;
	String[] names = {"词库名","单词数","已背单词数","正确单词数","错误单词数","正确率"};
	JTable tableView;
	
	public TablePannel(Object[][] data){
		setLayout(new BorderLayout());
		
		TableModel dataModel = new MyTableModel(data,names);
		
		
        tableView = new JTable(dataModel);
        tableView.setRowHeight(25);
        JScrollPane scrollpane = new JScrollPane(tableView);
        tableView.setRowSelectionAllowed(true);
        tableView.setColumnSelectionAllowed(false); ;
        tableView.setSelectionMode(0);
        tableView.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setPreferredSize(new Dimension(470,5000));
        add(scrollpane, BorderLayout.CENTER);
	}
	
	private class MyTableModel extends DefaultTableModel{
		private static final long serialVersionUID = 2989509850900612072L;
		private MyTableModel(Object[][] data,String[] names){ super(data,names); }
		@Override
		public boolean isCellEditable(int arg0, int arg1) { return false; }
	}
	
	JTable getTable(){
		return tableView;
	}
}
