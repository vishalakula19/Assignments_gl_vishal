import java.util.ArrayList;

import occupancyPackage.DoubleOccupancy;
import occupancyPackage.SingleOccupancy;
import occupancyPackage.TripleOccupancy;

public class Hotel {
    ArrayList<Room> roomList = new ArrayList<Room>();

    Hotel() {
        roomList.add(new Room(new SingleOccupancy(), true, "First", 101));
        roomList.add(new Room(new DoubleOccupancy(), true, "First", 102));
        roomList.add(new Room(new DoubleOccupancy(), false, "First", 103));
        roomList.add(new Room(new SingleOccupancy(), true, "Second", 201));
        roomList.add(new Room(new SingleOccupancy(), false, "Second", 202));
        roomList.add(new Room(new DoubleOccupancy(), true, "Second", 203));
        roomList.add(new Room(new TripleOccupancy(), true, "Second", 204));
    }

    String bookRoom(String occupancy, boolean needAC, String floor) {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            String floorNeeded = floor;
            if (floor.isEmpty()) {
                floorNeeded = room.floorNo;
            }
            if (!room.isBooked) {
                if (occupancy.equals(room.roomType.name) && room.isACRoom == needAC
                        && floorNeeded.equals(room.floorNo)) {
                    room.setBooked(true);
                    return room.toString();
                }

            }
        }
        return "Room not available";
    }

}
