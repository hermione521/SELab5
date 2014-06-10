package interfaces;

import java.util.List;

public interface UiActions {
	public void exitProgramme();
	public void clickStartConfig(String worddata);
	
	public void clickReturnMenu();
	public List<WordItem> inputText(String s);
	
	public void clickStartRecite(WordItem word,int num) ;	
	public void clickStartReciteLast(int num) ;	
	public void clickStartReciteDefault(int num);	
	
	public boolean nextReciteWord();
	public boolean checkRecite(String in);
	public void clickReturnConfig();
	
	public String getStatistics();
	public WordDatabase getWd();
}
