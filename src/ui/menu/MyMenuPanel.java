package ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.MenuPannel;
import interfaces.UiActions;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.main.MyAbstractJPanel;

public class MyMenuPanel extends MyAbstractJPanel implements MenuPannel {
	private static final long serialVersionUID = 5922853901645643231L;
	private ListPanel listPanel;
	private JButton buttonStart = new ButtonStart();
	private JButton buttonExit = new ButtonExit();
	private JButton buttonStatistics = new JButton("统计");
	public MyMenuPanel(final UiActions mActions,String[] list){
		listPanel = new ListPanel(list);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalStrut(20)); 
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.add(setButtonLayout(new JLabel("词库:")));
		panel.add(p);
		panel.add(Box.createVerticalStrut(5)); 
		panel.add(setButtonLayout(listPanel));
		panel.add(Box.createVerticalStrut(10)); 	
		panel.add(setButtonLayout(buttonStart));	
		panel.add(Box.createVerticalStrut(10)); 	
		panel.add(setButtonLayout(buttonStatistics));
		panel.add(Box.createVerticalStrut(15));
		panel.add(setButtonLayout(buttonExit));
		add(setButtonLayout(panel));
		
		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mActions.clickStartConfig(listPanel.getList().getSelectedIndex());
			}
		});
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mActions.exitProgramme();
			}
		});
		
		buttonStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mActions.getStatistics();
			}
		});
	}
	
}
