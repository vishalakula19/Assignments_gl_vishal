import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);
        int choice;
        String occupancy = "";
        int acChoice;
        boolean needAC = false;
        int floorChoice;
        String floor = "";
        do {
            System.out.println("Please enter the type of room you need: ");
            System.out.println("1. Single Occupancy");
            System.out.println("2. Double Occupancy");
            System.out.println("3. Triple Occupancy");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    occupancy = "Single Occupancy";
                    break;
                case 2:
                    occupancy = "Double Occupancy";
                    break;
                case 3:
                    occupancy = "Triple Occupancy";
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please enter a valid choice");
                    return;
            }
            System.out.println("Do you need AC?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            acChoice = sc.nextInt();
            switch (acChoice) {
                case 1:
                    needAC = true;
                    break;
                case 2:
                    needAC = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    return;
            }
            System.out.println("Any floor preference?");
            System.out.println("1. First Floor");
            System.out.println("2. Second Floor");
            System.out.println("3. Any Floor");
            floorChoice = sc.nextInt();
            switch (floorChoice) {
                case 1:
                    floor = "First";
                    break;
                case 2:
                    floor = "Second";
                    break;
                case 3:
                    floor = "";
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    return;
            }
            System.out.println(hotel.bookRoom(occupancy, needAC, floor));
        } while (true);

    }
}