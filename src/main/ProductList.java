
package main;
import java.util.ArrayList;

public class ProductList {

	private ArrayList<Shohin> productlist;
	private int i = 1;

	ProductList(){
		this.productlist = new ArrayList<Shohin>();
		productlist.add(new Tea("おっちゃ"));

	}

	public void showlist() {
		for(Shohin shohin: productlist) {
			System.out.println("|"+ i +"|"+shohin.getname()+"|"+ shohin.getprice() + "円");
			i++;
		}
	}

	public Shohin shohinout(int shohinnum) {

		Shohin shohin = productlist.get(shohinnum -1);

		return shohin;
	}


}
