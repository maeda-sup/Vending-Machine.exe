package kane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.DatabaseAccess;

public class Kane {


	private DatabaseAccess dba ;

	public void setDBA(DatabaseAccess dba) {
		this.dba = dba;
	}


	//フィールド変数
	private Integer ruikei;//投入累計額

	public int getRuikei() {
		return ruikei;
	}

	public void setRuikei(Integer ruikei) {
		this.ruikei = ruikei;
	}


	/**
	 * 投入金額をDBから取得
	 * @param selectid
	 * @return mono.getPrice()
	 */
	public void getDbRuikei() throws SQLException {


		// SQL文
		String sql3 = "select ruikei from kane";

		// SQLステートメント取得
		Statement st = dba.getStatement();
		// SQLの実行
		ResultSet rset = st.executeQuery(sql3);


		Kane hako = new Kane();

		while(rset.next()) {

			hako.setRuikei(rset.getInt("ruikei"));

			ruikei = hako.getRuikei();

		}

	}

	/**
	 * 逐一累計更新
	 * @param total1
	 */
	public void imapay(int total1) {
		// TODO 自動生成されたメソッド・スタブ
		ruikei = total1;
	}


	/**
	 * DBに累計更新（最後）
	 * @param num
	 * @param selectid
	 * @return mono.getPrice()
	 * @throws SQLException
	 */
	public void commitRuikei() throws SQLException {

		// SQL作成
		String sql4 = "UPDATE kane SET ruikei = ?";

		// SQLステートメント取得
		try (PreparedStatement ps = dba.getPreparedStatement(sql4)) {
			ps.setInt(1, ruikei);

			ps.executeUpdate();
			dba.Commit();

		} catch (Exception e) {
			dba.Rollback();
			System.out.println("rollback");
		}
	}

}
