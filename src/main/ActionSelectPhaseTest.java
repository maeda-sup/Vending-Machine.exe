package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ActionSelectPhaseTest {

	private ActionSelectPhase asp;

	@Before
	public void setUp() {
		asp = new ActionSelectPhase();
	}

	@Test
	public void 入金選択() {
		setUp();
		SentakuComand bnum = asp.Main();

		assertEquals(SentakuComand.PayIn, bnum);
	}

	@Test
	public void 商品選択() {
		setUp();
		SentakuComand cnum = asp.Main();
		assertEquals(SentakuComand.Choose, cnum);
	}

	@Test
	public void 補充() {
		setUp();
		SentakuComand cnum = asp.Main();
		assertEquals(SentakuComand.InItem, cnum);
	}

	@Test
	public void やめる() {
		setUp();
		SentakuComand dnum = asp.Main();
		assertEquals(SentakuComand.PayIn, dnum);
	}


}
