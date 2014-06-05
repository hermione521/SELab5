package wordData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import interfaces.WordDatabase;
import interfaces.WordItem;

public class MyWordDatabase implements WordDatabase {

	private static final long serialVersionUID = -6651456824394715211L;
	public static WordDatabase instance(String f) throws IOException{
		
		try {
			FileInputStream freader = new FileInputStream(f+".dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(freader);
			WordDatabase data = (MyWordDatabase) objectInputStream.readObject();  
			objectInputStream.close();
			return data;
		} catch (IOException | ClassNotFoundException e) {
			return new MyWordDatabase(f);
		}
	}
	
	
	
	private String name;
	private Map<Character,WordItem> lastword = new HashMap<Character,WordItem>();
	private ArrayList<WordItem> wordlist = new ArrayList<WordItem>();
	private char currentDatabase;
	private MyWordDatabase(String f) throws IOException{
		File file = new File(f);
		name = file.getName();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String data;
		while((data = br.readLine())!=null){
		     StringTokenizer st = new StringTokenizer(data);
		     WordItem word = new MyWordItem(st.nextToken(), st.nextToken());
		     wordlist.add(word);
		}
		br.close();
	}
	
	@Override
	public void save() {
		try {
			FileOutputStream outStream = new FileOutputStream("./" + name + ".dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
			objectOutputStream.writeObject(this);
			outStream.close(); 
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  
 
	}

	@Override
	public String getDatabaseName() {
		return name;
	}

	@Override
	public WordItem getLastWord() {
		WordItem ret = lastword.get(currentDatabase);
		if(ret == null) ret = search(currentDatabase+"",1).get(0);
		return ret;
	}

	@Override
	public void setCurrentDatabase(char c) {
		currentDatabase = c;
	}

	@Override
	public List<WordItem> search(String s, int num) {
		ArrayList<WordItem> ret = new ArrayList<WordItem>();
		
		if((Integer)num == null){
			int index = wordlist.indexOf(new MyWordItem(s, ""));
			for(int i = index;i<index+num && i<wordlist.size();i++){
				if(wordlist.get(i).startsWith(s)){
					ret.add(wordlist.get(i));
				}
			}
		}else{
			for(int i = 0;i<wordlist.size();i++){
				if(wordlist.get(i).startsWith(currentDatabase+"")){
					ret.add(wordlist.get(i));
				}
			}
		}
		
		return ret;
	}
}
