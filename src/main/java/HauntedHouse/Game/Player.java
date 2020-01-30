package HauntedHouse.Game;

import HauntedHouse.Generated;
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
    private int playerPoints;

    /**
     * Player flashbacks
     */
    private StackADT<Room> flashBack = new LinkedStack();

    /**
     * Player constructor
     *
     * @param name
     * @param mapPoints
     */
    @Generated
    public Player(String name, int mapPoints, Room room) {
        this.name = name;
        this.playerPoints = mapPoints;
        this.flashBack.push(room);
    }

    /**
     * Gets the player name
     *
     * @return
     */
    @Generated
    public String getName() {
        return name;
    }

    /**
     * Method to get player points
     *
     * @return
     */
    @Generated
    public int getPlayerPoints() {
        return playerPoints;
    }

    /**
     * Method to set player points
     *
     * @param playerPoints
     */
    @Generated
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
    @Generated
    public Room getCurrentRoom() throws EmptyCollectionException {
        return flashBack.peek();
    }


}
