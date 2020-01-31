package HauntedHouse.PlayerTests;

import HauntedHouse.Game.Player;
import HauntedHouse.Game.PlayerExceptions;
import HauntedHouse.MapDefinitions.Room;
import Structures.Stack.EmptyCollectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class useFlashBackTests {

    Player player;
    Room oldRoom;
    Room newRoom;

    @BeforeEach
    public void testSetup() {
        oldRoom = new Room("Entrada", 0);
        player = new Player("Mario", 100, oldRoom);
        newRoom = new Room("Hall", 0);
    }

    @Test
    public void useFlashWhenSizeOfStackIsOneTest(){
        Assertions.assertThrows(PlayerExceptions.class, () ->{
            player.useFlashBack(1);
        });
    }

    @Test
    public void useFlashWhenValidTest() throws EmptyCollectionException, PlayerExceptions {
        player.makeMove(newRoom);
        player.useFlashBack(1);
        Assertions.assertEquals(player.getCurrentRoom(), oldRoom);
    }

    @Test
    public void useFlashWhenNumberOfFlashIsZeroTest() throws EmptyCollectionException, PlayerExceptions {
        player.makeMove(newRoom);
        player.useFlashBack(1);
        player.makeMove(newRoom);
        player.useFlashBack(1);
        player.makeMove(newRoom);
        player.useFlashBack(1);
        player.makeMove(newRoom);
        Assertions.assertThrows(PlayerExceptions.class, () ->{
            player.useFlashBack(1);
        });
    }
}
