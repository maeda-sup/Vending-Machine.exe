package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockDao {
	DB db;

	public void setDb(DB db) {
		this.db = db;
	}

	public int getStock(int id) {
		// TODO 自動生成されたメソッド・スタブ
		int stock = 0;
		String sql = "select Stock from stock where ProductID = ?";

		try(PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rset = ps.executeQuery();
			while(rset.next()) {
				stock = rset.getInt("Stock");
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return stock;
	}

	public void reduceStock(int id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE stock SET Stock = ? where ProductID = ?";

		try(PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1, getStock(id) - 1);
			ps.setInt(2, id);
			ps.executeUpdate();
			db.commit();
		}catch(SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public void addStock(int productId, int temp) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE stock SET Stock = ? where ProductID = ?";

		try(PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1, getStock(productId) + temp);
			ps.setInt(2, productId);
			ps.executeUpdate();
			db.commit();
		}catch(SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public int getMaxStock(int id) {
		// TODO 自動生成されたメソッド・スタブ
		int maxStock = 0;
		String sql = "select MaxStock from stock where ProductID = ?";

		try(PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rset = ps.executeQuery();
			while(rset.next()) {
				maxStock = rset.getInt("MaxStock");
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return maxStock;
	}

	public void addToMax(int id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "UPDATE stock SET Stock = ? where ProductID = ?";

		try(PreparedStatement ps = db.prepareStatement(sql)){
			ps.setInt(1, getMaxStock(id));
			ps.setInt(2, id);
			ps.executeUpdate();
			db.commit();
		}catch(SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public boolean isFull(int id) {
		int stock = this.getStock(id);
		int maxStock = this.getMaxStock(id);
		return stock >= maxStock;
	}

}
