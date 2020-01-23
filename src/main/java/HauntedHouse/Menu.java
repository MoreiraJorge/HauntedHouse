package HauntedHouse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class Menu {

    private String name;
    private int points;

    public boolean loadMap(String fileLocation) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileLocation));
            JSONObject jsonObject = (JSONObject) obj;

            name = (String) jsonObject.get("nome");
            long pointLong = (long) jsonObject.get("pontos");
            points = Math.toIntExact(pointLong);

            JSONArray map = (JSONArray) jsonObject.get("mapa");

            System.out.println("Nome: " + name);
            System.out.println("Pontos: " + points);
            System.out.print("Mapa: ");
            Iterator<JSONObject> iterator = map.iterator();
            while (iterator.hasNext()) {
                System.out.print("->" + iterator.next().get("aposento") + " ");
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
