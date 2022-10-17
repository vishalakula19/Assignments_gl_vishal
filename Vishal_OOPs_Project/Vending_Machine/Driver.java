import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("Thumbs Up", 36.00));
        list.add(new Product("Sprite", 40.00));
        list.add(new Product("Mowntain Dew", 38.00));
        list.add(new Product("Red Bull", 120.00));
        list.add(new Product("Gatorade", 50.00));
        char ch;
        do {

            System.out.println("Enter option to add to cart");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i).toString());
            }
            int choice = sc.nextInt();
            if (choice > list.size() || choice < 0) {
                System.out.println("Please enter correct option");
                System.exit(-1);
            }
            cart.addToCart(list.get(choice - 1));
            System.out.println("Do you want to add more ? (y/n)");
            ch = sc.next().charAt(0);
        } while (ch != 'n');
        System.out.println("Here are the list of products that you have added !!!");
        for (int i = 0; i < cart.cartList.size(); i++) {
            System.out.println(cart.cartList.get(i).toString());
        }
        System.out.println("\nEnter payment option: ");
        System.out.println("1. Cash");
        System.out.println("2. Card  (2X price)");
        int payment = sc.nextInt();
        switch (payment) {
            case 1:
                cart.setPayment("cash");
                break;
            case 2:
                cart.setPayment("card");
                break;
            default:
                System.out.println("Please enter correct option");
                System.exit(-1);
        }
        System.out.println("Total amount: " + cart.totalAmount());
    }
}
