package HauntedHouse.MenuTest;

import HauntedHouse.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests class for method loadMap
 * @author Miguel
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class loadMapsToFileTest {

    Menu menu;
    String fileLocation;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup(){
        menu = new Menu();
    }

    /**
     * Test if the method loadMap returns true
     * when trying to load a valid map file
     * in a valid location
     */
    @Test
    public void loadMapWhenFileLocationIsValid(){
        fileLocation = "maps/mapa.json";
        Assertions.assertTrue(menu.loadMapFile(fileLocation));
    }

    /**
     * Test if the method loadMap returns false
     * when trying to load an invalid map file
     * in an invalid location
     */
    @Test
    public void loadMapWhenFileLocationIsInValid(){
        fileLocation = "maps/x.json";
        Assertions.assertFalse(menu.loadMapFile(fileLocation));
    }
}
