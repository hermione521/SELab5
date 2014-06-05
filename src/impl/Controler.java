package impl;

import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ui.main.MyPannelBuilder;
import wordData.*;
import interfaces.*;

public class Controler implements UiActions {
	PannelBuilder b = new MyPannelBuilder(this);
	ConfigPannel cp;
	MenuPannel mp;
	JFrame mf;
	
	WordDatabase wd;
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
	
	void changPannel(JPanel p){
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
//		JOptionPane.showMessageDialog(null,"退出程序");  
		wd.save();
		System.exit(0);
	}

	@Override
	public void clickStartConfig(String worddata) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void clickReturnMenu() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public List<WordItem> inputText(String s) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void clickStartRecite(String word, int num) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void clickStartReciteLast(int num) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void clickStartReciteDefault(int num) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean nextReciteWord() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean checkRecite(String in) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void clickReturnConfig() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getStatistics() {
		// TODO 自动生成的方法存根
		return null;
	}


}
