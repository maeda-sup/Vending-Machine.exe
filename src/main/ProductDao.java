package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	DB db;

	public void setDb(DB db) {
		this.db = db;
	}

	public List<Product> makelist() {
		ResultSet rset;
		List<Product> productlist = new ArrayList<Product>();
		try(Statement st = db.createStatement()){
			String sql = "select ID, Name, Price, Detail, Comment from product";
			rset = st.executeQuery(sql);

			while(rset.next()) {
				Product product = new Product();
				product.setId(rset.getInt("ID"));
				product.setName(rset.getString("Name"));
				product.setPrice(rset.getInt("Price"));
				product.setDetail(rset.getString("Detail"));
				product.setComment(rset.getString("Comment"));
				productlist.add(product);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			System.out.print("商品群を取得できませんでした。");
			e.printStackTrace();
		}
		return productlist;
	}


}
