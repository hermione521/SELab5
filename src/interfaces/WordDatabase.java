package interfaces;

import java.io.Serializable;
import java.util.List;

public interface WordDatabase extends Serializable{
	public void save();
	
	public String getDatabaseName();
	public WordItem getLastWord();
	
	public void setCurrentDatabase(char c);
	
	public List<WordItem> search(String s,int num);
}
