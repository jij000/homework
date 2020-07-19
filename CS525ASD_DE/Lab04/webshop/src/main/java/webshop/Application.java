package webshop;

public class Application {

	public static void main(String[] args) {
		Category rootCategory = new Category("Root");
		Category bookCategory = new Category("Book");
		Category movieCategory = new Category("Movie");
		Category computerCategory = new Category("Computer");
		Category foodCategory = new Category("Food");
		rootCategory.addComponent(bookCategory);
		rootCategory.addComponent(movieCategory);
		rootCategory.addComponent(computerCategory);
		rootCategory.addComponent(foodCategory);
		Product bookA = new Product("BOOK AAA", 123);
		Product bookB = new Product("BOOK BBB", 456);
		Product movieA = new Product("MOVIE AAA", 999);
		Product macComputer = new Product("MAC", 9999);
		Product beefFood = new Product("Beef", 25);
		Product chickenFood = new Product("Chicken", 18);
		bookCategory.addComponent(bookA);
		bookCategory.addComponent(bookB);
		movieCategory.addComponent(movieA);
		computerCategory.addComponent(macComputer);
		foodCategory.addComponent(beefFood);
		foodCategory.addComponent(chickenFood);
		rootCategory.print();

	}

}
