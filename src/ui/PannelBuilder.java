package ui;

import word.WordItem;

public interface PannelBuilder {
	public RecitePannel build(WordItem wi);
	public MenuPannel build(String[] lists);
	public ConfigPannel build();
}
