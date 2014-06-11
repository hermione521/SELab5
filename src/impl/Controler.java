package impl;

import java.io.IOException;
import java.text.DecimalFormat;
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
		try {
			wd = MyWordDatabase.instance("dictionary.txt");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"未发现词库");  
			this.exitProgramme();
		}
		
		b.buildConfigPannel();
		mf = b.buildJframe();
		cp = b.buildConfigPannel();
		mp = b.buildMenuPannel(wd.getAllDataBase());
		
		changPannel((JPanel) mp);

		
	}
	
	private void changPannel(JPanel p){
		mf.setContentPane(p);
		mf.revalidate();
	}
	
	@Override
	public void exitProgramme() {
		wd.save();
		System.exit(0);
	}

	@Override
	public void clickStartConfig(int index) {
		wd.setCurrentDatabase(wd.getAllDataBase()[index]);
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
	int wlsize,correctNum;
	char wdCurrent;
	@Override
	public void clickStartRecite(WordItem word, int num) {
		wordList = wd.search(word.getEn(), num);
		lastCorrect = null;
		
		wlsize = wordList.size();
		correctNum=0;
		wdCurrent = word.getEn().charAt(0);
		
		nextReciteWord();
	}

	@Override
	public void clickStartReciteLast(int num) {
		WordItem w = wd.getLastWord();
		List<WordItem> wl = wd.search(w.getEn(), 2);

		if(wl.size()==2) clickStartRecite(wl.get(1),num);
		else clickStartReciteDefault(num);
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
			
			String statistics = " 所选词库:"+wdCurrent+"\n"
							  + "所选单词数:"+wlsize+"个\n"
							  + "正确单词数:"+correctNum+"个\n"
							  + "错误单词数:"+(wlsize-correctNum)+"个\n"
							  + "  正确率:"+new DecimalFormat("0.00").format((float)correctNum/wlsize*100)+"%";
			JOptionPane.showMessageDialog(null, statistics);
			
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
		wd.setLastWord(wi);
		lastCorrect = wi.check(in);
		if(lastCorrect)correctNum++;
		return nextReciteWord();
	}

	@Override
	public String getStatistics() {
		
		//TODO
		String[] databases = wd.getAllDataBase();
		Object[][] data = new Object[databases.length+1][];
		int totalRecited = 0,totalCorrect = 0,totalWord=0;;
		for(int i = 0;i<databases.length;i++){
			wd.setCurrentDatabase(databases[i]);
			List<WordItem> wl = wd.search("", -1);
			int recited=0,correct=0;
			for(WordItem wi:wl){
				if(wi.getTimes()!= 0) recited++;
				if(wi.getCorrect()!= 0) correct++;
			}
			data[i] = new Object[]{databases[i]+" 词库",wl.size(),recited,correct, recited - correct,recited==0?0:((float)correct/recited)};
			totalRecited+=recited;
			totalCorrect+=correct;
			totalWord+=wl.size();
		}
		data[databases.length] = new Object[]{ "词库总计",totalWord,totalRecited,totalCorrect, totalRecited - totalCorrect,totalRecited==0?0:((float)totalCorrect/totalRecited)};
//		
		b.buildStatistics(data);
		return null;
	}

	public WordDatabase getWd() {
		return wd;
	}


}
