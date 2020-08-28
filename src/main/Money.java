package main;

public class Money {
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

//	int amount = 0;
//	int moneyinput;
//
//	public void addMoney() {
//		moneyinput = this.numloop();
//		amount += moneyinput;
//		return;
//	}
//
//
//	private int numloop() {
//		int Num = 0;
//		do{
//			Num = this.inputNum();
//
//		}while(this.checkNum(Num));
//
//		return Num;
//	}
//
//	private int inputNum() {
//		String input = null;
//		int inputNum = 0;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		try {
//			input = br.readLine();
//		} catch (IOException e1) {
//			// TODO 自動生成された catch ブロック
//			inputNum = 0;
//		}
//
//		try {
//			inputNum = Integer.valueOf(input);
//		} catch (NumberFormatException e2) {
//			// TODO 自動生成された catch ブロック
//			inputNum = 0;
//		}
//
//		return inputNum;
//	}
//
//	private boolean checkNum(int beChecked) {
//		return beChecked <= 0;
//	}
//
//
//
//	public int getMoney() {
//		return amount;
//	}

}
