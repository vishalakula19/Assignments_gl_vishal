import java.util.ArrayList;

public class Cart {
    ArrayList<Product> cartList = new ArrayList<>();
    double cartPrice = 0;
    String payment;

    void addToCart(Product p) {
        cartList.add(p);
    }

    double totalAmount() {
        for (Product product : cartList) {
            this.cartPrice += product.price;
        }
        if (this.payment == "card")
            return this.cartPrice * 2;
        return this.cartPrice;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}
