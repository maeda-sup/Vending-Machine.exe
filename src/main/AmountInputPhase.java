package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import kane.Kane;
import product.Product;

public class AmountInputPhase {


	int total;//投入合計

	private Kane kane;

	public void setKane(Kane kane) {
		// TODO 自動生成されたメソッド・スタブ
		this.kane = kane;
	}


	private Product pro ;

	public void setPro(Product pro) {
		this.pro = pro;
	}




	/**
	 * DBの累計を初期設定
	 */
	public void firstsetRuikei() {
		//DBの投入金額をセット
		total = kane.getRuikei();
	}


	/**
	 * 入金
	 * @param selectid
	 * @throws SQLException
	 */
	public void Main(int selectid) throws SQLException {

		//選択した商品の値段
		int price = pro.getSelectPrice(selectid);

		hikaku(price);

		//現在残高の表示
		if (total >= price) {
			System.out.println(pro.getSelectName(selectid) + "が出てきた！");
			System.out.println("現在投入残高は" + (total - price) + "円");
		}

		total -= price;

		//逐一累計管理に反映
		kane.imapay(total);

		return;
	}


	/**
	 * 比較
	 * @param kakaku
	 */
	public void hikaku(int kakaku){

		do {
			ruikei();

		//商品の値段に投入合計が満たない場合
		if(total < kakaku) {
			System.out.println("お金が足りません！");
		}

		}while(total < kakaku);

		return;
	}


	/**
	 * 累計計算
	 */
	public void ruikei() {

		System.out.print("入れる金額を入力してください:");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input= br.readLine();//入力値
			int amount = Integer.valueOf(input);//入力値

		total += amount;//投入合計

		}catch(IOException e1){
			return ;

		}catch(NumberFormatException e2) {
			System.out.println("※数字で入力してください");
			return ;
		}

		//現在投入した金額表示
		System.out.println("現在投入金額は" + total + "円");


		//逐一累計管理に反映
		kane.imapay(total);

		return ;
	}



}
