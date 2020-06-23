package 別物演習問題;

public class ManegementDisplay {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//商品(群)の生成
		Product tea = new Product("紅茶", 150, "英国紳士がよくキめてるやべーやつ。飲みすぎると英国面に堕ちる", "英国面に一歩近づいた気がする。");

		//商品選択へ
		ProductSelectPhase psp = new ProductSelectPhase();
		psp.Main(tea);

		//行動選択へ
		ActionSelectPhase asp = new ActionSelectPhase();
		Integer temp = asp.Main();
		switch(temp) {
			case 2 : main(args); break;
			case 9 : System.exit(0); break;
			default : ; break;
		}

		//金額入力へ
		AmountInputPhase aip = new AmountInputPhase();
		aip.Main(tea);

		//開封画面へ
		OpenSelectPhase osp = new OpenSelectPhase();
		osp.Main(tea);

		//最初に戻る
		main(args);
	}

}
