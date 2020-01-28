package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.Room;
import Structures.Stack.LinkedStack;
import Structures.Stack.StackADT;

/**
 *
 */
public class Player {

    /**
     *
     */
    String name;

    /**
     *
     */
    int playerPoints = 0;

    /**
     *
     */
    StackADT<Room> flashBack = new LinkedStack();

    /**
     *
     * @param tmpName
     * @param mapPoints
     */
    public Player(String tmpName, int mapPoints, Room room){
        name = tmpName;
        playerPoints = mapPoints;
        flashBack.push(room);
    }

}
