package unitTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import wordData.MyWordItem;;

public class MyWordItemTest {

	private String english = "test";
	private String chinese = "测试";
	private String visual = "test::测试";
	private MyWordItem wordItem;
	
	@Before
	public void setUp(){
		wordItem = new MyWordItem(english, chinese);
		assertEquals(wordItem.getTimes(), 0);
		assertEquals(wordItem.getCorrect(), 0);
	}
	
	@Test
	public void getEnTest() {
		assertEquals(wordItem.getEn(), english);
	}
	
	@Test
	public void getChTest() {
		assertEquals(wordItem.getCh(), chinese);
	}

	@Test
	public void toStringTest() {
		assertEquals(wordItem.toString(), visual);
	}
	
	@Test
	public void equalsTest() {
		MyWordItem anotherItem = new MyWordItem(english, "另一个测试");
		assertEquals(wordItem.equals(anotherItem), true);
	}
	
	@Test
	public void startsWith() {
        assertEquals(wordItem.startsWith("t"), true);
        assertEquals(wordItem.startsWith("a"), false);
	}
	
	@Test
	public void checkAndTimesAndCorrectTest(){
		// origin value
		int oCorrect = wordItem.getCorrect();
		int oTimes = wordItem.getTimes();
		
		// check false
		boolean resF = wordItem.check("miao");
		assertEquals(resF, false);
		int fCorrect = wordItem.getCorrect();
		int fTimes = wordItem.getTimes();
		assertEquals(oCorrect, fCorrect);
		assertEquals(oTimes + 1, fTimes);
		
		// check true
		boolean resT = wordItem.check("test");
		assertEquals(resT, true);
		int tCorrect = wordItem.getCorrect();
		int tTimes = wordItem.getTimes();
		assertEquals(fCorrect + 1, tCorrect);
		assertEquals(fTimes + 1, tTimes);
	}

}
