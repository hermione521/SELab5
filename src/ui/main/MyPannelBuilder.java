package ui.main;

import impl.UiActions;
import ui.ConfigPannel;
import ui.MenuPannel;
import ui.PannelBuilder;
import ui.RecitePannel;
import ui.menu.MyMenuPanel;
import ui.recite.WordPannel;
import ui.starter.MyConfigPanel;
import word.WordItem;

public class MyPannelBuilder implements PannelBuilder {

	private UiActions mActions;
	public MyPannelBuilder(UiActions mActions){
		this.mActions= mActions;
	}
	@Override
	public RecitePannel build(WordItem wi,boolean f,int i) {
		return new WordPannel(mActions, wi.getCh(), f, i);
	}

	@Override
	public MenuPannel build(String[] lists) {
		return new MyMenuPanel(mActions, lists);
	}
	@Override
	public ConfigPannel build() {
		return new MyConfigPanel(mActions);
	}

}
