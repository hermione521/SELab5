package ui.main;

import javax.swing.JFrame;

import interfaces.ConfigPannel;
import interfaces.MenuPannel;
import interfaces.PannelBuilder;
import interfaces.RecitePannel;
import interfaces.UiActions;
import interfaces.WordItem;
import ui.config.MyConfigPanel;
import ui.menu.MyMenuPanel;
import ui.recite.WordPannel;
import ui.statics.StatisticsFrame;

public class MyPannelBuilder implements PannelBuilder {

	private UiActions mActions;
	
	private JFrame mf=null;
	public MyPannelBuilder(UiActions mActions){
		this.mActions= mActions;
	}
	@Override
	public RecitePannel buildRecitePannel(WordItem wi,Boolean f,int i) {
		return new WordPannel(mActions, wi.getCh(), f, i);
	}

	@Override
	public MenuPannel buildMenuPannel(String[] lists) {
		return new MyMenuPanel(mActions, lists);
	}
	@Override
	public ConfigPannel buildConfigPannel() {
		return new MyConfigPanel(mActions);
	}
	@Override
	public JFrame buildJframe() {
		if(mf == null) mf = new MainFrame(mActions);
		return mf;
	}
	@Override
	public JFrame buildStatistics(Object[][] data) {
		return new StatisticsFrame(data,mf);
	}
	

}
