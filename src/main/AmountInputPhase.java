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

		do {
			System.out.print("入れる金額を入力してください:");
			try {
			input = br.readLine();
			amount = Integer.valueOf(input);

			}catch(IOException e1){
				continue;

			}catch(NumberFormatException e2) {
				System.out.println("※数字で入力してください");
				continue;
			}

			if(amount < price) {
				System.out.println("お金が足りません！");
			}

		}while(amount < price);

		return;
	}
}
