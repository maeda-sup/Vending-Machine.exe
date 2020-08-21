package main;

public class Product {

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


}
