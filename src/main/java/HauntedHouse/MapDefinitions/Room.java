package HauntedHouse.MapDefinitions;

import Structures.Lists.UnorderedArray;
import Structures.Lists.UnorderedListADT;

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

    public String getRoomName() {
        return roomName;
    }

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
}
