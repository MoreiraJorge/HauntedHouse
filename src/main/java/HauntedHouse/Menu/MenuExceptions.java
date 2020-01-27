package HauntedHouse.Menu;

import HauntedHouse.Generated;

public class MenuExceptions extends Exception {

    public static final String MAP_NOT_LOADED = "O mapa ainda não foi carregado.";

    @Generated
    public MenuExceptions() {
    }

    @Generated
    public MenuExceptions(String message) {
        super(message);
    }
}
