package main;

public class Water implements Shohin {

	//フィールド変数
	private String name;
	private int price = 100;
	private String detail = "おいしい水。飲むとHPが回復しそう。";
	private String comment = "喉がいい感じに潤った！" ;

	public Water(String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.name = name;
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

}
