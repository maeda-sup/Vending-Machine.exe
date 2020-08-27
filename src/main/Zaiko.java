package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Zaiko {


	private ZaikoDao zdao;

	public void setZDAO(ZaikoDao zdao) {
		// TODO 自動生成されたメソッド・スタブ
		this.zdao = zdao;
	}

	//フィールド変数
	private int hinban;//商品IDと同じ品番
	private int nokori;//在庫数
	private int max;//最大在庫数


	public int getHinban() {
		return hinban;
	}
	public void setHinban(int hinban) {
		this.hinban = hinban;
	}
	public int getNokori() {
		return nokori;
	}
	public void setNokori(int nokori) {
		this.nokori = nokori;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}


	//在庫情報のリスト
	List<Zaiko> danball;


	/**
	 * 在庫リスト取得
	 * @return zdao.ZaikoList()
	 */
	public List<Zaiko> getZaiko() throws SQLException {
		danball = zdao.ZaikoList();
		return danball;
	}

	/**
	 * 売切表示用のnokori取得
	 * @param a
	 * @return danball.get(a).getNokori()
	 * @throws SQLException
	 */
	public int kakuNokori(int a) throws SQLException {
		//現・在庫状態の取得
		zdao.setZaiko();
		getZaiko();
		return danball.get(a).getNokori();
	}

	/**
	 * 選択した商品の在庫数を取得
	 * @param choice
	 * @return kazu
	 */
	public int senzai(int choice){
		int kazu = 0;
		//hinbanとidが一致するリスト要素を探索
		for (int i = 0 ; i < danball.size() ; i++) {

			//hinbanとidが一致したら在庫数を設定
			if (danball.get(i).getHinban() == choice) {
				kazu = danball.get(i).getNokori();
			}
		}
		return kazu;
	}

	/**
	 * 選択した商品の在庫情報を取得
	 * @param id
	 * @return case1
	 */
	public Zaiko selectZaiko(int id) {
		Zaiko case1 = null;
		//hinbanとidが一致するリスト要素を探索
		for (int i = 0 ; i < danball.size() ; i++) {

			//hinbanとidが一致したら在庫情報を設定
			if (danball.get(i).getHinban() == id) {
				case1 = danball.get(i);
			}
		}
		return case1;
	}



	/**
	 * DBの在庫有無
	 * @param id
	 * @return umu
	 * @throws SQLException
	 */
	public int zaikoumu(int id) throws SQLException {

		//在庫があるかどうか（0=ある、-1=ない）
		int umu = 0;

		//現・在庫状態の取得
		zdao.setZaiko();
		getZaiko();

		//選択した商品の在庫数
		int ima = senzai(id);
	//在庫が0以下
	if (ima < 0) {

		System.out.println("売切れです");
		umu = -1;
	}
	return umu;
	}



	/**
	 * DBの在庫数を減らす
	 * @param id
	 * @throws SQLException
	 */
	public void herasu(int id) throws SQLException {

		zdao.herasuDb(id);
		return;
	}




	/**
	 * DBの在庫数を増やす
	 * @param id
	 * @throws SQLException
	 */
	public void fuya(int id) throws SQLException {

		//現・在庫状態の取得
		zdao.setZaiko();
		getZaiko();
		//選択した在庫情報のリスト
		Zaiko cases = selectZaiko(id);

		//在庫数と限界在庫数の取得
		int zann = cases.getNokori();
		int zanm = cases.getMax();
		//差
		int sa = zanm - zann;

		//差が0より大きい
		if (sa > 0) {

			System.out.println("可能補充数は"+ sa + "個です");

		//補充数の入力
		String inp;
		int num = 0;

		do {
			System.out.print("いくつ補充しますか？:");
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			inp = br.readLine();
			num = Integer.valueOf(inp);
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("※数字で入力してください");
			}

			if (num < 0 || num > sa) {
				System.out.println("※補充できません※");
				System.out.println("可能補充数の範囲内で入力してください");
			}

		}while(num < 0 || num > sa);

		//補充

		num += zann;

		zdao.fuyasuDb(id,num);

		System.out.println("在庫は" + num + "個");

		}else {
			System.out.println("補充出来ません");
		}


	}

}

