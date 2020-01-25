package HauntedHouse.Menu;

public class MenuExceptions extends Exception {

    public static final String MAP_NOT_LOADED = "O mapa ainda não foi carregado.";

    public MenuExceptions() {
    }

    public MenuExceptions(String message) {
        super(message);
    }
}
