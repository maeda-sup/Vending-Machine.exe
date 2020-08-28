package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingSystem {

	private boolean flg = true;
	private ProductList productlist;
	private StockDao sDao;
	private ProductManagement pm = new ProductManagement();
	private MoneyDao mDao;
	private ManageStock ms;

	public void setmDao(MoneyDao mDao) {
		this.mDao = mDao;
	}

	public void setsDao(StockDao sDao) {
		this.sDao = sDao;
	}

	public void selectFunction() {
		productlist.makeList();
		switch(buyORstock()) {
		case "BUY":
			this.buyLoop();
			break;
		case "STOCK":
			this.stockLoop();
			break;
		}


	}

	public void setProductlist(ProductList productlist) {
		this.productlist = productlist;
	}

	private void buyLoop() {
		pm.setProductList(productlist);
		while(flg) {
			flg = buyProduct();
		}
	}

	private boolean buyProduct() {
		productlist.showlist();
		Product selected = pm.searchProduct();
		if(sDao.getStock(selected.getId()) == 0) {
			System.out.println("売り切れです");
			return true;
		}

		ActionSelectPhase asp = new ActionSelectPhase();
		Integer temp = asp.Main();
		switch (temp) {
		case 1:
			//金額入力へ
			AmountInputPhase aip = new AmountInputPhase();
			aip.setmDao(mDao);

			int amount = selected.getPrice();
			aip.Main(amount);

			sDao.reduceStock(selected.getId());
			mDao.reduceMoney(selected.getPrice());

			//開封画面へ
			OpenSelectPhase osp = new OpenSelectPhase();

			String detail = selected.getDetail();
			String comment = selected.getComment();
			osp.Main(detail, comment);
			flg = wannaContinue();
			break;
		case 2:
			break;
		case 9:
			flg = false;
			break;
		default:
			;
			break;
		}
		return flg;
	}

	private void stockLoop() {
		do {
			flg = ms.manageStock();
			if(flg) {
				flg = this.wannaContinue();
			}
		}while(flg);
	}



	public void setMs(ManageStock ms) {
		this.ms = ms;
	}

	private String buyORstock() {
		showChoice();
		String function = this.confirmFunction();
		return function;
	}

	private String confirmFunction() {
		// TODO 自動生成されたメソッド・スタブ
		String function = "";
		switch(numloop()) {
		case 1:
			function = "BUY";
			break;
		case 2:
			function = "STOCK";
			break;
		}
		return function;
	}

	private void showChoice() {
		System.out.println("|1|商品を購入する");
		System.out.println("|2|在庫を補充する");
		System.out.print("どうしますか？:");
	}

	private int numloop() {
		int Num;
		do {
			Num = this.imputNum();
		}while(this.checkNum(Num));
		return Num;
	}

	private boolean checkNum(int num) {
		// TODO 自動生成されたメソッド・スタブ
		if(num != 1 && num != 2) {
			System.out.print("表示された番号を入力してください:");
		}
		return (num != 1 && num != 2);
	}

	private int imputNum() {
		// TODO 自動生成されたメソッド・スタブ
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

	private boolean wannaContinue() {
		continueScreen();
		boolean contiFlg;
		switch(numloop()) {
		case 1:
			contiFlg = true;
			break;
		case 0:
			contiFlg = false;
			break;
		default:
			contiFlg = false;
		}
		return contiFlg;

	}

	private void continueScreen() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("続けて操作しますか？");
		System.out.println("|1|はい");
		System.out.println("|2|いいえ");
		System.out.print("番号を選んでください。:");
	}

}
