package ui.recite;

import java.awt.Dimension;
import javax.swing.JTextField;

public class InputWord extends JTextField{
	private static final long serialVersionUID = -2844360995694985216L;

	public InputWord(){
		setPreferredSize(new Dimension(getPreferredSize().width,getPreferredSize().height+10));
	}
}
