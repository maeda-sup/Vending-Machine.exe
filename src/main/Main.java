package main;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//データベース接続
		DB db = new DB();
		try {
			db.connectDB();
		}catch(SQLException e) {
			return;
		}


		VendingSystem vs = new VendingSystem();
		ProductList plist = new ProductList();
		ProductDao pDao = new ProductDao();
		StockDao sDao = new StockDao();
		MoneyDao mDao = new MoneyDao();
		ManageStock ms = new ManageStock();
		pDao.setDb(db);
		sDao.setDb(db);
		mDao.setDb(db);
		plist.setConnection(db);
		plist.setpDao(pDao);
		plist.setsDao(sDao);
		ms.setProductList(plist);
		ms.setsDao(sDao);

		vs.setProductlist(plist);
		vs.setsDao(sDao);
		vs.setmDao(mDao);
		vs.setMs(ms);

		vs.selectFunction();


		db.closeConnection();

	}

}
