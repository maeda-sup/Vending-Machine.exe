package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoneyDao {
	DB db;


	public void setDb(DB db) {
		this.db = db;
	}

	/**DBから値を入手
	 * @return 現在DBに格納されている値
	 */
	public int getData() {
		// TODO 自動生成されたメソッド・スタブ
		ResultSet rset;
		Money money = new Money();
		try(Statement st = db.createStatement()){
			String sql = "select Amount from money";
			rset = st.executeQuery(sql);

			while(rset.next()) {
				money.setAmount(rset.getInt("Amount"));
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return money.getAmount();
	}

	/**お金を増やす
	 * @param inmoney
	 */
	public void addMoney(int inmoney) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE money SET Amount = ?";

		try(PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1, getData() + inmoney);
			ps.executeUpdate();
			db.commit();
		}catch(SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**お金を減らす
	 * @param price
	 */
	public void reduceMoney(int price) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE money SET Amount = ?";

		try(PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1, getData() - price);
			ps.executeUpdate();
			db.commit();
		}catch(SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
