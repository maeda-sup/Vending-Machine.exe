package main;
import java.util.List;

public class ProductList {

	private List<Product> productlist;
	private ProductDao pDao;
	private StockDao sDao;



	public void setsDao(StockDao sDao) {
		this.sDao = sDao;
	}

	public void setpDao(ProductDao pDao) {
		this.pDao = pDao;
	}

	public void setConnection(DB db) {
		return;
	}

	public void makeList() {
		productlist = pDao.makelist();
	}

	/**商品リストと売り切れか否かをコンソールに表示する
	 *
	 */
	public void showlist() {
		int i = 1;
		String soldout = "";
		for(Product prd: productlist) {
			if(sDao.getStock(prd.getId()) == 0) {
				soldout = "|売り切れ";
			}

			System.out.println("|"+ i +"|"+ prd.getName()+"|"+ prd.getPrice() + "円" + soldout);
			soldout = "";
			i++;
		}
	}

	/**商品リストと在庫数（満タンの場合は満タン）を表示する
	 *
	 */
	public void showStocks() {
		int i = 1;
		for(Product prd: productlist) {
			if(sDao.isFull(prd.getId())){
				System.out.println("|"+ i +"|"+ prd.getName() +"|満タン");
			}else {
				System.out.println("|"+ i +"|"+ prd.getName() +"|残り"+ sDao.getStock(prd.getId()) + "個");
			}
			i++;
		}
		System.out.println("|0|終了する");
	}



	/**番号に該当する商品を返す
	 * @param shohinnum
	 * @return
	 */
	public Product getProduct(int productnum) {

		Product prd = productlist.get(productnum -1);

		return prd;
	}

	public int total() {
		return productlist.size();
	}
}
