package webshop;

import java.util.ArrayList;
import java.util.Collection;

public class Category extends ProductCatalog {
    protected Collection<ProductCatalog> categoryComponents = new
        ArrayList<ProductCatalog>();

    public Category(String name) {
        super(name);
    }

    public void addComponent(ProductCatalog component) {
        categoryComponents.add(component);
    }

    public int getProductCount() {
        int productCount = 0;
        for (ProductCatalog component : categoryComponents) {
            productCount++;
        }
        return productCount;
    }

    public void print() {
        System.out.println("-- Category " + name + " has " + getProductCount() + " kinds of products");
        for (ProductCatalog component : categoryComponents) {
            component.print();
        }
    }
}
