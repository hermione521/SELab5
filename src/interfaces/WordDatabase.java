package interfaces;

import java.io.Serializable;

public interface WordDatabase extends Serializable{
	public void save();
	public void load();
	
	public String getDatabaseName();
	public void setLastWord(WordItem wi);
	public WordItem getLastWord();
}
