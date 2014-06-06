package ui.statics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import ui.main.MyAbstractJPanel;

public class TablePannel extends MyAbstractJPanel{
	private static final long serialVersionUID = 5136760351632542148L;
	String[] names = {"词库名","单词数","已背单词数","正确单词数","错误单词数","正确率"};
    Object[][] data ;
    
	TableModel dataModel = new AbstractTableModel() {
		private static final long serialVersionUID = 723326538334148865L;

		public int getColumnCount() {
			return names.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public String getColumnName(int column) {
			return names[column];
		}

		@SuppressWarnings("unchecked")
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			return false;
		}

		public void setValueAt(Object aValue, int row, int column) {
			data[row][column] = aValue;
		}
	};
	
	
	public TablePannel(Object[][] data){
		this.data = data;
		setLayout(new BorderLayout());
        JTable tableView = new JTable(dataModel);
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
}
