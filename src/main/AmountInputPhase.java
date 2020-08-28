package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmountInputPhase {
	public MoneyDao mDao;

	public void setmDao(MoneyDao mDao) {
		this.mDao = mDao;
	}

	public void Main(int price) {

		//準備
		int amount;
		int inmoney = 0;

		do {
			System.out.print("入れる金額を入力してください:");
			inmoney = this.numloop();
			mDao.addMoney(inmoney);
			amount = mDao.getData();

			if(amount < price) {
				System.out.println("お金が足りません！追加してください！現在の投入金額:" + amount + "円");
			}

		}while(amount < price);

		return;
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

	private boolean isNegative(int Num) {
		return Num < 0;
	}

	private int numloop() {
		int Num;
		do {
			Num = this.imputNum();
		}while(this.isNegative(Num));
		return Num;
	}
}
