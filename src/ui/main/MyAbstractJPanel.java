package ui.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class MyAbstractJPanel extends JPanel {
	
	private static final long serialVersionUID = 6185873178355288162L;

	public MyAbstractJPanel() {
		super(new FlowLayout(FlowLayout.CENTER));
	}
	
	protected  JPanel setButtonLayout(JComponent  button){
		JPanel bp = new JPanel(new GridLayout(1,1));
		bp.add(button);
		return bp;
	}
}
