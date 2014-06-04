package wordData;

import java.util.regex.Pattern;

import interfaces.WordItem;

public class MyWordItem implements WordItem {

	private static final long serialVersionUID = -3151582396313932147L;
	private String en,ch;
	private int times;
	private int correct;
	
	public MyWordItem(String en,String ch){
		this.en=en;
		this.ch=ch;
		times = 0;
		correct=0;
	}
	
	public String getEn() {
		return en;
	}
	
	public String getCh() {
		return ch;
	}

	@Override
	public String toString() {
		return en+"::"+ch;
	}
	
	@Override
	public boolean equals(Object arg0) {
		return en.equals(((WordItem)arg0).getEn());
	}
	
	@Override
	public int compareTo(WordItem arg0) {
        Pattern pattern = Pattern.compile("/W");  
        String s1 = pattern.matcher(arg0.getEn()).replaceAll("");  
        String s2 = pattern.matcher(en).replaceAll("");  
		return s1.compareTo(s2);
	}
	
	@Override
	public boolean startsWith(String start) {
        Pattern pattern = Pattern.compile("[^a-zA-Z]");  
        String s2 = pattern.matcher(en).replaceAll(""); 
        return s2.startsWith(start);
	}
	
	@Override
	public boolean check(String in){
		if(en.equalsIgnoreCase(in)) correct++;
		times++;
		return en.equalsIgnoreCase(in);
	}
	
	public int getTimes() {
		return times;
	}
	
	public int getCorrect() {
		return correct;
	}
}
