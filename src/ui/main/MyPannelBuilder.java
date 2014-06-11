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
	private MenuPannel mp = null;
	private ConfigPannel cp = null;
	
	private RecitePannel rp = null;
	
	public MyPannelBuilder(UiActions mActions){
		this.mActions= mActions;
	}
	
	@Override
	public RecitePannel buildRecitePannel(WordItem wi,Boolean f,int i) {
		return new WordPannel(mActions, wi, f, i);
	}

	@Override
	public MenuPannel buildMenuPannel(String[] lists) {
		if(mp == null) mp = new MyMenuPanel(mActions, lists);
		return mp;
	}
	
	@Override
	public ConfigPannel buildConfigPannel() {
		if(cp == null) cp = new MyConfigPanel(mActions);
		return cp;
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
