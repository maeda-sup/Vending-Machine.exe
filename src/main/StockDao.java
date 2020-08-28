package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockDao {
	DB db;

	public void setDb(DB db) {
		this.db = db;
	}

	/** 商品の在庫数参照
	 * @param id:商品ID
	 * @return stock:該当する商品の在庫
	 */
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

	/**買われた商品の在庫を一つ減らす
	 * @param id:買われた商品のID
	 */
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

	/**指定された商品の在庫を指定数分だけ増やす
	 * @param productId:指定された商品のID
	 * @param temp:増やす数
	 */
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

	/**指定された商品の最大個数を参照する
	 * @param id:指定された商品のID
	 * @return maxStock:最大個数
	 */
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

	/**指定された商品の在庫を最大まで増やす
	 * @param id
	 */
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

	/**指定の商品の在庫か満杯か調べる
	 * @param id
	 * @return ture:満杯, false:空きアリ
	 */
	public boolean isFull(int id) {
		int stock = this.getStock(id);
		int maxStock = this.getMaxStock(id);
		return stock >= maxStock;
	}

}
