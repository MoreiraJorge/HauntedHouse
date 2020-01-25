package HauntedHouse.MapDefinitions;

import Structures.Lists.ListExceptions;
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
    private UnorderedListADT<Room> connections;

    /**
     * Constructor for a room
     *
     * @param roomName
     */
    public Room(String roomName, int ghostCost) {
        this.roomName = roomName;
        this.ghostCost = ghostCost;
        this.connections = new UnorderedArray();
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

    /**
     * Method to add a connection between rooms
     *
     * @param room
     */
    public void addConnection(Room room) {
        connections.addToRear(room);
    }

    /**
     * Method to remove a connection between rooms
     *
     * @param room
     * @throws ListExceptions
     */
    public void removeConnection(Room room) throws ListExceptions {
        connections.remove(room);
    }

    /**
     * Method to check if this room has a connection to another
     *
     * @param room
     * @return boolean
     */
    public boolean hasConnection(Room room) {
        return connections.contains(room);
    }

    /**
     * Method that returns number of doors
     * @return number of doors
     */
    public int numberOfDoors(){
        return connections.size();
    }

    @Override
    public String toString() {
        return roomName;
    }
}
