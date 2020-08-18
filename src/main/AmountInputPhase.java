package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmountInputPhase {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String input;//入力値
	int amount = 0;//入力値
	int total;//投入合計

	/**
	 * 入金
	 * @param price
	 */
	public void Main(int price) {

		hikaku(price);

		//現在残高の表示
		if (total > price) {
			System.out.println("現在残高は" + (total - price) + "円");
		}

		total -= price;

		return;
	}


	/**
	 * @param kakaku
	 * @return total
	 */
	public int hikaku(int kakaku) {

		do {

		System.out.print("入れる金額を入力してください:");
		try {
		input = br.readLine();
		amount = Integer.valueOf(input);
		total += amount;//投入合計

		}catch(IOException e1){
			return total;

		}catch(NumberFormatException e2) {
			System.out.println("※数字で入力してください");
			return total;
		}

		//現在投入した金額表示
		System.out.println("現在投入金額は" + total + "円");

		//商品の値段に投入合計が満たない場合
		if(total < kakaku) {
			System.out.println("お金が足りません！");
		}

		}while(total < kakaku);

		return total;
	}


	public void ruikei() {

		System.out.print("入れる金額を入力してください:");
		try {
		input = br.readLine();
		amount = Integer.valueOf(input);
		total += amount;//投入合計

		}catch(IOException e1){
			return ;

		}catch(NumberFormatException e2) {
			System.out.println("※数字で入力してください");
			return ;
		}

		//現在投入した金額表示
		System.out.println("現在投入金額は" + total + "円");

		return ;
	}
}
