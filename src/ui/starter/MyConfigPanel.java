package ui.starter;

import interfaces.ConfigPannel;
import interfaces.UiActions;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import ui.main.MyAbstractJPanel;

public class MyConfigPanel extends MyAbstractJPanel implements ConfigPannel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1317195495803770696L;
	
	private JButton buttonExit = new ButtonExit();
	private ListPanel list = new ListPanel();
	private JTextField input = new InputWord();
	private JSpinner spinner = new SpinnerNum();
	private JButton buttonStart = new ButtonStart();
	public MyConfigPanel(final UiActions mActions){

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
		
	}

}
