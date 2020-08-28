package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductManagement {
	private ProductList productlist;
	int max;
	int selectNum;

	ProductManagement(){

	}

	public void setProductList(ProductList productlist) {
		this.productlist = productlist;
		this.max = productlist.total();
		return;
	}


	private int productnumLoop() {
		int Num;
		do {
			Num = this.imputNum();
		}while(this.checkNum(Num));
		return Num;

	}



	/**コンソールに入力されたものを処理する
	 * @return 入力された数字（数字以外が入力されると-1を返す）
	 */
	private int imputNum() {
		String input = null;
		int inputNum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			input = br.readLine();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
		}

		try {
			inputNum = Integer.valueOf(input);
		} catch (NumberFormatException e2) {
			// TODO 自動生成された catch ブロック
			inputNum = -1;
		}

		return inputNum;
	}

	/**有効な数字かどうかをチェックする
	 * @param beChecked
	 * @return true:無効な場合 false:有効な場合
	 */
	private boolean checkNum(int beChecked) {
		if(beChecked < 1 || max < beChecked) {
			System.out.print("商品の番号を入力してください:");
		}
		return beChecked < 1 || max < beChecked;
	}

	/** コンソールの番号入力を受け付けて、商品を返す。
	 * @return
	 */
	public Product searchProduct() {
		selectNum = this.productnumLoop();
		Product selected = productlist.getProduct(selectNum);
		return selected;
	}



}
