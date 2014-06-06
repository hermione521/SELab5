package impl;

import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.main.MyPannelBuilder;
import wordData.MyWordDatabase;
import interfaces.*;

public class Controler implements UiActions {
	private PannelBuilder b = new MyPannelBuilder(this);
	private ConfigPannel cp;
	private MenuPannel mp;
	private JFrame mf;
	
	private WordDatabase wd;
	
	public Controler(){
		b.buildConfigPannel();
		mf = b.buildJframe();
		cp = b.buildConfigPannel();
		mp = b.buildMenuPannel(getWordBaseList());
		
		changPannel((JPanel) mp);

		try {
			wd = MyWordDatabase.instance("dictionary.txt");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"未发现词库");  
			this.exitProgramme();
		}
		
	}
	
	private void changPannel(JPanel p){
		mf.setContentPane(p);
		mf.revalidate();
	}
	
	private String[] getWordBaseList() {
		String[] s = new String[26];
		for(int i =0;i<26;i++){
			s[i]=((char)(i+'a'))+" 词库";
		}
		return s;
	}

	@Override
	public void exitProgramme() {
		wd.save();
		System.exit(0);
	}

	@Override
	public void clickStartConfig(String worddata) {
		wd.setCurrentDatabase(worddata.charAt(0));
		changPannel((JPanel) cp);
	}

	@Override
	public void clickReturnMenu() {
		changPannel((JPanel) mp);
	}

	@Override
	public List<WordItem> inputText(String s) {
		return 	wd.search(s, -1);
	}

	List<WordItem> wordList;
	@Override
	public void clickStartRecite(WordItem word, int num) {
		wordList = wd.search(word.getEn(), num);
		lastCorrect = null;
		nextReciteWord();
	}

	@Override
	public void clickStartReciteLast(int num) {
		WordItem w = wd.getLastWord();
		clickStartRecite(w,num);
	}

	@Override
	public void clickStartReciteDefault(int num) {
		List<WordItem> ls = wd.search("", -1);
		clickStartRecite(ls.get(0), num);
	}

	
	private Boolean lastCorrect = null;
	@Override
	public boolean nextReciteWord() {
		if(wordList.size()==0) {
			clickReturnMenu();
			return false;
		}
		WordItem wi = wordList.get(0);
		changPannel((JPanel) b.buildRecitePannel(wi, lastCorrect, wordList.size()-1));
		
		return true;
	}

	@Override
	public boolean checkRecite(String in) {
		WordItem wi = wordList.remove(0);
		lastCorrect = wi.check(in);
		return nextReciteWord();
	}

	@Override
	@Deprecated
	public void clickReturnConfig() {
		// TODO 自动生成的方法存根
	}

	@Override
	public String getStatistics() {
		Object[][] data = new Object[26][];
		for(int i = 0;i<26;i++){
			wd.setCurrentDatabase((char) (i+'a'));
			List<WordItem> wl = wd.search("", -1);
			int recited=0,correct=0;
			for(WordItem wi:wl){
				if(wi.getTimes()!= 0) recited++;
				if(wi.getCorrect()!= 0) correct++;
				
			}
			data[i] = new Object[]{(char)(i+'a')+" 词库",wl.size(),recited,correct, recited - correct,recited==0?0:((float)correct/recited)};
			
		}
		b.buildStatistics(data);
		return null;
	}


}
