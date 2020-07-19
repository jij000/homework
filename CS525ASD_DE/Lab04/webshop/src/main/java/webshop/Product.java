package webshop;

public class Product  extends ProductCatalog {
    private int price;
    public Product(String name, int price) {
        super(name);
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void print() {
        System.out.println("--- product " + name + " price=$" + getPrice());
    }
}
