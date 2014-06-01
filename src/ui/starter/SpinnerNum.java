package ui.starter;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SpinnerNum extends JSpinner {
	private static final long serialVersionUID = -4856201148539878795L;
	public SpinnerNum() {
		super(new SpinnerNumberModel(20,1,Integer.MAX_VALUE,1));
	}
}
