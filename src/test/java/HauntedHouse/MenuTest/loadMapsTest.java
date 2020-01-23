package HauntedHouse.MenuTest;

import HauntedHouse.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class loadMapsTest {

    Menu menu;
    String fileLocation;

    @BeforeEach
    public void testSetup(){
        menu = new Menu();
    }

    @Test
    public void loadMapWhenFileLocationIsValid(){
        fileLocation = "maps/mapa.json";
        Assertions.assertTrue(menu.loadMap(fileLocation));
    }

    @Test
    public void loadMapWhenFileLocationIsInValid(){
        fileLocation = "maps/x.json";
        Assertions.assertFalse(menu.loadMap(fileLocation));
    }
}
