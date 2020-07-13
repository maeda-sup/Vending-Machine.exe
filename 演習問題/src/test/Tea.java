package test;

public class Tea implements Product{

	private String name;
	private int price = 150;
	private String detail = "英国紳士の生きる糧。一日一回は摂取しないと、英国紳士は死ぬ。";
	private String comment = "おいおいおい、キまっていくねぇ！";

	public Tea(String name) {

		this.name = name;

	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ

		return name;
	}

	@Override
	public String getPrice() {
		// TODO 自動生成されたメソッド・スタブ
		return new String(price + "円");
	}

	@Override
	public String getComment() {
		// TODO 自動生成されたメソッド・スタブ
		return detail;
	}

	@Override
	public String getDetail() {
		// TODO 自動生成されたメソッド・スタブ
		return comment;
	}



}
