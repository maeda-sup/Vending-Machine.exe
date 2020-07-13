package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenSelectPhase {
	public void Main(String syosai, String okotoba) {

		//開封選択画面の表示
		System.out.println("|1|詳細を見る");
		System.out.println("|2|開ける");
		System.out.println("|3|開けない");

		//開封選択入力受付と検証
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int onum = 0;

		do {
			System.out.print("どうしますか？:");
			try {
			input = br.readLine();
			onum = Integer.valueOf(input);

			if(onum == 1) {
				System.out.println(syosai);
			}
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("※数字で入力してください");
			}

			}while(onum != 2 && onum != 3);

		//コメント表示
		if(onum == 2) {
			System.out.println(okotoba);
		}

		return;
	}
}
