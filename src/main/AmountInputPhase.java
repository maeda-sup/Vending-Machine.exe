package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmountInputPhase {

	DBAccess productlist;


	public void setProductlist(DBAccess productlist) {
		this.productlist = productlist;
	}


	public int Main(int price, int stock, int selectnum) {

		//準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Integer tounyu = null;
		Integer amount = 0;

		do {
			System.out.println("");
			System.out.print("入れる金額を入力してください:");
			System.out.println("");
			try {
			input = br.readLine();
			tounyu = Integer.valueOf(input);
			amount = amount + tounyu;

			if(amount < price) {
				System.out.println("お金が足りません！");
				System.out.print("現在の投入金額:");
				System.out.println(amount);

			}
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("数字で入力してください");
			}


		}while(amount < price);

		System.out.println();
		System.out.println("ご購入ありがとうございます。");
//		stock = stock - 1;
		productlist.stockupdate2(selectnum);


		if(amount > price) {
			System.out.print("おつりです:");
			System.out.println(amount - price);
			System.out.println();
		}

		return stock;
	}
}
