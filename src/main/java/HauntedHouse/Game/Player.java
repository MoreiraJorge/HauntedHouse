package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.Room;
import Structures.Stack.EmptyCollectionException;
import Structures.Stack.LinkedStack;
import Structures.Stack.StackADT;

/**
 * Player definition class
 *
 * @author Jorge, Miguel
 */
public class Player {

    /**
     * The player name
     */
    private String name;

    /**
     * The player points
     */
    private int playerPoints = 0;

    /**
     * Player flashbacks
     */
    private StackADT<Room> flashBack = new LinkedStack();

    /**
     * Player constructor
     *
     * @param tmpName
     * @param mapPoints
     */
    public Player(String tmpName, int mapPoints, Room room) {
        name = tmpName;
        playerPoints = mapPoints;
        flashBack.push(room);
    }

    /**
     * Method to get player points
     *
     * @return
     */
    public int getPlayerPoints() {
        return playerPoints;
    }

    /**
     * Method to set player points
     *
     * @param playerPoints
     */
    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    /**
     * Method to move player on map
     *
     * @param room
     */
    public void makeMove(Room room) {
        flashBack.push(room);
    }

    /**
     * Method to get the player current location
     *
     * @return Room
     * @throws EmptyCollectionException
     */
    public Room getCurrentRoom() throws EmptyCollectionException {
        return flashBack.peek();
    }

    /**
     * Gets the player name
     * @return
     */
    public String getName() {
        return name;
    }
}
