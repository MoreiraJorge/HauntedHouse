package HauntedHouse.PlayerTests;

import HauntedHouse.Game.Player;
import HauntedHouse.MapDefinitions.Room;
import Structures.Stack.EmptyCollectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class makeMoveTest {

    Player player;
    Room oldRoom;
    Room newRoom;

    @Test
    public void makeMoveTest() throws EmptyCollectionException {
        oldRoom = new Room("Entrada", 0);
        player = new Player("Mario", 100, oldRoom);
        newRoom = new Room("Hall", 0);
        player.makeMove(newRoom);
        Assertions.assertEquals(newRoom, player.getCurrentRoom());
    }
}
