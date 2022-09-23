import occupancyPackage.Occupancy;

public class Room {
    String floorNo;
    int doorNo;
    Occupancy roomType;
    boolean isBooked;
    boolean isACRoom;
    double estimatedPrice;

    Room(Occupancy roomType, boolean isACRoom, String floorNo, int doorNo) {
        this.roomType = roomType;
        this.isACRoom = isACRoom;
        this.floorNo = floorNo;
        this.doorNo = doorNo;
    }

    double getEstimatedPrice() {
        if (isACRoom) {
            return this.roomType.price + this.roomType.acPrice;
        }
        return this.roomType.price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    @Override
    public String toString() {
        String pString = "";
        pString += "Room number: " + this.doorNo + ", ";
        pString += "Floor number: " + this.floorNo + ", ";
        pString += "isACRoom: " + this.isACRoom + ", ";
        pString += "estimated: " + this.getEstimatedPrice();
        return pString;
    }

}
