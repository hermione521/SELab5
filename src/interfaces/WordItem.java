package interfaces;

import java.io.Serializable;

public interface WordItem extends Serializable,Comparable<WordItem> {
	public String getEn();
	public String getCh();
	public String toString();
	
	public boolean equals(Object arg0);
	public int compareTo(WordItem arg0);
	public boolean startsWith(String start);
	
	public boolean check(String in);
	public int getTimes();
	public int getCorrect();
}
