package 別物演習問題;

public class Product {
	public String name;
	public Integer price;
	public String detail;
	public String comment;

	public Product(String name, Integer price, String detail, String comment) {
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.comment = comment;

	}

	public void DisplayList() {
		System.out.println("1|"+ this.name + "|"+ this.price + "円");
	}

	public void DisplayDetail() {
		System.out.println(this.detail);
	}

	public void DisplayComment() {
		System.out.println(this.comment);
	}
}
