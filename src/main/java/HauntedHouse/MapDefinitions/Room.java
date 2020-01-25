package HauntedHouse.MapDefinitions;

/**
 * Room definition class
 *
 * @author Jorge, Miguel
 */
public class Room {

    private String roomName;
    private int ghostCost;

    /**
     * Constructor for a room
     *
     * @param roomName
     */
    public Room(String roomName, int ghostCost) {
        this.roomName = roomName;
        this.ghostCost = ghostCost;
    }

    /**
     * Method to get the room name
     *
     * @return Room name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Method to return the cost of the ghost
     *
     * @return Cost of Ghost
     */
    public int getGhostCost() {
        return ghostCost;
    }

    /**
     * If the room has a cost, it has a ghost
     *
     * @return true if the room has a ghost
     */
    public boolean hasGhost() {
        return (!(ghostCost == 0));
    }

    @Override
    public String toString() {
        return roomName;
    }
}
