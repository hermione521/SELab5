package ui.recite;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.WordItem;

public class CharacterPannel extends JPanel{
	final int ROW_WIDTH = 6;
	
	CharacterPannel(WordItem wi){
		char[] cs = wi.getEn().toCharArray();
		
		
		
		JPanel jp = new JPanel();
		
		List<JButton> lb = generateJButton(cs);
		int rows = lb.size()/5;
		
		jp.setPreferredSize(new Dimension(250,150));
		jp.setLayout(new GridLayout(2,ROW_WIDTH));

		for(JButton b:lb){
			jp.add(b);
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel l = new JLabel("aaa"+lb.size());
		l.setAlignmentX(0.5f);
		add(l);

		
		add(Box.createVerticalStrut(20));
		
		add(jp);
	}
	
	private List<JButton> generateJButton(char[] cs){
		List<JButton> tmp = new ArrayList<JButton>();
		for(char c :cs){
			tmp.add(new JButton(c+""));
		}
		for(int i=0;i<cs.length/2;i++){
			tmp.add(new JButton("1"));
		}
		
		JButton vb = new JButton(); vb.setVisible(false);
		
		while(tmp.size()/ROW_WIDTH*ROW_WIDTH!=tmp.size()){
			tmp.add(vb);
		}
		
		return tmp;
	}
}
