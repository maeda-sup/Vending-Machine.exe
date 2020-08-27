package product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.DatabaseAccess;

public class Product {


	private DatabaseAccess dba;

	public void setDBA(DatabaseAccess dba) {
		// TODO 自動生成されたメソッド・スタブ
		this.dba = dba;
	}


	//フィールド変数
	private int id;//商品のid
	private String name;//商品名
	private int price;//商品の値段
	private String detail;//詳細
	private String comment;//コメント

	//コンストラクタ
	//public Product(String name ,int price, int nokori, String detail,String comment) {
        //this.name = name;
        //this.price = price;
        //this.nokori = nokori;
        //this.detail = detail;
        //this.comment = comment;
    //}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}




	//商品情報が入ったリスト
	List<Product> data = new ArrayList<Product>();


	/**
	 * 商品情報セット
	 * @return
	 * @throws SQLException
	 */
	public void setInfo() throws SQLException {


				// SQLステートメント取得
				Statement st = dba.getStatement();

				// SQLの実行
				String sql = "select id, name, price, detail, comment from product;";
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

		return;
	}


	/**
	 * 商品リスト取得
	 * @return data
	 */
	public List<Product> getData() {
		return data;
	}



	/**
	 * 選択した商品の値段を取得
	 * @param id
	 * @return nedan
	 */
	public int getSelectPrice(int id) {
		int nedan = 0;
		//hinbanとidが一致するリスト要素を探索
		for (int i = 0 ; i < data.size() ; i++) {

			//hinbanとidが一致したら在庫数を設定
			if (data.get(i).getId() == id) {
				nedan = data.get(i).getPrice();
			}
		}
		return nedan;
	}

	/**
	 * 選択した商品名を取得
	 * @param selectid
	 * @return na
	 */
	public String getSelectName(int selectid) {
		String na = "";
		//hinbanとidが一致するリスト要素を探索
		for (int i = 0 ; i < data.size() ; i++) {

			//hinbanとidが一致したら在庫数を設定
			if (data.get(i).getId() == selectid) {
				na = data.get(i).getName();
			}
		}
		return na;
	}


}
