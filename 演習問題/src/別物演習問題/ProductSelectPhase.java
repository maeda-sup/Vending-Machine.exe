package 別物演習問題;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductSelectPhase {

	public void Main(Product product) {

		//商品リストの表示
		product.DisplayList();

		//商品選択入力受付
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		Integer pnum = null;

		do {
			System.out.println("商品を選択してください:");
			try {
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