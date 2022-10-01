public class Order {
    String dishName;
    Size size;
    Type type;
    Flavour flavour;
    Topping[] topping;
    private double price = 0;

    public Order(String dishName, Size size, Type type, Flavour flavour, Topping[] topping) {
        this.dishName = dishName;
        this.size = size;
        this.type = type;
        this.flavour = flavour;
        this.topping = topping;
    }

    public Order(String dishName, Type type, Flavour flavour) {
        this.dishName = dishName;
        this.type = type;
        this.flavour = flavour;
    }

    public void caculatePrice() {
        double basePrice = this.flavour.basePrice;
        if (this.dishName == "Pizza") {
            if (this.size.size.equals("Small")) {
                this.price += basePrice;
            } else if (this.size.size.equals("Medium")) {
                this.price += basePrice * 2;
            } else if (this.size.size.equals("Large")) {
                this.price += basePrice * 3;
            }
            for (Topping t : topping) {
                this.price += t.price;
            }
        } else if (this.dishName == "Pasta") {
            this.price += basePrice;
        }

    }

    public double getPrice() {
        return price;
    }

}
