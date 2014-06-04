package interfaces;

import javax.swing.JFrame;


public interface PannelBuilder {
	public JFrame buildJframe();
	public RecitePannel buildRecitePannel(WordItem wi,boolean f,int i);
	public MenuPannel buildMenuPannel(String[] lists);
	public ConfigPannel buildConfigPannel();
}
