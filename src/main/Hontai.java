package main;

import java.sql.SQLException;

public class Hontai {


	private ProductSelectPhase psp;
	private ActionSelectPhase asp;
	private AmountInputPhase aip;
	private OpenSelectPhase osp;
	private Zaiko zai;


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

	public void setza(Zaiko zai) {
		// TODO 自動生成されたメソッド・スタブ
		this.zai = zai;
	}


	//選択された商品の在庫数
	public int selectzaiko;

	//選択された商品ID
	int selected = 0;


	public void menuMain() throws SQLException {

	//trueな限りループ
	boolean flg = true;
	while (flg) {

		//行動選択
		SentakuComand temp = asp.Main();

		switch (temp) {
		//入金
		case PayIn:

			//商品選択されているか
			if (selected != 0) {

				//選択商品の在庫有無を確認
				int arunashi = zai.zaikoumu(selected);

				//在庫があった時
				if (arunashi == 0) {
					//商品の金額取得して入金へ
					aip.Main(selected);

					//DBの在庫数を減らす
					zai.herasu(selected);

					//開封画面へ
					osp.Main(selected);
				}

				//選択状態の解除
				selected = 0;

			}else {
				aip.ruikei();
			}
			break;

		//商品選択
		case Choose:

			//選択された商品番号
			selected = psp.main();

			//選択された商品の在庫数取得
			selectzaiko = psp.choizai(selected);

			if (selectzaiko<1) {
				System.out.println("売切れです");
				//選択状態の解除
				selected = 0;
			}

			break;

		//補充
		case InItem:

			//選択された商品ID
			selected = psp.main();

			//選択された商品の在庫数を任意の数増やす
			psp.fuyasu(selected);

			//選択状態の解除
			selected = 0;

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
