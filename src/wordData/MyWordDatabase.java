package wordData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import interfaces.WordDatabase;
import interfaces.WordItem;

public class MyWordDatabase implements WordDatabase {

	private static final long serialVersionUID = -6651456824394715211L;
	private String name;

	public static WordDatabase instance(String f) throws IOException, SAXException, ParserConfigurationException{
		
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
	
	private MyWordDatabase(String f) throws IOException, SAXException, ParserConfigurationException{
		File file = new File(f);
		name = file.getName();
		SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();  
        parser.parse(file, new DefaultHandler(){
        	private String en,ch;
        	private int tag=TAG_NONE;
        	public static final int TAG_NONE=-1;
        	public static final int TAG_EN=0;
        	public static final int TAG_CH=1;
			@Override
			public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
				switch(tag){
				case TAG_EN:en=new String(arg0).substring(arg1,arg1+arg2);tag=TAG_NONE;break;
				case TAG_CH:ch=new String(arg0).substring(arg1,arg1+arg2);tag=TAG_NONE;break;
				}
			}

			@Override
			public void endElement(String arg0, String arg1, String qName) throws SAXException {
				if (qName.equalsIgnoreCase("word")) {
					WordItem wi = new MyWordItem(en, ch);
					String type = wi.getTypes();
					if (wordlists.get(type) == null) wordlists.put(type, new ArrayList<WordItem>());
					List<WordItem> list = wordlists.get(type);
					list.add(wi);
				}

			}

			@Override
			public void startElement(String arg0, String arg1, String qName, Attributes arg3) throws SAXException {
				if(qName.equalsIgnoreCase("word")){
					en=null;ch=null;
				}else if(qName.equalsIgnoreCase("english")){
					tag = TAG_EN;
				}else if(qName.equalsIgnoreCase("chinese")){
					tag = TAG_CH;
				}
			}
        	
        });;
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
