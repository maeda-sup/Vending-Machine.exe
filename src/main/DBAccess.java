package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {
	private String uri = "jdbc:mariadb://localhost:3306/test";
	private String user = "user";
	private String password = "user";
	private String sql = "select id, name, price, detail, comment from product";  //必要な行をとってくる
	Connection conn;
	//↑Connectionクラスの変数？BOX「conn」をつくったよ！connectDBメソッドを呼び出すことでここに中身をいれられるよ！

	public void connectDB() throws SQLException {
		// DB接続
		conn = DriverManager.getConnection(uri, user, password);
		conn.setAutoCommit(false);
	}

	private PreparedStatement getPreparedStatement(String sql) throws SQLException {
		// ↓プリペアステートメントは？がある時で、文章を持っていくときにつかう
		return conn.prepareStatement(sql);
	}

	public void showlist() throws SQLException {

		Product prd = new Product();
		// SQLステートメント取得　クリエイトステートメントは？（はてな）変数がない時で、文章を持っていくときにつかうもの
		Statement st = conn.createStatement();

		// SQLの実行
		ResultSet rset = st.executeQuery(sql);

//		List<Product> plist = new ArrayList<Product>();

		// 照会結果の取得
		while (rset.next()) {//NEXTは次の行に　


				System.out.println(
						"|" + rset.getInt("id") + "|" + rset.getString("name") + "|" + rset.getString("price") + "円");

				prd.setName(rset.getString("name"));
				prd.setPrice(rset.getInt("price"));
				prd.setDetail(rset.getString("detail"));

//				plist.add(prd);　1行1行をリストに入れていく。→List＜Productlist＞でテーブルが

		}

	}

	public int total() throws SQLException {

		// SQLステートメント取得
		Statement st = conn.createStatement();


		/* SQLの実行
			String sql = "select name, price, detail from product;";
				//""の中の文はmariaDBのクエリで実行できる言語！JAVAではわからない。
				//だから、このSQL語の文章の文字列をつくって…

			ResultSet rset = st.executeQuery(sql);
				//この文字列をst、文章作成くんに渡すよ！
				//そしてクエリで実行して帰す(Resultset)のを、rsetにいれたよ！rsetには帰ってきた値が入ってるよ！ここではデータベース丸ごと返してるね！
		*/

		String se = "SELECT MAX(id) AS MAX FROM Product;";   //これね、AS　MAXなしでやったらね、行の名前がidからMAX(id)に変わっちゃうの。だから、“id”で返却しようとしても、なんのこっちゃわからないのね。
		//上と同じようにして、SQL語を作ったのを入れるよ　　　//だから、AS　MAXってして行の名前を変えてあげるの！ほら、わかりやすいでしょ？

		ResultSet rseta = st.executeQuery(se);
		//入れたのをもってってもらって、返すよ
		while (rseta.next()) {                          //1行しかないけど、Resultset入れたら必ずnextを呼ぶ！！そういうもの！！

		return rseta.getInt("MAX");
		//Resultset型で返しちゃうと、メインまで変えなきゃいけなくなる。だから、Intでとってきて返すよ。
		}
		return 0;              //とりま0　MAXがなかったらを作らなきゃいけない
	}

	public Product shohinout(int selectnum) throws SQLException {

		Product prd = new Product();
		// SQLステートメント取得
//		Statement st = conn.createStatement();

		// SQLの実行
		String aset ="SELECT * FROM Product WHERE id = ?";

		try (PreparedStatement ps = getPreparedStatement(aset)) { //() には入れたい文章を！
			ps.setInt(1, selectnum);
			//？を指定する。（）には、（？の順番,入れたいもの）を書く。ここでは？1つしかないから1

//			ps.executeUpdate(); ←これはデータを上書きしたいとき。ちな何件上書きしましたよ～ってのが返ってくる。
			ResultSet rseta = ps.executeQuery();             //これは引数なし。選択したいだけのときに良
			//↑SQLをここで送信する
//			conn.commit();
			//コミットする＝確定させる、反映する
			while (rseta.next()) {                      //これでテーブルの値を一つ一つとってきてprdに入れる

				prd.setName(rseta.getString("name"));
				prd.setPrice(rseta.getInt("price"));
				prd.setDetail(rseta.getString("detail"));
				prd.setComment(rseta.getString("comment"));
				prd.setStock(rseta.getInt("stock"));

			}

		} catch (Exception e) {
			conn.rollback();
			System.out.println("rollback");
		}
		//closeConnection();　←データベースのクローズ　まだいらない

//		ResultSet rseta = st.execute;


//		while (rseta.next()) {                      //これでテーブルの値を一つ一つとってきてprdに入れる
//
//			prd.setName(rseta.getString("name"));
//			prd.setPrice(rseta.getInt("price"));
//			prd.setDetail(rseta.getString("detail"));
//			prd.setComment(rseta.getString("comment"));
//			prd.setStock(rseta.getInt("stock"));
//
//		}

		return prd;

	}

	public void stockupdate1(int selectnum) throws SQLException {

		String incs = "UPDATE product SET stock = stock + 1 WHERE id = ?;";   //謎のカンマが入っててエラー
		try (PreparedStatement ps = getPreparedStatement(incs)) {
			ps.setInt(1, selectnum);

			ps.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		}
	}

	public void stockupdate2(int selectnum) {

		String incs = "UPDATE product SET stock = stock - 1 WHERE id = ?;";
		try (PreparedStatement ps = getPreparedStatement(incs)) {
			ps.setInt(1, selectnum);

			ps.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
		}
	}
}
