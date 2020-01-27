package HauntedHouse.MapDefinitions;

import HauntedHouse.Generated;
import Structures.Graph.GraphExceptions;
import Structures.Lists.UnorderedArray;
import Structures.Lists.UnorderedListADT;

import java.util.Iterator;

/**
 * Map definition class
 *
 * @author Jorge, Miguel
 */
public class Map {

    public static final String ENTRANCE = "entrada";
    public static final String EXIT = "exterior";
    private String title;
    private int points;
    private UnorderedListADT<Room> addedRooms;
    private Room entrance;
    private Room exit;

    /**
     * Default Construtor
     *
     * @param title  name of map
     * @param points Points
     */
    public Map(String title, int points) {
        this.title = title;
        this.addedRooms = new UnorderedArray<>();
        this.entrance = new Room(ENTRANCE, 0);
        this.exit = new Room(EXIT, 0);
        this.addedRooms.addToRear(entrance);
        this.addedRooms.addToRear(exit);
    }

    /**
     * Method to obtain the name of the map
     *
     * @return title
     */
    @Generated
    public String getTitle() {
        return title;
    }

    /**
     * Method to obtain the aumount of points of the map
     *
     * @return points
     */
    @Generated
    public int getPoints() {
        return points;
    }

    /**
     * Method for adding rooms to the map
     */
    public void addRoomToMap(String roomName, int ghostCost) {
        Room room = new Room(roomName, ghostCost);
        addedRooms.addToRear(room);
    }

    /**
     * Method for adding connections between rooms
     *
     * @param source      connection starting point
     * @param destination connection arrival point
     * @throws MapExceptions
     * @throws GraphExceptions
     */
    public void addConnectionsBetweenRooms(String source, String destination) throws MapExceptions {
        Room sourceRoom = getRoomFromName(source);
        Room destRoom = getRoomFromName(destination);

        sourceRoom.addConnection(destRoom);

        if (destRoom.getRoomName().equals(ENTRANCE) || destRoom.getRoomName().equals(EXIT)) {
            destRoom.addConnection(sourceRoom);
        }
    }

    /**
     * Method to find the room by name
     *
     * @param roomName room name
     * @return Room room
     * @throws MapExceptions
     */
    @Generated
    private Room getRoomFromName(String roomName) throws MapExceptions {
        boolean found = false;
        Room room = null;
        Iterator<Room> searchItr = addedRooms.iterator();

        while (!found && searchItr.hasNext()) {
            Room tmp = searchItr.next();
            if (tmp.getRoomName().equals(roomName)) {
                room = tmp;
                found = true;
                break;
            }
        }

        if (found == false) {
            throw new MapExceptions(MapExceptions.ROOM_NOT_LOADED);
        }

        return room;
    }

    /**
     * Method to obtain the list of rooms of the map
     *
     * @return List of Rooms In Map
     */
    @Generated
    public Iterator<Room> getAddedRoomsIterator() {
        return addedRooms.iterator();
    }

    @Generated
    @Override
    public String toString() {
        return addedRooms.toString();
    }
}
