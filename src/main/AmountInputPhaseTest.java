package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class AmountInputPhaseTest {

	private AmountInputPhase aip;

	@Before
	public void setup() {
		aip = new AmountInputPhase();
	}

	@Test
	public void 入金() {
		setup();
		int tonyu = aip.hikaku(150);
		assertEquals(150, tonyu);

	}

}
