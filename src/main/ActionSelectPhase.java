package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActionSelectPhase {
	/**
	 * @return anum
	 */
	public SentakuComand Main() {



		//行動選択入力受付と検証
		String input;
		int anum = 0;

		do {
			//行動選択画面の表示
			System.out.println("|1|お金を入れる");
			System.out.println("|2|商品選択");
			System.out.println("|3|商品補充");
			System.out.println("|9|やっぱり買うのや～めた");

			System.out.print("どうしますか？:");
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			anum = Integer.valueOf(input);
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("※数字で入力してください");
			}

//		}while(anum != 1 && anum != 2 && anum != 3 && anum != 9);
		}while(flag(anum));

		switch(anum) {
		case 1: return SentakuComand.PayIn;
		case 2: return SentakuComand.Choose;
		case 3: return SentakuComand.InItem;
		default: return SentakuComand.Exit;
		}

	}

	private boolean flag(int num) {
		return num != 1 && num != 2 && num != 3 && num != 9;
	}

}

