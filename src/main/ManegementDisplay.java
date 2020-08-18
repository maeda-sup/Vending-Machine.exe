package main;

public class ManegementDisplay {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//商品(群)の生成
		ProductList productlist = new ProductList();

		//商品選択OBJ作成
		ProductSelectPhase psp = new ProductSelectPhase();

		//行動選択OBJ作成
		ActionSelectPhase asp = new ActionSelectPhase();

		//金額入力OBJ作成
		AmountInputPhase aip = new AmountInputPhase();

		//商品選択されたときに入る商品オブジェクトの準備
		Shohin selected = null;

		//trueな限りループ
		boolean flg = true;
		while (flg) {

			//行動選択
			SentakuComand temp = asp.Main();

			switch (temp) {
			//入金
			case PayIn:

				if (selected != null) {
					//商品の金額取得して入金へ
					int amount = selected.getprice();
					aip.Main(amount);

					//買った商品名
					System.out.println(selected.getname() + "が出た");

					//開封画面へ
					OpenSelectPhase osp = new OpenSelectPhase();
					String detail = selected.getdetail();
					String comment = selected.getcomment();
					osp.Main(detail, comment);

					if(selected.getnokori() > 0) {
						//在庫数を-１
						selected.herasu();

					}else
						System.out.println("売切れです");

				}else {
					aip.ruikei();
				}
				break;

			//商品選択
			case Choose:

				//リスト表示
				productlist.showlist();

				//リストの要素数
				int total = productlist.total();

				//選択された商品番号
				int selectnum = psp.Main(total);

				//選択された商品オブジェクト
				selected = productlist.shohinout(selectnum);

				if (selected.getnokori()<1) {
					System.out.println("売切れです");
				}

				break;

			//補充
			case InItem:
				//在庫数を任意の数増やす
				selected.fuyasu();

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
