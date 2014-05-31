package ui.config;

import java.awt.Dimension;
import javax.swing.JTextField;

public class InputWord extends JTextField{
	private static final long serialVersionUID = 570570441480036332L;

	public InputWord(){
		setPreferredSize(new Dimension(getPreferredSize().width,getPreferredSize().height+10));
	}
}
