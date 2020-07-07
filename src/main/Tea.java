package main;

public class Tea implements Shohin {

	//	フィールド変数
	private String name;
	private int price = 150;
	private String detail = "英国紳士の嗜み";
	private String comment = "英国面を感じる" ;

	public Tea(String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.name = name;
	}

	@Override
	public String getname() {
		// TODO 自動生成されたメソッド・スタブ
		return "|"+ name +"|"+ price + "円" ;
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
