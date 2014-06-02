package ui.recite;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class ButtonConfirm extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2605211113017451185L;
	public ButtonConfirm(){
		super("ȷ��");
		setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		setForeground(Color.white);
		setPreferredSize(new Dimension(220, getPreferredSize().height));
	}
}
