package interfaces;

import java.io.Serializable;
import java.util.List;

public interface WordDatabase extends Serializable{
	public void save();
	
	public String getDatabaseName();
	public WordItem getLastWord();
	public void setLastWord(WordItem wi);
	
	public String[] getAllDataBase();
	public void setCurrentDatabase(String s);
	public String getCurrentDatabase();
	
	public List<WordItem> search(String s,int num);
}
