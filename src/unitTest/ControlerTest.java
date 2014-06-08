package unitTest;

import static org.junit.Assert.*;
import java.util.List;
import impl.Controler;
import interfaces.WordItem;
import org.junit.Test;

public class ControlerTest {

	Controler controler = new Controler();

	@Test
	public void clickStartConfigTest() {
		controler.clickStartConfig("abc");
		char c = controler.getWd().getCurrentDatabase();
		assertEquals(c, 'a');
		
		controler.clickStartConfig("bcd");
		c = controler.getWd().getCurrentDatabase();
		assertNotEquals(c, 'a');
	}
	
	@Test
	public void inputTextTest() {
		List<WordItem> l = controler.inputText("abandon");
		for (WordItem w : l) {
			assertEquals(w.getEn(), "abandon");
		}
		
		l = controler.inputText("abcdefg");
		assertEquals(l.size(), 0);
	}
}
