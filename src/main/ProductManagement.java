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

	private boolean checkNum(int beChecked) {
		return beChecked < 1 || max < beChecked;
	}

	public Product searchProduct() {
		selectNum = this.productnumLoop();
		Product selected = productlist.getProduct(selectNum);
		return selected;
	}

	

}
