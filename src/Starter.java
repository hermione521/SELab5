import impl.Controler;
import interfaces.PannelBuilder;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.main.MyPannelBuilder;


public class Starter {


	public static void main(String[] args) throws Exception{
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
        UIManager.put("RootPane.setupButtonVisible",new Boolean (false));
		org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		
		new Controler();
		
//		PannelBuilder builder = new MyPannelBuilder(null);
//		JFrame jf = builder.buildJframe();
//		jf.setContentPane((Container) builder.build(new String[]{"a","a","a","a","a","a"}));
//		jf.setContentPane((Container) builder.buildConfigPannel());
//		jf.setContentPane((Container) builder.build((WordItem)null, true, 1));
//		jf.revalidate();

//		WordDatabase wd = MyWordDatabase.instance("dictionary.txt");
//		wd.save();
	}

}
