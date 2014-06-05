package ui.main;

import interfaces.UiActions;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2943141619736401172L;
	
	public MainFrame(final UiActions mActions){
		super();
		setSize(400, 570);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				super.windowClosed(arg0);
				mActions.exitProgramme();
			}
		});
	}
}
