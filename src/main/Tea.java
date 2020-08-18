package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tea implements Shohin {

	//フィールド変数
	private String name;//商品名
	private int price = 150;//商品の値段
	private int nokori = 1;//在庫数
	private String detail = "英国紳士の嗜み";//詳細
	private String comment = "英国面を感じる" ;//コメント

	/**
	 * @param name
	 */
	public Tea(String name) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.name = name;
	}

	@Override
	public String getname() {
		// TODO 自動生成されたメソッド・スタブ
		return name;
	}

	@Override
	public Integer getprice() {
		// TODO 自動生成されたメソッド・スタブ
		return price;
	}

	@Override
	public Integer getnokori() {
		// TODO 自動生成されたメソッド・スタブ
		return nokori;
	}

	@Override
	public void herasu() {
		// TODO 自動生成されたメソッド・スタブ
		nokori -= 1;
		System.out.println("在庫は" + nokori + "個");
	}

	@Override
	public void fuyasu() {
		// TODO 自動生成されたメソッド・スタブ

		//補充数の入力
		String inp;
		int num = 0;

		do {
			System.out.print("いくつ補充しますか？:");
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			inp = br.readLine();
			num = Integer.valueOf(inp);
			}catch(IOException e1){

			}catch(NumberFormatException e2) {
				System.out.println("※数字で入力してください");
			}

		}while(num < 0);

		//補充
		nokori += num;
		System.out.println("在庫は" + nokori + "個");
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
