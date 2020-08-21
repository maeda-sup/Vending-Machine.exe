package main;

public class Hontai {


	private ProductSelectPhase psp;
	private ActionSelectPhase asp;
	private AmountInputPhase aip;
	private OpenSelectPhase osp;


	public void setps(ProductSelectPhase psp) {
		// TODO 自動生成されたメソッド・スタブ
		this.psp = psp;
	}

	public void setas(ActionSelectPhase asp) {
		// TODO 自動生成されたメソッド・スタブ
		this.asp = asp;
	}

	public void setai(AmountInputPhase aip) {
		// TODO 自動生成されたメソッド・スタブ
		this.aip = aip;
	}

	public void setos(OpenSelectPhase osp) {
		// TODO 自動生成されたメソッド・スタブ
		this.osp = osp;
	}


	Zaiko zai = new Zaiko();
	//選択された商品の在庫情報
	public Zaiko selectzaiko;

	//選択された商品ID
	int selected = 0;


	public void menuMain() {

	//trueな限りループ
	boolean flg = true;
	while (flg) {

		//行動選択
		SentakuComand temp = asp.Main();

		switch (temp) {
		//入金
		case PayIn:

			if (selected != 0) {
				//商品の金額取得して入金へ
				aip.Main(selected);

				//開封画面へ
				osp.Main(selected);

			}else {
				aip.ruikei();
			}
			break;

		//商品選択
		case Choose:

			//選択された商品ID
			selected = psp.main();

			//選択された商品の在庫情報取得
			selectzaiko = psp.zaiko(selected);

			if (selectzaiko.getNokori()<1) {
				System.out.println("売切れです");
			}

			break;

		//補充
		case InItem:

			//選択された商品ID
			selected = psp.main();

			//選択された商品の在庫情報取得
			selectzaiko = psp.zaiko(selected);

			//在庫数を任意の数増やす
			selectzaiko.fuyasu();

			break;

		//終了
		case Exit:
			flg = false;

			System.out.println("ご利用ありがとうございました。");
			System.out.println("またのご利用をお待ちしております。");

			break;
		default:
			;
			break;
		}

	}

}

}
