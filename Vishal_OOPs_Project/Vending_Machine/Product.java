
public class Product {
    String name;
    double price;
    int qty;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name=" + name + ", price=" + price;
    }

}
