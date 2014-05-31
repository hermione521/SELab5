import impl.Controler;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;


public class Starter {


	public static void main(String[] args) throws Exception{
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
        UIManager.put("RootPane.setupButtonVisible",new Boolean (false));
		org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		
		new Controler();
	}

}
