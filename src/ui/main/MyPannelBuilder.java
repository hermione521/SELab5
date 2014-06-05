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

public class MyPannelBuilder implements PannelBuilder {

	private UiActions mActions;
	public MyPannelBuilder(UiActions mActions){
		this.mActions= mActions;
	}
	@Override
	public RecitePannel buildRecitePannel(WordItem wi,boolean f,int i) {
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
		return new MainFrame(mActions);
	}

}
