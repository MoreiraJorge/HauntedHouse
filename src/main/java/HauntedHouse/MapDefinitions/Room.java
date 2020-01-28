package HauntedHouse.MapDefinitions;

import HauntedHouse.Generated;
import Structures.Lists.ListExceptions;
import Structures.Lists.UnorderedArray;
import Structures.Lists.UnorderedListADT;

import java.util.Iterator;

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
    @Generated
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
    @Generated
    public String getRoomName() {
        return roomName;
    }

    /**
     * Method to return the cost of the ghost
     *
     * @return Cost of Ghost
     */
    @Generated
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
     * Method to obtain the connections of a Room
     *
     * @return Connections
     */
    @Generated
    public Iterator<Room> getConnectionsIterator() {
        return connections.iterator();
    }

    /**
     * Method that returns number of doors
     *
     * @return number of doors
     */
    public int numberOfDoors() {
        return connections.size();
    }

    /**
     * Method to return String representation of all information about room
     *
     * @param viewGhost
     * @return
     */
    @Generated
    public String toString(boolean viewGhost) {
        String text = "" + this.getRoomName();
        text += "\nPortas : ";
        Iterator<Room> doors = connections.iterator();
        while (doors.hasNext()) {
            Room currentDoor = doors.next();
            text += "\n- " + currentDoor.toString();
            if (viewGhost && currentDoor.getGhostCost() != 0) {
                text += " ->" + " Ghost Damage : " + currentDoor.getGhostCost();
            }
            text += ";";
        }
        return text;
    }

    @Generated
    @Override
    public String toString() {
        return roomName;
    }
}
