package main;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class TeaTest extends TestCase {

	@Test
	void testTea1() {
		Tea tea = new Tea("おちゃ", 0, "うまい", "うまい", 0);
        String cha = tea.getname();
        assertThat(cha, is("おちゃ"));
	    }

	@Test
	void testTea2() {
		Tea tea = new Tea("おちゃ", 0, "うまい", "うまい", 0);
        int okane = tea.getprice();
        assertThat(okane, is(150));
	    }
	@Test
	void testTea3() {
		Tea tea = new Tea("ちゃぁ", 0, "うまい", "うまい", 0);
		String syousai = tea.getdetail();
		assertThat(syousai, is("英国紳士の嗜み"));
	    }
	@Test
	void testTeaprice4() {
		Tea tea = new Tea("チャ", 0, "うまい", "うまい", 0);
        tea.getcomment();
        String t1 = tea.getcomment();
        assertThat(t1, is("英国面を感じる"));
	    }
	}

