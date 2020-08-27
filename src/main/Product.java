package main;
//1行分のデータ
public class Product {


	private Integer id;
	private String name;
	private Integer price;
	private String detail;
	private Integer stock;
	private String comment;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDetails() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
