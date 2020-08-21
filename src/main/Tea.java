package main;

public class Tea implements Shohin {

	//	フィールド変数
	private String name;
	private int price;
	private String detail;
	private String comment;
	private int stock;

	public Tea(String name, int price, String detail, String comment, int stock) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.comment = comment;
		this.stock = stock;
	}

	@Override
	public String getname() {
		// TODO 自動生成されたメソッド・スタブ
		return name;
	}

	@Override
	public int getprice() {
		// TODO 自動生成されたメソッド・スタブ
		return price;
	}

	@Override
	public String getdetail() {
		// TODO 自動生成されたメソッド・スタブ
		return detail;
	}

	@Override
	public String getcomment() {
		// TODO 自動生成されたメソッド・スタブ
		return comment;
	}
	@Override
	public int getstock() {
		// TODO 自動生成されたメソッド・スタブ
		return stock;
	}

	public void stockUpdate(int stock2) {
		// TODO 自動生成されたメソッド・スタブ
		this.stock = stock2;
	}

}
