package 演習問題;

public class Product {
	public String Name;
	public Integer Price;
	public String Detail;
	public String Comment;

	public Product(String name, Integer price, String detail, String comment) {
		this.Name = name;
		this.Price = price;
		this.Detail = detail;
		this.Comment = comment;

	}

	public void DisplayList() {
		System.out.println("1|"+ this.Name + "|"+ this.Price + "円");
	}

	public void DisplayDetail() {
		System.out.println(this.Detail);
	}

	public void DisplayComment() {
		System.out.println(this.Comment);
	}

}
