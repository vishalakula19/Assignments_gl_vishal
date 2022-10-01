import java.util.ArrayList;
import java.util.Scanner;

public class Pasta extends Restaurant implements Menu {
    int flavourChoice;
    int pastaChoice;
    // Pasta flavours
    ArrayList<Flavour> pastaFlavourList = new ArrayList<>();
    // Pasta type
    ArrayList<Type> pastaTypes = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Pasta() {
        pastaFlavourList.add(new Flavour("White sauce", 10.00));
        pastaFlavourList.add(new Flavour("Red sauce", 20.00));

        pastaTypes.add(new Type("Penne"));
        pastaTypes.add(new Type("Ditalini"));
    }

    @Override
    public void showMenu() {
        System.out.println("Pasta comes in 2 flavors");
        for (int i = 0; i < pastaFlavourList.size(); i++) {
            System.out.println((i + 1) + ". " + pastaFlavourList.get(i).flavour + " ("
                    + pastaFlavourList.get(i).basePrice + " USD)");
        }
        this.flavourChoice = sc.nextInt() - 1;
        if (this.flavourChoice > pastaFlavourList.size() || this.flavourChoice < 0) {
            System.out.println("Please enter correct option");
            return;
        }
        System.out.println("Pasta comes in 2 types.  Select the type you want");
        for (int i = 0; i < pastaTypes.size(); i++) {
            System.out.println((i + 1) + ". " + pastaTypes.get(i).type);
        }
        this.pastaChoice = sc.nextInt() - 1;
        if (this.pastaChoice > pastaTypes.size() || this.pastaChoice < 0) {
            System.out.println("Please enter correct option");
            return;
        }

        this.placeOrder();

    }

    @Override
    public void placeOrder() {
        Order order = new Order("Pasta", pastaTypes.get(this.pastaChoice), pastaFlavourList.get(this.flavourChoice));
        order.caculatePrice();
        Restaurant.orders.add(order);

        // for (Order o : Restaurant.orders) {
        // System.out.println(o.toString());
        // }

        System.out.println("Order placed successfully !!");

    }

}
