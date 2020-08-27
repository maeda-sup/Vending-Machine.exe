package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ZaikoDao {


	private DatabaseAccess dba;

	public void setDBA(DatabaseAccess dba) {
		// TODO 自動生成されたメソッド・スタブ
		this.dba = dba;
	}

	//在庫情報が入ったリスト
	List<Zaiko> data = new ArrayList<Zaiko>();


	/**
	 * 在庫情報セット(最初だけ)
	 * @return
	 * @throws SQLException
	 */
	public void setZaiko() throws SQLException {


				// SQLステートメント取得
				Statement st = dba.getStatement();

				// SQLの実行
				String sql = "select hinban, nokori, max from zaiko;";
				ResultSet rset = st.executeQuery(sql);

				//一時データ
				List<Zaiko> gendata = new ArrayList<Zaiko>();

				while(rset.next()) {

					Zaiko hako = new Zaiko();

					hako.setHinban(rset.getInt("hinban"));
					hako.setNokori(rset.getInt("nokori"));
					hako.setMax(rset.getInt("max"));

					gendata.add(hako);
				}
				//リストの上書き
				data = gendata;
			}



	/**
	 * 現・在庫情報をセット(逐一)×
	 * @param num
	 * @return hako
	 * @throws SQLException
	 */
	public void genZaiko() throws SQLException {

		// SQLステートメント取得
		Statement st = dba.getStatement();

		// SQLの実行
		String sql = "select hinban, nokori, max from zaiko;";
		ResultSet rset = st.executeQuery(sql);

		List<Zaiko> gendata = new ArrayList<Zaiko>();

		while(rset.next()) {

			Zaiko hako = new Zaiko();

			hako.setHinban(rset.getInt("hinban"));
			hako.setNokori(rset.getInt("nokori"));
			hako.setMax(rset.getInt("max"));

			gendata.add(hako);
		}
		data = gendata;
	}



	/**
	 * 在庫リスト取得
	 * @return data
	 */
	public List<Zaiko> ZaikoList() {
		return data;
	}



	/**
	 * DBの在庫数を減らす
	 * @param hinban
	 * @return zanh
	 */
	public void herasuDb(int hinban) throws SQLException {

		// SQLの実行
//		String sql5 = "select nokori from zaiko where hinban = ?";
//		PreparedStatement ps = dba.getPreparedStatement(sql5);
//		ps.setInt(1, hinban);

//		ResultSet rset = ps.executeQuery();


		// SQL作成
		String sql4 = "UPDATE zaiko SET nokori=nokori-1 WHERE hinban = ?";

		// SQLステートメント取得
		try (PreparedStatement ps = dba.getPreparedStatement(sql4)) {
			ps.setInt(1, hinban);

			ps.executeUpdate();
			dba.Commit();

		} catch (Exception e) {
			dba.Rollback();
			System.out.println("rollback");
		}
		return ;
	}



	private PreparedStatement getPreparedStatement(String sql4) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}



	/**
	 * DBの在庫数を増やす
	 * @param num
	 * @param selectid
	 * @return mono.getPrice()
	 * @throws SQLException
	 */
	public void fuyasuDb(int hinban, int num) throws SQLException {

		// SQL作成
		String sql4 = "UPDATE zaiko SET nokori=? WHERE hinban = ?";

		// SQLステートメント取得
		try (PreparedStatement ps = dba.getPreparedStatement(sql4)) {
			ps.setInt(1, num);
			ps.setInt(2, hinban);

			ps.executeUpdate();
			dba.Commit();

		} catch (Exception e) {
			dba.Rollback();
			System.out.println("rollback");
		}

		}


}
