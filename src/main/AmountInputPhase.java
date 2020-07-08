package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AmountInputPhase {
	public void Main(int price) {

		//準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Integer amount = null;

		do {
			System.out.print("入れる金額を入力してください:");
			try {
			input = br.readLine();
			amount = Integer.valueOf(input);

			if(amount < price) {
				System.out.println("お金が足りません！");
			}
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("数字で入力してください");
			}

		}while(amount < price);

		return;
	}
}
