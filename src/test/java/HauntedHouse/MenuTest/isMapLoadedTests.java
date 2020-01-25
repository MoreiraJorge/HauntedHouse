package HauntedHouse.MenuTest;

import HauntedHouse.Menu;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests class for method isMapLoaded
 * @author Miguel
 */
public class isMapLoadedTests {

    Menu menu;
    String fileLocation;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup(){
        menu = new Menu();
    }

    @Test
    public void IsMapLoadedWhenInvalid(){
        fileLocation = "maps/x.json";
        menu.loadMapFile(fileLocation);
        Assertions.assertFalse(menu.isMapLoaded());
    }
}
