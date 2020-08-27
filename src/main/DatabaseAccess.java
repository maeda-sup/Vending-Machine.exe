package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

	//商品の要素数
	int size;

	//createStatement()情報受け渡し(conn隠し)
	public Statement getStatement() throws SQLException {
		return conn.createStatement();
	}

	//prepareStatement()情報受け渡し(conn隠し)
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	//コミット
	public void Commit() throws SQLException {
		conn.commit();
	}

	//ロールバック
	public void Rollback() throws SQLException {
		conn.rollback();
	}


}