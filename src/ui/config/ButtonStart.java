package ui.config;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class ButtonStart extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2605211113017451185L;
	public ButtonStart(){
		super("开始!");
		setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		setForeground(Color.white);
		setPreferredSize(new Dimension(220, getPreferredSize().height));
		setEnabled(false);
	}
}
