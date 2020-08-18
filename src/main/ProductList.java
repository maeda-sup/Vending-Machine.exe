
package main;
import java.util.ArrayList;

public class ProductList {

	private ArrayList<Shohin> productlist;

	//リスト追加
	ProductList(){
		this.productlist = new ArrayList<Shohin>();
		productlist.add(new Tea("アールグレイ"));
		productlist.add(new Tea("ダージリン"));
		productlist.add(new Tea("セイロンティー"));
	}


	/**
	 * リスト表示
	 */
	public void showlist() {
		String zaiko;//売切文言
		int i = 1;//カウンタ＝商品番号
		//商品の数だけループ
		for(Shohin shohin: productlist) {
			//在庫数の取得
			int zan = shohin.getnokori();
			//在庫が0以下なら売切表示を追加
			if (zan < 1) {
				zaiko = "|売切";
			}else {
				zaiko = "";
			}
			//リストの表示
			System.out.println("|"+ i +"|"+shohin.getname()+"|"+ shohin.getprice() + "円"+ zaiko);
			i++;
		}
	}

	/**
	 * 選択した商品の番号を取得
	 * @param price
	 * @return shohin
	 */
	public Shohin shohinout(int shohinnum) {

		Shohin shohin = productlist.get(shohinnum -1);

		return shohin;
	}

	/**
	 * リストの要素数を返す
	 * @return productlist.size()
	 */
	public int total() {
		return productlist.size();//リストの要素数を返す
	}
}
