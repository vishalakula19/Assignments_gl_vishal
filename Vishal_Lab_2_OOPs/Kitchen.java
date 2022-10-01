import java.util.List;

public class Kitchen extends Restaurant {
    List<Order> orderList = Restaurant.orders;
    void prepare(){
        for(Order o : this.orderList){
            if(o.dishName == "Pizza"){
                preparePizza(o);
            }
            else if(o.dishName == "Pasta"){
                preparePasta(o);
            }
        }
    }

    void preparePizza(Order order){
        System.out.println("Preparing Pizza!!");
        Restaurant.orderReady(order);

    }

    void preparePasta(Order order){
        System.out.println("Preparing Pasta!!");
        Restaurant.orderReady(order);
    }

    

    
}
