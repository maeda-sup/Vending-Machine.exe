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
