package interfaces;

import java.util.List;

public interface UiActions {
	public String[] getWordBaseList();
	
	public void exitProgramme();
	public void startConfig(String worddata);
	
	public void returnMenu();
	public List<WordItem> inputText(String s);
	
	public void startWord(String word,int num) ;	
	public void startLast(int num) ;	
	public void startDefault(int num);	
	
	public boolean nextWord();
	public boolean check(String in);
	public void returnConfig();
	
	public String getStatistics();
	
	public void revalidate();
}
