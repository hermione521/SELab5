package ui.recite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.RecitePannel;
import interfaces.UiActions;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.main.MyAbstractJPanel;

public class WordPannel extends MyAbstractJPanel implements RecitePannel{
	private static final long serialVersionUID = -1317195495803770696L;
	
	private JPanel panel = new JPanel();
	private JButton buttonExit = new ButtonExit();
	private JButton buttonConfirm = new ButtonConfirm();
	private JTextField input = new InputWord();
	
	public WordPannel(final UiActions mActions,String ch,Boolean t,int n){

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalStrut(40)); 
		panel.add(setButtonLayout(new LableWord().setWord(ch)));
		panel.add(Box.createVerticalStrut(20)); 
		
		panel.add(setButtonLayout(new JLabel((t==null?"":("上个单词结果："+(t?"正确":"错误")+"，"))+"还剩"+n+"个")));
		panel.add(Box.createVerticalStrut(10)); 

		panel.add(setButtonLayout(input));
		panel.add(Box.createVerticalStrut(10)); 
		
		
		panel.add(Box.createVerticalStrut(5)); 

		panel.add(setButtonLayout(buttonConfirm));
		panel.add(Box.createVerticalStrut(10)); 

		panel.add(setButtonLayout(buttonExit));
		add(setButtonLayout(panel));
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mActions.clickReturnMenu();
			}
		});
		
		buttonConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mActions.checkRecite(input.getText());
			}
		});
	}

}
