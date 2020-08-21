package main;

import java.sql.SQLException;

public class ProductSelectPhase{

	private DatabaseAccess db ;

	public void setDb(DatabaseAccess dba1) {
		this.db = dba1;
	}

	//引数なし（setDBメソッドに引数）のパターン
	public ProductSelectPhase() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//引数あり（pspに引数）のパターン
	public ProductSelectPhase(DatabaseAccess dba) {
		// TODO 自動生成されたコンストラクター・スタブ
//		 db = dba;
		this.setDb(dba);
	}



	public int main() throws SQLException {

	//選択された商品のID
	int select;

	//リスト表示
	db.showlist();

	//選択された商品オブジェクト
	select = db.shohinout();

	return select;
	}



	//選択した商品の在庫情報を取得
	public Zaiko zaiko(int choice) throws SQLException {

		return db.getZaiko(choice);

	}


}