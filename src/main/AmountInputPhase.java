package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmountInputPhase {
	public void Main(int price) {

		//準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int amount = 0;
		int inmoney = 0;

		do {
			System.out.print("入れる金額を入力してください:");
			try {
			input = br.readLine();
			inmoney = Integer.valueOf(input);

			}catch(IOException e1){
				continue;

			}catch(NumberFormatException e2) {
				System.out.println("※数字で入力してください");
				continue;
			}

			amount += inmoney;

			if(amount < price) {
				System.out.println("お金が足りません！追加してください！　　現在の投入金額:" + amount + "円");
			}

		}while(amount < price);

		return;
	}
}
