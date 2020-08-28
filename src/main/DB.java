package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private String uri = "jdbc:mariadb://localhost:3306/test";
	private String user = "user";
	private String password = "supply";
	Connection connect;

	/** DBに接続を行う
	 * @throws SQLException
	 */
	public void connectDB() throws SQLException{
		try {
			connect = DriverManager.getConnection(uri,user,password);
			connect.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.print("DB接続に失敗しました");
			e.printStackTrace();
			throw e;
		}
		return ;
	}

	/**DB接続を解除する
	 *
	 */
	public void closeConnection(){
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public Statement createStatement() {
		// TODO 自動生成されたメソッド・スタブ
		Statement st = null;
		try {
			st = connect.createStatement();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return st;
	}

	public PreparedStatement prepareStatement(String sql) {
		// TODO 自動生成されたメソッド・スタブ
		PreparedStatement ps = null;
		try {
			ps = connect.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return ps;
	}

	/** DBへの変更を確定させる
	 *
	 */
	public void commit() {
		try {
			connect.commit();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
