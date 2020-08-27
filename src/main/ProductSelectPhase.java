package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import product.Product;

public class ProductSelectPhase{

	private Product pro ;

	public void setPro(Product pro) {
		this.pro = pro;
	}

	//引数なし（setDBメソッドに引数）のパターン
	public ProductSelectPhase() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//引数あり（pspに引数）のパターン
	public ProductSelectPhase(Product pro) {
		// TODO 自動生成されたコンストラクター・スタブ
//		 pro = pro;
		this.setPro(pro);
	}


	private Zaiko zai;

	public void setZai(Zaiko zai) {
		// TODO 自動生成されたメソッド・スタブ
		this.zai = zai;
	}


	//商品情報のリスト
	List<Product> rist;


	public int main() throws SQLException {

		//商品情報のリスト
		rist = pro.getData();


	//リスト表示
	showlist();

	//選択された商品番号
	int select = sentaku();

	return select;
	}



	/**
	 * リスト表示
	 * @throws SQLException
	 */
	public void showlist() throws SQLException {

		String urikire;//売切文言

		//カウンタ
		int i = 0;

		for (Product a : rist) {

				//在庫が0以下なら売切表示を追加
				if (zai.kakuNokori(i) < 1) {
					urikire = "|売切";
				}else {
					urikire = "";
				}
				//リストの表示
				System.out.println("|"+ a.getId() +"|"+a.getName()+"|"+ a.getPrice() + "円"+ urikire);

			i++;//インクリメント
		}

	}


	/**
	 * 商品選択
	 * @param
	 * @return pnum
	 * @throws SQLException
	 */
	public int sentaku() throws SQLException {


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
		}while(pnum < 1 || pnum > rist.size());

		return pnum;
	}


	/**
	 * 選択した商品の在庫数を取得
	 * @param sele
	 * @return danball.get(choice).getNokori()
	 */
	public int choizai(int sele) {

		return zai.senzai(sele);

	}

	/**
	 * DBの在庫数を増やす
	 * @param hinban
	 * @throws SQLException
	 */
	public void fuyasu(int hinban) throws SQLException {
		zai.fuya(hinban);
	}

}
