package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.Room;
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
    String name;

    /**
     * The player points
     */
    int playerPoints = 0;

    /**
     * Player flashbacks
     */
    StackADT<Room> flashBack = new LinkedStack();

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

}
