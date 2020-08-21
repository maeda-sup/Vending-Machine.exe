package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DatabaseAccess {
	private String uri = "jdbc:mariadb://localhost:3306/test";
	private String user = "user";
	private String password = "4125";
	private String sql = "select  id, name, price, detail, comment from product;";

	//接続状態
	Connection conn;

	// DB接続
	public void onDb() throws SQLException {
		conn = DriverManager.getConnection(uri,user,password);
	}

	// DB切断
	public void offDb() throws SQLException {

		//Connection文と１セット（システムで一つ）
		conn.close();
	}

	//商品情報が入ったリスト
	List<Product> data = new ArrayList<Product>();

	//商品の要素数
	int size;

	//累計金額
	int kei;



	/**
	 * 商品情報セット
	 * @return
	 * @throws SQLException
	 */
	public void setInfo() throws SQLException {

				// SQLステートメント取得
				Statement st = conn.createStatement();
				// SQLの実行
				ResultSet rset = st.executeQuery(sql);

				while(rset.next()) {

					Product hako = new Product();

					hako.setId(rset.getInt("id"));
					hako.setName(rset.getString("name"));
					hako.setPrice(rset.getInt("price"));
					hako.setDetail(rset.getString("detail"));
					hako.setComment(rset.getString("comment"));

					data.add(hako);

				}

				size = data.size();

		return;
	}



	/**
	 * 投入した金額の累計
	 * @param selectid
	 * @return mono.getPrice()
	 */
	public int getRuikei() throws SQLException {

		// SQL文
		String sql3 = "select ruikei from kane";

		// SQLステートメント取得
		Statement st = conn.createStatement();
		// SQLの実行
		ResultSet rset = st.executeQuery(sql3);

		int kei = rset.getInt("ruikei");

		return kei;
	}



	/**
	 * リスト表示
	 * @throws SQLException
	 */
	public void showlist() throws SQLException {

		// SQLステートメント取得
		Statement st = conn.createStatement();
		// SQLの実行
		ResultSet rset = st.executeQuery(sql);
		// 実行結果の取得

		String urikire;//売切文言

		while(rset.next()) {

				//在庫が0以下なら売切表示を追加
				if (rset.getInt("nokori") < 1) {
					urikire = "|売切";
				}else {
					urikire = "";
				}
				//リストの表示
				System.out.println("|"+ rset.getInt("id") +"|"+rset.getString("name")+"|"+ rset.getInt("price") + "円"+ urikire);
			}

	}



	/**
	 * リストの要素数を返す×
	 * @return productlist.size()
	 * @throws SQLException
	 */
	public int total() throws SQLException {

				// SQLステートメント取得
				Statement st = conn.createStatement();
				// SQLの実行
				ResultSet rset = st.executeQuery(sql);
				rset.last();
				int row = rset.getRow();
				// 実行結果の取得
		return row;//リストの要素数を返す
	}


	/**
	 * リストの要素数を返す×
	 * @return productlist.size()
	 * @throws SQLException
	 */
	public int total1() throws SQLException {

				// SQLステートメント取得
				Statement st = conn.createStatement();
				// SQLの実行
				ResultSet rset = st.executeQuery(sql);

				while(rset.next()) {

					Product hako = new Product();

					hako.setId(rset.getInt("id"));
					hako.setName(rset.getString("name"));
					hako.setPrice(rset.getInt("price"));
					hako.setDetail(rset.getString("detail"));
					hako.setComment(rset.getString("comment"));

					data.add(hako);

				}

		return data.size();//リストの要素数を返す
	}



	/**
	 * 選択した商品IDを取得
	 * @param
	 * @return pnum
	 * @throws SQLException
	 */
	public int shohinout() throws SQLException {

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
		}while(pnum < 1 || size < pnum);


		// SQLの実行
//		String sql1 = "select  id, name, price, detail, comment from product where id = ?";
//		PreparedStatement ps = conn.prepareStatement(sql1);
//		ps.setInt(1, pnum);

//		ResultSet rset = ps.executeQuery();

		// 該当商品情報の取得
//		Product hako = new Product();

//		hako = data.get(pnum);

		//Statement文と１セット（システムで複数OK）
//		ps.close();

		return pnum;
	}





	/**
	 * 選択した商品の在庫情報を取得
	 * @param num
	 * @return hako
	 * @throws SQLException
	 */
	public Zaiko getZaiko(int num) throws SQLException {

		// SQLの実行
		String sql2 = "select  hinban, nokori, max from zaiko where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql2);
		ps.setInt(1, num);

		ResultSet rset = ps.executeQuery();


		Zaiko danball = new Zaiko();

			danball.setHinban(rset.getInt("hinban"));
			danball.setNokori(rset.getInt("nokori"));
			danball.setMax(rset.getInt("max"));

		return danball;
	}




	/**
	 * 選択した商品の値段を取得
	 * @param selectid
	 * @return mono.getPrice()
	 */
	public int getprice(int selectid) {

		// 該当商品情報の取得
		Product mono = new Product();

		mono = data.get(selectid);

		return mono.getPrice();

	}


	/**
	 * DBの在庫数を減らす
	 * @param hinban
	 */
	public void herasuDb(int hinban) throws SQLException {

		// SQLの実行
		String sql5 = "select nokori from zaiko where hinban = ?";
		PreparedStatement ps = conn.prepareStatement(sql5);
		ps.setInt(1, hinban);

		ResultSet rset = ps.executeQuery();

		//在庫数の表示
		int zanh = rset.getInt("nokori");

		//在庫が0より大きい
		if (zanh > 0) {
			System.out.println("在庫は" + zanh + "個");

			// SQL作成
			String sql4 = "UPDATE zaiko SET nokori-1 WHERE hinban = ?";

			// SQLステートメント取得
			try (PreparedStatement ps = getPreparedStatement(sql4)) {
				ps.setInt(1, hinban);

				ps.executeUpdate();
				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				System.out.println("rollback");
			}

		//在庫が0以下
		}else {
			System.out.println("売切れです");

		}

	}

	private PreparedStatement getPreparedStatement(String sql4) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}



	/**
	 * DBの在庫数を増やす
	 * @param selectid
	 * @return mono.getPrice()
	 */
	public void fuyasu(int hinban) {

		// SQLの実行
		String sql7 = "select nokori, max from zaiko where hinban = ?";
		PreparedStatement ps = conn.prepareStatement(sql7);
		ps.setInt(1, hinban);

		ResultSet rset = ps.executeQuery();

		//在庫数と限界在庫数の取得
		int zann = rset.getInt("nokori");
		int zanm = rset.getInt("max");
		//差
		int sa = zanm - zann;

		//差が0より大きい
		if (sa > 0) {

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

		}while(num < 0 || num > sa);

		//補充


		// SQL作成
		String sql4 = "UPDATE zaiko SET nokori=? WHERE hinban = ?";

		// SQLステートメント取得
		try (PreparedStatement ps = getPreparedStatement(sql4)) {
			ps.setInt(1, num);
			ps.setInt(2, hinban);

			ps.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			conn.rollback();
			System.out.println("rollback");
		}



		System.out.println("在庫は" + nokori + "個");

		}else {

		}

	}




	public String getDetail(int choice) {

		return data.get(choice).getDetail();
	}



	public String getComment(int choice) {

		return data.get(choice).getComment();
	}







}