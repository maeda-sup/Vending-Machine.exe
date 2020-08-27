package main;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class ProductSelectPhaseTest {

//	 private StandardOutputStream out = new StandardOutputStream();
//	 private StandardInputStream in = new StandardInputStream();

	 @Before
	    public void before() {
//	        System.setOut(out);
//	        System.setIn(in);
	    }

	    @After
	    public void after() {
//	        System.setOut(null);
//	        System.setIn(null);
	    }

	@Test
	void test1() {
		ProductSelectPhase PSP = new ProductSelectPhase();         //このクラスの（クラス指定コード）
		PSP.setMax(3);
		boolean t1 = PSP.isExtracted(1);                          //このメソッド（メソッド指定コード)。そしてメソッドの引数が1の場合
		assertThat(t1, is(false));                              //whileは()の中がtrue,他がfalse。pnum=1の場合にループを抜けたいから、false。
//		fail("まだ実装されていません");
	}
	@Test
	void test4() {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(3);
		boolean t1 = PSP.isExtracted(0);

		assertThat(t1, is(true));
//		fail("まだ実装されていません");
	}
	@Test
	void test2() {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(3);                                             //最大値maxが3の場合のテスト
		boolean t1 = PSP.isExtracted(4);                         //4が引数で入ってきた場合

		assertThat(t1, is(true));                               //ループを続けるtrue
//		fail("まだ実装されていません");
	}

	@Test
	void test3() {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(3);
		boolean t1 = PSP.isExtracted(3);

		assertThat(t1, is(false));
//		fail("まだ実装されていません");
	}

	@Test
	void test5() {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(3);
		boolean t1 = PSP.isExtracted(2);

		assertThat(t1, is(false));
//		fail("まだ実装されていません");
	}

	@Test
	void testsetMax1マックスが0以下の時に値を1で固定 () throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(-1);                                                  //戻り値がないメソッドのテスト　max＝-2

		Field field = PSP.getClass().getDeclaredField("max");      //private変数をとってきたい時。フィールド変数がプライベート変数だけど、テストの前提でここの値の設定をしたい
	        // private変数へのアクセス制限を解除	                //↓
	        field.setAccessible(true);                             //↓
	        Integer value = (Integer) (field.get(PSP));            //ここまでだいたい定型文

	        Integer testValue=1;                                  //this.maxがどの値になっていればいいのか。ここではmaxが0以下で入ってきたから、1になるはず。
	        assertThat(value, is(testValue) );                   //assertは判定するよっていう言葉。いろんな種類がある。
	}
	@Test
	void testsetMax2マックスが0以下の時に値を1で固定 () throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(0);

		Field field = PSP.getClass().getDeclaredField("max");
	        field.setAccessible(true);
	        Integer value = (Integer) (field.get(PSP));

	        Integer testValue=1;
	        assertThat(value, is(testValue) );
	 }
	@Test
	void testsetMax3マックスが0以下の時に値を1で固定 () throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(1);

		Field field = PSP.getClass().getDeclaredField("max");
	        field.setAccessible(true);
	        Integer value = (Integer) (field.get(PSP));

	        Integer testValue=1;
	        assertThat(value, is(testValue) );
	}
	@Test
	void testsetMax4マックスが0以下の時に値を1で固定 () throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(2);

		Field field = PSP.getClass().getDeclaredField("max");
	        field.setAccessible(true);
	        Integer value = (Integer) (field.get(PSP));

	        Integer testValue=2;
	        assertThat(value, is(testValue) );
	}

		@Test
	void testsetMax5マックスが0以下の時に値を1で固定 () throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ProductSelectPhase PSP = new ProductSelectPhase();
		PSP.setMax(3);

		Field field = PSP.getClass().getDeclaredField("max");
	        field.setAccessible(true);
	        Integer value = (Integer) (field.get(PSP));

	        Integer testValue=3;
	        assertThat(value, is(testValue) );
	}
		@Test
		void testextracted1() {
			ProductSelectPhase PSP = new ProductSelectPhase();
//			in.inputln("3");
			int t1 = PSP.extracted();
			//"a"を入力

			assertThat(t1, is(0));                 //”数字を入力してください”表示

//			assertThat(t1, is(false));
//			fail("まだ実装されていません");
		}

		@Test
		void testextracted2() {
			ProductSelectPhase PSP = new ProductSelectPhase();
			int t1 = PSP.extracted();
			//"あ"を入力

			assertThat(t1, is(0));                 //”数字を入力してください”表示
		}

		@Test
		void testextracted3() {
			ProductSelectPhase PSP = new ProductSelectPhase();
			int t1 = PSP.extracted();
			//"1"を入力

			assertThat(t1, is(0));                 //”数字を入力してください”表示 失敗
		}
		@Test
		void testextracted4() {
			ProductSelectPhase PSP = new ProductSelectPhase();
			int t1 = PSP.extracted();
			//"1"を入力

			assertThat(t1, is(1));
		}
		@Test
		void testextracted5() {
			ProductSelectPhase PSP = new ProductSelectPhase();
			int t1 = PSP.extracted();
			//"a"を入力

			assertThat(t1, is(1));                 //失敗
		}
		@Test
		void testextracted6() {
			ProductSelectPhase PSP = new ProductSelectPhase();
			int t1 = PSP.extracted();
			//"あ"を入力

			assertThat(t1, is(1));                 //失敗
		}
		@Test
		void testextracted7() {
			ProductSelectPhase PSP = new ProductSelectPhase();
			int t1 = PSP.extracted();
			//"1"を入力

			assertThat(t1, is(1));
		}



}
