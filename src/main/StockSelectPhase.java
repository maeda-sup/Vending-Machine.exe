package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class StockSelectPhase {

	boolean back = false;
	DBAccess productlist;  //メインじゃないけどこっちのクラスでもDBAccessをつかいたい！→×もう一つここでオブジェクト作る
	                       //→◎productlist（オブジェクト名）を定義→productlistにDBAccessをセットするだけのメソッドを追加する
	                       //テキトーにこの辺の白いところ（クラスのフィールドのなか）で右クリック→ソース→getterおよびsetterの生成→で、自動生成できる！


		public void setProductlist(DBAccess productlist) {                //これ増やした
		this.productlist = productlist;
	}

	public void  main(int stock,int selectnum){           //stockをかえしてた？☆void,selectnum増やした



		System.out.println("");
		System.out.println("選択された商品は品切れです");
		System.out.println("在庫を補充しますか？");
		System.out.println("--------------------");
		System.out.println("|1|在庫を補充する");
		System.out.println("|2|商品選択に戻る");
		System.out.println("--------------------");
		System.out.println("");

		Stockselect(stock,selectnum);
	}

		public void Stockselect(int stock,int selectnum) {           //☆void

			//商品選択入力受付
			int snum = 0;

			do {
				snum = Actextracted();

			}while(isActextracted(snum));

			Bunki(snum,stock,selectnum);         //☆void　snum(選択された番号)とstock(
		}

		private boolean isActextracted(int snum) {
			// 1か2が選択されたかどうか
			return snum < 1 || 2 < snum;
		}

		private int Actextracted() {
			//数字出ないものをはじく。1もしくは2が入力されるまでループ
			int snum = 0;
			String input;
			System.out.print("行動を選択してください:");
			System.out.println("");
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			snum = Integer.valueOf(input);
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("数字で入力してください");
				snum = 0;
			}
			return snum;

		}


		private void Bunki(int snum,int stock,int selectnum)  {      //☆void,selectnum

			if(snum == 1) {

				System.out.println("選択された商品の在庫を補充しました。");

				try {
					productlist.stockupdate1(selectnum);
				} catch (SQLException e) {
					// ☆SQLE を上につけるよりtrycatchでかこめ
					e.printStackTrace();
				}
//				return stock + 1;　☆
			}

				this.back = true;
//			return stock;　☆
		}

		public boolean backWhich() {
			return back;

		}

}
