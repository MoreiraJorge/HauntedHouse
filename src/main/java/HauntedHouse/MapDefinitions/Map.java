package HauntedHouse.MapDefinitions;

import Structures.Graph.GraphExceptions;
import Structures.Lists.UnorderedArray;
import Structures.Lists.UnorderedListADT;
import Structures.Network.NetworkInList;

import java.util.Iterator;

/**
 * Map definition class
 *
 * @author Jorge, Miguel
 */
public class Map {

    private static final String ENTRANCE = "entrada";
    private static final String EXIT = "exterior";
    private String title;
    private int points;
    private NetworkInList<Room> networkMap;
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
        this.points = points;
        this.networkMap = new NetworkInList();
        this.addedRooms = new UnorderedArray<>();
        this.entrance = new Room(ENTRANCE, 0);
        this.exit = new Room(EXIT, 0);
        this.networkMap.addVertex(entrance);
        this.networkMap.addVertex(exit);
        this.addedRooms.addToRear(entrance);
        this.addedRooms.addToRear(exit);
    }

    /**
     * Method for adding rooms to the map
     */
    public void addRoomToMap(String roomName, int ghostCost) {
        Room room = new Room(roomName, ghostCost);
        addedRooms.addToRear(room);
        networkMap.addVertex(room);
    }

    /**
     * Method for adding connections between rooms
     *
     * @param source      connection starting point
     * @param destination connection arrival point
     * @throws MapExceptions
     * @throws GraphExceptions
     */
    public void addConnectionsBetweenRooms(String source, String destination) throws MapExceptions, GraphExceptions {
        Room sourceRoom = getRoomFromName(source);
        Room destRoom = getRoomFromName(destination);

        networkMap.addEdge(sourceRoom, destRoom, destRoom.getGhostCost());
        sourceRoom.addConnection(destRoom);

        if (destRoom.getRoomName().equals(ENTRANCE) || destRoom.getRoomName().equals(EXIT)) {
            networkMap.addEdge(destRoom, sourceRoom, sourceRoom.getGhostCost());
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

    @Override
    public String toString() {
        return networkMap.toString();
    }
}
