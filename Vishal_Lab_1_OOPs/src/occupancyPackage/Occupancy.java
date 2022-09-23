package occupancyPackage;
public class Occupancy {
    boolean isACRoom;
    public double price;
    public double acPrice;
    public String name;

    Occupancy() {
        this.acPrice = 1000.00;
    }

    public boolean isACRoom() {
        return isACRoom;
    }

    public void setACRoom(boolean isACRoom) {
        this.isACRoom = isACRoom;
    }

}
