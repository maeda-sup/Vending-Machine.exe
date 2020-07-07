package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductSelectPhase {

	Product product;
	
	public void Main() {

		//商品リストの表示
		product.DisplayList();

		//商品選択入力受付
		
		String input;
		Integer pnum = null;

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

		}while(pnum == 1);

		return;

	}
}