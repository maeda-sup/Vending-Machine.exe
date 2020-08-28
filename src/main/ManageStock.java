package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManageStock {

	private ProductList productlist;
	private Product product;
	private StockDao sDao;

	public void setsDao(StockDao sDao) {
		this.sDao = sDao;
	}

	public void setProductList(ProductList plist) {
		productlist = plist;
		return;
	}

	private int inputNum() {
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
			inputNum = 0;
		}

		return inputNum;
	}

	private boolean checkNumToAdd(int checknum) {
		return checknum <= 0;
	}

	private int getNumToAdd() {
		int numToAdd = 0;
		do {
			numToAdd = this.inputNum();
			this.showErrorMessage(numToAdd);
		}while(this.checkNumToAdd(numToAdd));
		return numToAdd;
	}

	private int getProductNum() {
		int productNum = 0;
		do {
			productNum = this.inputNum();
		}while(this.checkProductNum(productNum));
		return productNum;
	}

	private boolean checkProductNum(int setted) {
		int max = productlist.total();
		// TODO 自動生成されたメソッド・スタブ
		return setted < 0 || max < setted;
	}

	private void showErrorMessage(int settedNum) {
		// TODO 自動生成されたメソッド・スタブ
		if(this.checkNumToAdd(settedNum)) {
			System.out.println("商品が補充できません！");
		}
	}

	public boolean manageStock() {
		productlist.showStocks();
		System.out.print("補充するものを選んでください。");
		int temp = this.getProductNum();
		if(temp == 0) {
			return false;
		}
		product = productlist.getProduct(temp);
		if(sDao.isFull(product.getId())) {
			System.out.println("満タンです。補充できません。");
			return true;
		}
		this.askNumToAdd();
		temp = this.getNumToAdd();
		if(sDao.getStock(product.getId()) + temp > sDao.getMaxStock(product.getId())) {
			int over = sDao.getStock(product.getId()) + temp - sDao.getMaxStock(product.getId());
			sDao.addToMax(product.getId());
			System.out.println("補充しました。" + over + "個の商品が余りました。");
		}else {
			sDao.addStock(product.getId(), temp);
			System.out.println("補充しました。");
		}
		return true;
	}



	private void askNumToAdd() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.print("何個補充しますか？");
	}


}
