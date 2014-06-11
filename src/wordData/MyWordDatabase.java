package wordData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import interfaces.WordDatabase;
import interfaces.WordItem;

public class MyWordDatabase implements WordDatabase {

	private static final long serialVersionUID = -6651456824394715211L;
	private String name;

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
	
	private Map<String,WordItem> lastword = new HashMap<String,WordItem>();
	private Map<String,List<WordItem>> wordlists = new HashMap<String,List<WordItem>>();
	private String currentDatabase;
	
	private MyWordDatabase(String f) throws IOException{
		File file = new File(f);
		name = file.getName();
		//TODO
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
		String data;
		while((data = br.readLine())!=null){
		     StringTokenizer st = new StringTokenizer(data);
		     WordItem word = new MyWordItem(st.nextToken(), st.nextToken());
		     String type = word.getTypes();
		     if(wordlists.get(type)==null) wordlists.put(type,new ArrayList<WordItem>());
		     wordlists.get(type).add(word);
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
		if(ret == null) ret = search(currentDatabase+"",-1).get(0);
		return ret;
	}

	@Override
	public void setLastWord(WordItem wi) {
		lastword.put(currentDatabase, wi);		
	}
	@Override
	public void setCurrentDatabase(String s) {
		currentDatabase = s;
	}
	@Override
	public String getCurrentDatabase() {
		return currentDatabase;
	}

	@Override
	public List<WordItem> search(String s, int num) {
		ArrayList<WordItem> ret = new ArrayList<WordItem>();
		List<WordItem> wordlist = wordlists.get(currentDatabase);
		if(wordlist==null) return ret;
		
		if((Integer)num != -1){
			int index = wordlists.get(currentDatabase).indexOf(new MyWordItem(s, ""));
			for(int i = index;i<index+num && i<wordlist.size();i++){
				ret.add(wordlist.get(i));
			}
		}else{
			for(int i = 0;i<wordlist.size();i++){
				if(wordlist.get(i).startsWith(s)){
					ret.add(wordlist.get(i));
				}
			}
		}
		return ret;
	}

	@Override
	public String[] getAllDataBase() {
		Set<String> set = wordlists.keySet();
		String[] ret = new String[set.size()];
		int i=0;
		for(String s:set){
			ret[i++] = s;
		}
		return ret;
	}
}
