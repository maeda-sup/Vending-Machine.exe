package test;

public class Main {

	ProductList productlist = new ProductList();

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Main main = new Main();

		//商品リスト表示
		main.showProductList();





	}

	public void showProductList() {
		//商品の追加
		productlist.addProduct(new Tea("紅茶:ダージリン"));
		productlist.addProduct(new Tea("紅茶:アールグレイ"));

		//商品情報提示
		productlist.showInfo();
		System.out.print("商品を選択してください:");

	}

	public Product selectProduct(int input) {
		//商品検索
		return productlist.searchProduct(input);

	}


}
