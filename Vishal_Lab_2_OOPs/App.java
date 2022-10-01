import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Pizza pizza = new Pizza();
        Pasta pasta = new Pasta();
        System.out.println("Welcome to pizza den. We server pizza and pasta. Press");
        while (true) {
            System.out.println("1 for Pizza");
            System.out.println("2 for Pasta");
            System.out.println("0 to Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    pizza.showMenu();
                    break;
                case 2:
                    pasta.showMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please choose correct option");
                    return;
            }
            System.out.println("1. Do you wish to order more ?");
            System.out.println("2. Place order");
            int orderChoice = sc.nextInt();
            switch (orderChoice) {
                case 1:
                    continue;
                case 2:
                    new Kitchen().prepare();
                    System.out.println("Please pay " + Restaurant.totalPrice + " USD for your order. \n");
            }
        }
    }
}
