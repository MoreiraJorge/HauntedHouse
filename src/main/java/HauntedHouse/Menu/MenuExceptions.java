package HauntedHouse.Menu;

import HauntedHouse.Generated;

/**
 * Class with exceptions to be used on Menu
 *
 * @author Jorge , Miguel
 */
public class MenuExceptions extends Exception {

    /**
     * message for non loaded map
     */
    public static final String MAP_NOT_LOADED = "O mapa não foi carregado.";

    @Generated
    public MenuExceptions() {
    }

    @Generated
    public MenuExceptions(String message) {
        super(message);
    }
}
