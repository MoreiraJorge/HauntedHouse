package HauntedHouse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

/**
 * Class with menu operations
 * @author Jorge, Miguel
 */
public class Menu {

    private String name;
    private int points;
    private JSONArray map;
    private boolean mapLoaded;

    public Menu() {
        mapLoaded = false;
    }

    /**
     * method that loads the map information
     * from a json file given a
     * @param fileLocation file location
     * @return true if the map is loaded,
     * or false if it is invalid
     */
    public boolean loadMapFile(String fileLocation) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileLocation));
            JSONObject jsonObject = (JSONObject) obj;

            name = (String) jsonObject.get("nome");
            long pointLong = (long) jsonObject.get("pontos");
            points = Math.toIntExact(pointLong);

            map = (JSONArray) jsonObject.get("mapa");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMapLoaded() {
        return mapLoaded;
    }
}
