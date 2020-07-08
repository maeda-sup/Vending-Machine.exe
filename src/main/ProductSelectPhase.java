package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductSelectPhase {


	public int Main(int max) {

		//商品選択入力受付

		String input;
		int pnum = 0;

		do {
			System.out.println("商品を選択してください:");
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			pnum = Integer.valueOf(input);
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("数字で入力してください");
			}

		}while(pnum < 1 || max < pnum);

		return pnum;

	}
}