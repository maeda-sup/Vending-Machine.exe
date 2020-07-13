package 演習問題;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManegementDisplay {
	public static void main (String[] args) {
		Product OrangeJuice = new Product("オレンジジュース",150,"よくあるやつ","うん、おいしい！");

		//商品一覧を表示
		System.out.println("商品を選んでください");
		OrangeJuice.DisplayList();

		//商品番号入力受付→型変換
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Input = null;
		try {
			Input = br.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Integer PNum = Integer.valueOf(Input);

		//商品番号チェック
		CheckNum checknum = new CheckNum();
		checknum.CheckProductNum(PNum);

		//行動番号入力受付→型変換
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Input = br.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Integer ANum = Integer.valueOf(Input);

		//行動番号チェック
		checknum.CheckActionNum(ANum);

		//金額入力受付→型変換
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Input = br.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Integer YenNum = Integer.valueOf(Input);

		//金額チェック
		checknum.CheckAmount(YenNum, OrangeJuice.Price);

		//開封番号入力受付→型変換
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Input = br.readLine();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Integer ONum = Integer.valueOf(Input);

		//開封番号チェック
		checknum.CheckOpenNum(ONum, OrangeJuice);


	}

}
