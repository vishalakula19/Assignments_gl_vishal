import java.util.ArrayList;

public class Restaurant {

    static ArrayList<Order> orders = new ArrayList<>();
    static double totalPrice = 0;

    static void orderReady(Order o) {
        if (o.dishName == "Pizza") {
            String s = "";
            for(int i=0;i<o.topping.length;i++){
                s += o.topping[i].topping;
                if(i < o.topping.length-1){
                    s += ", ";
                }
            }
            System.out.println(o.flavour.flavour + " " + o.size.size + " " + o.type.type + " " + o.dishName + " with " + s + " is ready !!");

        } else if (o.dishName == "Pasta") {
            System.out.println(o.flavour.flavour + " " + o.type.type + " " + o.dishName + " is ready !!");
        }
        Restaurant.totalPrice += o.getPrice();
    }

}
