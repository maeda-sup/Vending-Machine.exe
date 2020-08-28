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

	/**コンソールからの入力の受付
	 * @return 入力された数字(文字の場合は-1)
	 */
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
			inputNum = -1;
		}

		return inputNum;
	}

	/** 0以上の数字が入ってきたかの確認
	 * @param checknum
	 * @return true:負の数・文字が入力された場合 false:0以上の数字が入力された場合
	 */
	private boolean checkNumToAdd(int checknum) {
		return checknum < 0;
	}

	/**補充する個数の入力受付
	 * @return 0以上の数字
	 */
	private int getNumToAdd() {
		int numToAdd = 0;
		do {
			numToAdd = this.inputNum();
			this.showErrorMessage(numToAdd);
		}while(this.checkNumToAdd(numToAdd));
		return numToAdd;
	}

	/**補充する商品の番号の受付
	 * @return 商品リストにある商品番号
	 */
	private int getProductNum() {
		int productNum = 0;
		do {
			productNum = this.inputNum();
			if(this.checkProductNum(productNum)) {
				System.out.print("補充したい商品の番号を入力してください:");
			}
		}while(this.checkProductNum(productNum));
		return productNum;
	}

	/**入力が商品番号かのチェック
	 * @param setted
	 * @return true:商品番号ではない場合 false:商品番号の場合
	 */
	private boolean checkProductNum(int setted) {
		int max = productlist.total();
		// TODO 自動生成されたメソッド・スタブ
		return setted < 0 || max < setted;
	}

	/**0以上の数字ではない値が入力された場合、メッセージを表示する
	 * @param settedNum
	 */
	private void showErrorMessage(int settedNum) {
		// TODO 自動生成されたメソッド・スタブ
		if(this.checkNumToAdd(settedNum)) {
			System.out.println("商品が補充できません！");
		}
	}

	/**在庫管理の一連の流れ
	 * @return
	 */
	public boolean manageStock() {
		productlist.showStocks();
		System.out.print("補充するものを選んでください:");
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
