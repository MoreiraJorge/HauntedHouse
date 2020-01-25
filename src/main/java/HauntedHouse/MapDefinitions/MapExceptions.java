package HauntedHouse.MapDefinitions;

public class MapExceptions extends Exception {

    public static final String ROOM_NOT_LOADED = "O quarto não existe.";

    public MapExceptions() {
    }

    public MapExceptions(String message) {
        super(message);
    }

}
