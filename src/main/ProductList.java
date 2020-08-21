
package main;
import java.util.ArrayList;

public class ProductList {

	public ArrayList<Shohin> productlist;


	ProductList(){
		this.productlist = new ArrayList<Shohin>();
		productlist.add(new Tea("おっちゃ",150,"英国紳士の嗜み","英国面を感じる",1));
		productlist.add(new Tea("紅茶",100,"アールグレイ茶砂糖入り","果実のいい香り！",2));
		productlist.add(new Juice("コーラ",120,"ペプシコーラ","ポテチもたべたい",3));

	}

	public void showlist() {
		int i = 1;
		for(Shohin shohin: productlist) {
			System.out.println("|"+ i +"|"+shohin.getname()+"|"+ shohin.getprice() + "円");
			i++;
		}
	}

	/**
	 * @param shohinnum
	 * @return
	 */
	public Shohin shohinout(int shohinnum) {

		Shohin shohin = productlist.get(shohinnum -1);

		return shohin;
	}

	public int total() {
		return productlist.size();
	}
}
