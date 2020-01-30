package HauntedHouse.MapFileTests;

import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import HauntedHouse.Menu.MapFile;
import HauntedHouse.Menu.MenuExceptions;
import Structures.Graph.GraphExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for createMapStructure method
 * @author Jorge , Miguel
 */
public class createMapStructureTests {
    MapFile mapFile;
    Map map;

    /**
     * test cases setup
     */
    @BeforeEach
    public void testSetup() {
        mapFile = new MapFile();
    }

    /**
     * test if an exception is thrown when the map
     * is invalid
     */
    @Test
    public void TestCreateAnInvalidMapStructure(){
        Assertions.assertThrows(MenuExceptions.class, () ->{
            mapFile.createMapStructure();
        });
    }

    /**
     * test if the map structure is created when a valid map
     * is loaded
     * @throws GraphExceptions
     * @throws MenuExceptions
     * @throws MapExceptions
     */
    @Test
    public void TestCreateAValidMapStructure() throws GraphExceptions, MenuExceptions, MapExceptions {
        mapFile.loadMapFile("maps/mapa.json");
        map = mapFile.createMapStructure();
        Assertions.assertNotNull(map);
    }



}
