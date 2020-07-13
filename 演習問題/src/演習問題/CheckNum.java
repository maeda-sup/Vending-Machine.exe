package 演習問題;

public class CheckNum {
	public void CheckProductNum(Integer ProductNum) {
		if (ProductNum == 1 ) {

			System.out.println("次の行動を選んでください。");
			System.out.println("1|お金を入れる");
			System.out.println("2|商品を変更する");
			System.out.println("9|やっぱり買うのや～めた！");

		}else {
			System.out.println("該当する商品はありません。もう一度入力しなおしてください。");
			System.exit(0);
		}
	}

	public void CheckActionNum(Integer ActionNum) {
		switch(ActionNum){
			case 1 : System.out.println("入れる金額を入力してください。"); break;
			case 2 : ; break;
			case 9 : System.exit(0); break;
			default : System.out.println("無効な番号です");
			System.exit(0); break;
		}
	}

	public void CheckAmount(Integer Amount, Integer Price) {
		if(Amount >= Price) {

			System.out.println("1|詳細を表示");
			System.out.println("2|開封する");
			System.out.println("3|開封しない");

		}else {
			System.out.println("金額が足りません。入れたお金を返却します。");
			System.exit(0);
		}

	}

	public void CheckOpenNum(Integer OpenNumber, Product product) {
		switch(OpenNumber) {
			case 1 : product.DisplayDetail(); break;
			case 2 : product.DisplayComment(); break;
			case 3 : ; break;
			default : System.out.println("無効な番号です。");
		System.exit(0); break;
		}

	}
}
