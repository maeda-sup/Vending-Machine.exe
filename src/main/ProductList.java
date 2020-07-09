
package main;
import java.util.ArrayList;

public class ProductList {

	private ArrayList<Shohin> productlist;


	ProductList(){
		this.productlist = new ArrayList<Shohin>();
		productlist.add(new Tea("アールグレイ"));
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
