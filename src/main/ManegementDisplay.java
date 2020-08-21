
package main;

public class ManegementDisplay {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//商品(群)の生成
		DBAccess productlist = new DBAccess();         //productlist作る
		productlist.connectDB();

		boolean flg = true;                                 //boolean型flgを作った
		while (flg) {                                        //ループ

			productlist.showlist();                           //productlistのshowlist呼び出し

			int total = productlist.total();                //int型のtotalにproductlistのtotalを入れる


			//商品選択へ
			int stock;
			Product selected;

				ProductSelectPhase psp = new ProductSelectPhase();           //productselectphase作る

				psp.setMax(total);

				int selectnum = psp.Main();                                 //intのselectnumにproductselectphaseのmainを入れる

				selected = productlist.shohinout(selectnum);         //Shohin型のxelectedにproductlistのshohinoutを入れる。selectnumを持っていく。

				StockSelectPhase ssp = new StockSelectPhase();

				stock = selected.getStock();

			if(stock < 1) {
				ssp.main();

//				if( selected  instanceof Juice) {
//					Juice juice = (Juice)selected;
//					juice.stockUpdate(stock);
//				}
//				else if(selected instanceof Tea) {
//					Tea tea = (Tea)selected;
//					tea.stockUpdate(stock);
//				}
//
				boolean back = ssp.backWhich();

				if(back == true) {
				continue;
				}

			}


			//行動選択へ
			ActionSelectPhase asp = new ActionSelectPhase();            //actionselectphaseを作る
			Integer temp = asp.Main();                                  //integer型のtempにactionselectphaseのメインを入れる。
			switch (temp) {                                             //switch文
			case 1:
				//金額入力へ
				AmountInputPhase aip = new AmountInputPhase();          //1が選ばれたら、amountinputfhaseをつくる

				int amount = selected.getprice();                      //int型のamountにshohin型のselectedのgetpriceを入れる
				stock = aip.Main(amount,stock);                                       //aipのmainに入れる.stockを1減らして持って帰る

//				selected.stockUpdate(stock);
				// キャスト
				if( selected  instanceof Juice) {
					Juice juice = (Juice)selected;
					juice.stockUpdate(stock);
				}
				else if(selected instanceof Tea) {
					Tea tea = (Tea)selected;
					tea.stockUpdate(stock);

				}

				//開封画面へ
				OpenSelectPhase osp = new OpenSelectPhase();           //openselectphaseを作る

				String detail = selected.getdetail();                  //string型のdetailにselectedのgetdetailを入れる
				String comment = selected.getcomment();                //string型のdetailにselectedのgetdetailを入れる
				osp.Main(detail, comment);                             //openselectphaseのmainにdetailとcommentを持っていく？？？
				break;
			case 2:
				continue;                                            //2が選ばれたら、ループ最初へ戻る。
			case 9:
				flg = false;                                         //9が選ばれたら、終わる
				break;
			default:                                                //他の数字ならもう一回聞く？？？？？
				;
				break;
			}

		}

	}

}
