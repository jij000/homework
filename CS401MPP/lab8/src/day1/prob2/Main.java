package day1.prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Product> pList = new ArrayList<Product>();
		pList.add(new Product("fff", 4.4, 3));
		pList.add(new Product("aaa", 1.1, 4));
		pList.add(new Product("ccc", 6.6, 6));
		pList.add(new Product("eee", 3.3, 1));
		pList.add(new Product("ddd", 5.5, 2));
		pList.add(new Product("bbb", 2.2, 5));

		// Task a
		System.out.print("Task a (Price):");
		Collections.sort(pList, new ProductPriceComparator());
		for (Product p : pList) {
			System.out.print(p.toString());
		}

		// Task b
		System.out.println("");
		System.out.println("--------------");
		System.out.print("Task b (Title):");
		Collections.sort(pList, new ProductTitleComparator());
		for (Product p : pList) {
			System.out.print(p.toString());
		}
	}

}
