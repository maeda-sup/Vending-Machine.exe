package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionSelectPhase {
	public Integer Main() {

		//行動選択画面の表示
		System.out.println("1|お金を入れる");
		System.out.println("2|商品選択に戻る");
		System.out.println("9|やっぱり買うのや～めた");


		//行動選択入力受付と検証
		String input;
		Integer anum = null;

		do {
			System.out.print("どうしますか？:");
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			anum = Integer.valueOf(input);
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("数字で入力してください");
			}

		}while(anum == 1 || anum == 2 || anum == 9);


		return anum;


	}
}
