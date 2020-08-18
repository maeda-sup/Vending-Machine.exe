package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductSelectPhase {


	/**
	 * 商品選択
	 * @param max
	 * @return
	 */
	public int Main(int max) {

		String input;//入力値
		int pnum = 0;//選択値

		//商品選択入力受付
		do {
			System.out.print("商品を選択してください:");
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			pnum = Integer.valueOf(input);
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("※数字で入力してください");
			}

		}while(pnum < 1 || max < pnum);

		return pnum;

	}
}