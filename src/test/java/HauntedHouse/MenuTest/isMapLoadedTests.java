package HauntedHouse.MenuTest;

import HauntedHouse.Menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests class for method isMapLoaded
 *
 * @author Miguel
 */
public class isMapLoadedTests {

    Menu menu;
    String fileLocation;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        menu = new Menu();
    }

    /**
     * Test if the method isMapLoaded returns false
     * when trying to load a valid map file
     * in a invalid location
     */
    @Test
    public void IsMapLoadedWhenInvalid() {
        fileLocation = "maps/x.json";
        menu.loadMapFile(fileLocation);
        Assertions.assertFalse(menu.isMapLoaded());
    }

    /**
     * Test if the method isMapLoaded returns true
     * when trying to load a valid map file
     * in a valid location
     */
    @Test
    public void IsMapLoadedWhenValid() {
        fileLocation = "maps/mapa.json";
        menu.loadMapFile(fileLocation);
        Assertions.assertTrue(menu.isMapLoaded());
    }
}