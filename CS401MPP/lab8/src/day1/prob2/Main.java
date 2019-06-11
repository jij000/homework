package day1.prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import day1.prob2.Product.SortMethod;

public class Main {
	public static void main(String[] args) {
		List<Product> pList = new ArrayList<Product>();
		pList.add(new Product("fff", 4.4, 3));
		pList.add(new Product("aaa", 1.1, 4));
		pList.add(new Product("eee", 3.3, 8));
		pList.add(new Product("ccc", 6.6, 6));
		pList.add(new Product("ddd", 5.5, 7));
		pList.add(new Product("eee", 3.3, 1));
		pList.add(new Product("ddd", 5.5, 2));
		pList.add(new Product("bbb", 2.2, 5));

		// Task a
		System.out.print("Task a (Price):");
		Collections.sort(pList, new ProductPriceComparator());
		print(pList);

		// Task b
		System.out.println("");
		System.out.println("--------------");
		System.out.print("Task b (Title):");
		Collections.sort(pList, new ProductTitleComparator());
		print(pList);

		// Task c
		System.out.println("");
		System.out.println("--------------");
		System.out.print("Task c (Price):");
		Product.sortC(pList, SortMethod.BYPRICE);
		print(pList);
		System.out.println("");
		System.out.println("--------------");
		System.out.print("Task c (Title):");
		Product.sortC(pList, SortMethod.BYTITLE);
		print(pList);

		// Task d
		System.out.println("");
		System.out.println("--------------");
		System.out.print("Task d (Price):");
		Product.sortD(pList, SortMethod.BYPRICE);
		print(pList);
		System.out.println("");
		System.out.println("--------------");
		System.out.print("Task d (Title):");
		Product.sortD(pList, SortMethod.BYTITLE);
		print(pList);
	}
	
	public static void print(List<Product> pList) {
		for (Product p : pList) {
			System.out.print(p.toString());
		}
	}
}
