package ui.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class ButtonStart extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2605211113017451185L;
	public ButtonStart(){
		super("START!");
		setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		setForeground(Color.white);
		setFont(new Font("宋体",Font.BOLD,50));
		setPreferredSize(new Dimension(220, 160));
//		setEnabled(false);
	}
}
