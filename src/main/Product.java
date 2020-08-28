package main;

public class Product {
	private int id;
	private String name;
	private int price;
	private String detail;
	private String comment;

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

//	public int getStock(int productId) {
//		int stock = 0;
//		String sql = "select Stock from stock where ProductID = ?";
//
//		try(PreparedStatement ps = conn.prepareStatement(sql)){
//			ps.setInt(1, productId);
//			ResultSet rset = ps.executeQuery();
//			while(rset.next()) {
//				stock = rset.getInt("Stock");
//			}
//
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		return stock;
//	}
}
