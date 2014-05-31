package ui.recite;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;

public class LableWord extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7298272205053013407L;

	public LableWord() {
//		setPreferredSize(new Dimension(220,150));
		setFont(new Font("宋体",Font.BOLD,20));
	}
	
	public LableWord setWord(String s){
		setText("<HTML>"+s+"</HTML>");
		View labelView = BasicHTML.createHTMLView(this, "<HTML>"+s+"</HTML>");
		int labelWidth = 220;
		int labelHeight = 100;
		labelView.setSize(labelWidth, labelHeight);
		int trueHight = (int) labelView.getMinimumSpan(View.Y_AXIS);
		setPreferredSize(new Dimension(labelWidth,trueHight> labelHeight?trueHight:labelHeight));
		return this;
	}
}
