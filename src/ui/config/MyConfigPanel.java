package ui.config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import interfaces.ConfigPannel;
import interfaces.UiActions;
import interfaces.WordItem;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ui.main.MyAbstractJPanel;

public class MyConfigPanel extends MyAbstractJPanel implements ConfigPannel{
	
	private static final long serialVersionUID = 2465304667136598974L;
	private JButton buttonExit = new ButtonExit();
	private ListPanel list = new ListPanel();
	private JTextField input = new InputWord();
	private JSpinner spinner = new SpinnerNum();
	private JButton buttonStart = new ButtonStart();
	private UiActions mActions;
	public MyConfigPanel(final UiActions mActions){
		this.mActions = mActions;
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalStrut(15));
		panel.add(setButtonLayout(new JLabel(" 选择起始单词:")));
		panel.add(Box.createVerticalStrut(5)); 
		panel.add(setButtonLayout(input));
		panel.add(Box.createVerticalStrut(5)); 
		panel.add(setButtonLayout(list));
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		final JRadioButton r1 = new JRadioButton("从上次继续");
		final JRadioButton r2 = new JRadioButton("从头开始");
		final JRadioButton r3 = new JRadioButton("手动选择");
		p.add(setButtonLayout(r1));
		p.add(setButtonLayout(r2));
		p.add(setButtonLayout(r3));
		panel.add(p);
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1); bg.add(r2); bg.add(r3);
		bg.setSelected(r3.getModel(), true);

		
		panel.add(Box.createVerticalStrut(5)); 

		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p2.add(setButtonLayout(new JLabel("������")));
		p2.add(setButtonLayout(spinner));
		panel.add(p2);
		
		panel.add(Box.createVerticalStrut(5)); 

		panel.add(setButtonLayout(buttonStart));
		panel.add(Box.createVerticalStrut(10));
		panel.add(setButtonLayout(buttonExit));
		add(setButtonLayout(panel));
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mActions.clickReturnMenu();
			}
		});
		
		input.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				inputChanges();
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				inputChanges();
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				inputChanges();		
			}
		});
		
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = list.getList().getSelectedValue();
				if(r3.isSelected()) mActions.clickStartRecite(s.substring(0,s.indexOf("::")),(Integer)spinner.getValue());
				if(r1.isSelected()) mActions.clickStartReciteLast((Integer)spinner.getValue());
				if(r2.isSelected()) mActions.clickStartReciteDefault((Integer)spinner.getValue());
			}
		});
		
		list.getList().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				buttonStart.setEnabled(true);
			}
		});
		
		r1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				input.setEditable(false);
				list.getList().setEnabled(false);
				buttonStart.setEnabled(true);
			}
		});
		r2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				input.setEditable(false);
				list.getList().setEnabled(false);
				buttonStart.setEnabled(true);
			}
		});
		r3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				input.setEditable(true);
				list.getList().setEnabled(true);
				if(list.getList().getSelectedValue()==null) buttonStart.setEnabled(false);
			}
		});
	}


	
	
	private void inputChanges(){
		List<WordItem> words = mActions.inputText(input.getText());
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(WordItem w:words){
			listModel.addElement(w.toString());
		}
		list.getList().setModel(listModel);
		this.getParent().revalidate();
		buttonStart.setEnabled(false);
	}
}
