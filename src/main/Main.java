package main;

import java.sql.SQLException;

import kane.Kane;
import product.Product;

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


		//商品選択OBJ作成
		ProductSelectPhase psp = new ProductSelectPhase();
		//商品情報OBJ作成
		Product pro = new Product();
		pro.setDBA(dba);
		psp.setPro(pro);
		//商品情報セット(不変)
		pro.setInfo();

		//在庫OBJ作成
		Zaiko zai = new Zaiko();
		//在庫DAOのOBJ作成
		ZaikoDao zdao = new ZaikoDao();
		zdao.setDBA(dba);
		zai.setZDAO(zdao);
		//在庫情報セット
		zdao.setZaiko();
		zai.getZaiko();
		//pspにzaiをセット
		psp.setZai(zai);


		//行動選択OBJ作成
		ActionSelectPhase asp = new ActionSelectPhase();

		//金管理OBJ作成
		Kane kane = new Kane();
		kane.setDBA(dba);
		//投入している累計金額取得
		kane.getDbRuikei();
		//金額入力OBJ作成
		AmountInputPhase aip = new AmountInputPhase();
		aip.setKane(kane);
		aip.setPro(pro);
		//DBから取得した累計額をセット
		aip.firstsetRuikei();

		//開封選択OBJ作成
		OpenSelectPhase osp = new OpenSelectPhase();
		osp.setPro(pro);

		//自販機本体OBJ作成
		Hontai hon = new Hontai();
		hon.setps(psp);
		hon.setas(asp);
		hon.setai(aip);
		hon.setos(osp);
		hon.setza(zai);

		//自販機プログラム開始
		hon.menuMain();
		//自販機プログラム終了

		//DBに累計更新（最後）
		kane.commitRuikei();
		//DB切断
		dba.offDb();

	}
}
