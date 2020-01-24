package HauntedHouse.RoomTests;

import HauntedHouse.MapDefinitions.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests class for hasGhost method
 * @author Jorge, Miguel
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class hasGhostTests {
    Room room;

    @Test
    public void testIfRoomHasGhost(){
        room = new Room("Kitchen",5,15);
        Assertions.assertTrue(room.hasGhost());
    }

    @Test
    public void testIfRoomHasNoGhost(){
        room = new Room("Kitchen",5,0);
        Assertions.assertFalse(room.hasGhost());
    }
}
