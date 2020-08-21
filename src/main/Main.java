package main;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException{
		// TODO 自動生成されたメソッド・スタブ
		Main main = new Main();
		main.goMain();
	}


	private void goMain() throws SQLException {

		//DB接続OBJの作成
		DatabaseAccess dba = new DatabaseAccess();
		//DB接続
		dba.onDb();

		//商品情報セット(不変)
		dba.setInfo();

		//投入している累計金額セット
		dba.getRuikei();

		//商品選択OBJ作成
		ProductSelectPhase psp = new ProductSelectPhase();
		psp.setDb(dba);

		//行動選択OBJ作成
		ActionSelectPhase asp = new ActionSelectPhase();

		//金額入力OBJ作成
		AmountInputPhase aip = new AmountInputPhase();
		aip.setDb(dba);

		//開封選択OBJ作成
		OpenSelectPhase osp = new OpenSelectPhase();


		//自販機本体OBJ作成
		Hontai hon = new Hontai();
		hon.setps(psp);
		hon.setas(asp);
		hon.setai(aip);
		hon.setos(osp);

		//自販機プログラム開始
		hon.menuMain();
		//自販機プログラム終了

		//DB切断
		dba.offDb();

	}
}
