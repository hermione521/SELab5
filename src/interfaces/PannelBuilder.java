package interfaces;

import javax.swing.JFrame;


public interface PannelBuilder {
	public JFrame buildJframe();
	public RecitePannel buildRecitePannel(WordItem wi,Boolean f,int i);
	public MenuPannel buildMenuPannel(String[] lists);
	public ConfigPannel buildConfigPannel();
	public JFrame buildStatistics(Object[][] data);
}
