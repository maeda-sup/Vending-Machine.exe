package main;

public class ManegementDisplay {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//商品(群)の生成
		ProductList productlist = new ProductList();





		boolean flg = true;
		while (flg) {

			productlist.showlist();

			int total = productlist.total();


			//商品選択へ
			ProductSelectPhase psp = new ProductSelectPhase();

			int selectnum = psp.Main(total);

			Shohin selected = productlist.shohinout(selectnum);
			//行動選択へ
			ActionSelectPhase asp = new ActionSelectPhase();
			Integer temp = asp.Main();
			switch (temp) {
			case 1:
				//金額入力へ
				AmountInputPhase aip = new AmountInputPhase();

				int amount = selected.getprice();
				aip.Main(amount);
				//開封画面へ
				OpenSelectPhase osp = new OpenSelectPhase();

				String detail = selected.getdetail();
				String comment = selected.getcomment();
				osp.Main(detail, comment);
				break;
			case 2:
				continue;
			case 9:
				flg = false;
				break;
			default:
				;
				break;
			}

		}

	}

}
