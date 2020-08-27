package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductSelectPhase {

	private int max=1;                         //maxを決められた値に



	public void setMax(int maxf) {
                                                //max＝1を引数maxで上書き
		if(maxf <= 0 ) {                         //ただし、0より小さい引数maxはmax=1で固定
			this.max = 1;
		}else {
			this.max = maxf;
		}
	}



	public int Main() {                                   //メインちゃん引数maxで設定してるから、応急処置。青max使ってても上のメインちゃんが使える。

		return Syohinselect();
	}

	//Syohinselect


	public int Syohinselect() {

		//商品選択入力受付                                  //これはextractedとisExtractedの

		int pnum = 0;

		do {
			pnum = extracted();                             //extractedはメソッド飛ばした先。処理の引き抜き。

		}while(isExtracted(pnum));



		return pnum;

	}

	public int extracted() {
		int pnum = 0;
		String input;
		System.out.println("");
		System.out.print("商品を選択してください:");
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		pnum = Integer.valueOf(input);
		}catch(IOException e1){

		}catch(NumberFormatException e2) {
			System.out.println("数字で入力してください");
			pnum = 0;                                                                //ループの、文字かどうかの判定を取り出した。文字だったら0にした。
		}
		return pnum;
	}

	public boolean isExtracted(int pnum) {
		return pnum < 1 || max <  pnum;                                             //whileのtrueの中の判定を取り出した。
	}










}

