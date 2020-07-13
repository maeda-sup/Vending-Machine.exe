package test;

import java.util.ArrayList;

public class ProductList {

	private ArrayList<Product> productList;
	private int i = 1;

	public ProductList() {
		this.productList = new ArrayList<Product>();
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	private void printInfo(Product product) {
		System.out.println(i + "|" + product.getName() + "|" + product.getPrice());
	}

	public void showInfo() {
		for(Product product : productList) {
			printInfo(product);
			i++;
		}
	}

	public Product searchProduct(int select) {
		return productList.get(select - 1);
	}

}
