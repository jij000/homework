package day1.prob2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Product {
	static enum SortMethod {
		BYPRICE, BYTITLE
	};

	final String title;
	final double price;
	final int model;

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getModel() {
		return model;
	}

	public Product(String title, Double price, int model) {
		this.title = title;
		this.price = price;
		this.model = model;
	}

	@Override
	public String toString() {
		return String.format("\n %s : %s : %s", title, price, model);
	}

	public static void sortC(List<Product> pList, final SortMethod method) {
		class ProductComparator implements Comparator<Product> {

			@Override
			public int compare(Product o1, Product o2) {
				if (method.equals(SortMethod.BYPRICE)) {
					return Double.compare(o1.getPrice(), o2.getPrice());
				} else {
					return o1.getTitle().compareTo(o2.getTitle());
				}
			}
		}

		Collections.sort(pList, new ProductComparator());
	}

	public static void sortD(List<Product> pList, final SortMethod method) {
		Collections.sort(pList, (o1, o2) -> {
			if (method.equals(SortMethod.BYPRICE)) {
				return Double.compare(o1.getPrice(), o2.getPrice());
			} else {
				// If the title is same use model as another attribute to sort.
				if (o1.getTitle().equals(o2.getTitle())) {
					return Integer.compare(o1.getModel(), o2.getModel());
				} else {
					return o1.getTitle().compareTo(o2.getTitle());
				}
			}
		});
	}
}
