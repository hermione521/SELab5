package ui.main;

import impl.UiActions;
import ui.ConfigPannel;
import ui.MenuPannel;
import ui.PannelBuilder;
import ui.RecitePannel;
import ui.menu.MyMenuPanel;
import ui.starter.MyConfigPanel;
import word.WordItem;

public class MyPannelBuilder implements PannelBuilder {

	private UiActions mActions;
	public MyPannelBuilder(UiActions mActions){
		this.mActions= mActions;
	}
	@Override
	public RecitePannel build(WordItem wi) {
		// TODO 自动生成的方法存根
		return null;
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
