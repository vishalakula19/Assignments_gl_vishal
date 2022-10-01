import java.util.ArrayList;
import java.util.Scanner;

public class Pizza implements Menu {
    int sizeChoice;
    int crustChoice;
    int flavourChoice;
    int noOfToppings;
    Topping[] toppings;

    // Pizza Sizes
    ArrayList<Size> sizeList = new ArrayList<>();
    // Pizza Crust
    ArrayList<Type> pizzaCrust = new ArrayList<>();
    // Pizza Flavour
    ArrayList<Flavour> pizzaFlavourList = new ArrayList<>();
    // Pizza Toppings
    ArrayList<Topping> toppingList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Pizza() {

        sizeList.add(new Size("Small"));
        sizeList.add(new Size("Medium"));
        sizeList.add(new Size("Large"));

        pizzaCrust.add(new Type("Thin"));
        pizzaCrust.add(new Type("Thick"));

        pizzaFlavourList.add(new Flavour("Vegetarian", 20.00));
        pizzaFlavourList.add(new Flavour("Non-veg", 25.00));
        pizzaFlavourList.add(new Flavour("Vegan", 15.00));

        toppingList.add(new Topping("Cheese", 1.00));
        toppingList.add(new Topping("Mushroom", 1.00));
        toppingList.add(new Topping("Tomato", 1.00));
        toppingList.add(new Topping("Jalapeno", 1.00));
        toppingList.add(new Topping("Spinach", 1.00));
    }

    @Override
    public void showMenu() {
        System.out.println("Pizza has 3 sizes. Select the size you want");
        for (int i = 0; i < sizeList.size(); i++) {
            System.out.println((i + 1) + ". " + sizeList.get(i).size);
        }
        this.sizeChoice = sc.nextInt() - 1;
        if (this.sizeChoice > sizeList.size() || this.sizeChoice < 0) {
            System.out.println("Please enter correct option");
            return;
        }
        System.out.println("Pizza comes in 2 types of crust.  Select the crust you want");
        for (int i = 0; i < pizzaCrust.size(); i++) {
            System.out.println((i + 1) + ". " + pizzaCrust.get(i).type);
        }
        this.crustChoice = sc.nextInt() - 1;
        if (this.crustChoice > pizzaCrust.size() || this.crustChoice < 0) {
            System.out.println("Please enter correct option");
            return;
        }
        System.out.println("Pizza comes in 3 types of flavor.  Select the flavor you want");
        for (int i = 0; i < pizzaFlavourList.size(); i++) {
            String p = "(";
            double price = pizzaFlavourList.get(i).basePrice;
            for (int j = 0; j < sizeList.size(); j++) {
                p += price * (j + 1) + " USD " + sizeList.get(j).size;
                if (j < sizeList.size() - 1) {
                    p += ", ";
                }
            }
            System.out.println((i + 1) + ". " + pizzaFlavourList.get(i).flavour + p + ").");
        }
        this.flavourChoice = sc.nextInt() - 1;
        if (this.flavourChoice > pizzaFlavourList.size() || this.flavourChoice < 0) {
            System.out.println("Please enter correct option");
            return;
        }
        System.out.println("Pizza can have following toppings.");
        for (int i = 0; i < toppingList.size(); i++) {
            System.out.println((i + 1) + ". " + toppingList.get(i).topping + " (" + toppingList.get(i).price + " USD)");
        }
        System.out.println("Out of " + toppingList.size() + " How many toppings you want");
        this.noOfToppings = sc.nextInt();
        if (this.noOfToppings > toppingList.size() || this.noOfToppings < 0) {
            System.out.println("Please enter correct option");
            return;
        }
        this.toppings = new Topping[this.noOfToppings];
        System.out.println("Enter toppings");
        for (int i = 0; i < this.noOfToppings; i++) {
            this.toppings[i] = toppingList.get(sc.nextInt() - 1);
        }

        this.placeOrder();

    }

    @Override
    public void placeOrder() {
        Order order = new Order("Pizza", sizeList.get(this.sizeChoice), pizzaCrust.get(this.crustChoice),
                pizzaFlavourList.get(this.flavourChoice), this.toppings);
        order.caculatePrice();
        Restaurant.orders.add(order);

        System.out.println("Order placed successfully !!");

        // for (Order o : Restaurant.orders) {
        // System.out.println(o.toString());
        // }

    }

}
