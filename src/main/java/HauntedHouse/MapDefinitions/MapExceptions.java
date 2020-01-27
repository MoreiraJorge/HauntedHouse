package HauntedHouse.MapDefinitions;

import HauntedHouse.Generated;

public class MapExceptions extends Exception {

    public static final String ROOM_NOT_LOADED = "O quarto não existe.";

    @Generated
    public MapExceptions() {
    }
    @Generated
    public MapExceptions(String message) {
        super(message);
    }

}
