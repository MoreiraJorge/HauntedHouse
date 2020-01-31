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
     * Number of available flashbacks
     */
    private int numberOfFlashBacks;

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
        this.numberOfFlashBacks = 3;
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

    /**
     * Method to use flashback ability
     *
     * @param Diff difficulty
     * @throws PlayerExceptions
     * @throws EmptyCollectionException
     */
    public void useFlashBack(int Diff) throws PlayerExceptions, EmptyCollectionException {
        if (flashBack.size() > 1) {
            if (numberOfFlashBacks > 0) {
                Room tmpRoom = flashBack.pop();
                this.playerPoints = this.playerPoints + (tmpRoom.getGhostCost() * Diff);
                numberOfFlashBacks--;
            } else {
                throw new PlayerExceptions(PlayerExceptions.NUMBER_OF_FLASHBACK_IS_ZERO);
            }
        } else {
            throw new PlayerExceptions(PlayerExceptions.FLASHBACK_CANNOT_BE_USED);
        }
    }

}
