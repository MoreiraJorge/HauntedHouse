package HauntedHouse.Menu;

import HauntedHouse.Game.Difficulty;
import HauntedHouse.Game.Game;
import HauntedHouse.Game.Manual;
import HauntedHouse.Game.Simulation;
import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import Structures.Graph.GraphExceptions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class with menu operations
 *
 * @author Jorge, Miguel
 */
public class Menu {

    Scanner keyboard = new Scanner(System.in);

    private String name;
    private int points;
    private JSONArray map;
    private boolean mapLoaded;
    private int opt = 0;

    public Menu() {
        mapLoaded = false;
    }

    /**
     * method that loads the map information
     * from a json file given a
     *
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
            this.mapLoaded = true;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to know if the map has already been loaded
     *
     * @return boolean
     */
    public boolean isMapLoaded() {
        return mapLoaded;
    }

    /**
     * Method to create the network graph of the map
     *
     * @return Map
     * @throws MenuExceptions
     * @throws GraphExceptions
     * @throws MapExceptions
     */
    public Map createMapStructure() throws MenuExceptions, GraphExceptions, MapExceptions {
        if (isMapLoaded() == false) {
            throw new MenuExceptions(MenuExceptions.MAP_NOT_LOADED);
        }
        Map chosenMap = new Map(name, points);
        Iterator<JSONObject> itrJSon = map.iterator();

        while (itrJSon.hasNext()) {
            JSONObject tmpObject = itrJSon.next();

            String roomName = (String) tmpObject.get("aposento");
            long ghostCostLong = (long) tmpObject.get("fantasma");
            int ghostCost = Math.toIntExact(ghostCostLong);

            chosenMap.addRoomToMap(roomName, ghostCost);
        }

        itrJSon = map.iterator();

        while (itrJSon.hasNext()) {
            JSONObject tmpObject = itrJSon.next();
            String source = (String) tmpObject.get("aposento");
            JSONArray destArray = (JSONArray) tmpObject.get("ligacoes");
            Iterator<String> itrDest = destArray.iterator();

            while (itrDest.hasNext()) {
                String dest = itrDest.next();
                chosenMap.addConnectionsBetweenRooms(source, dest);
            }
        }

        return chosenMap;
    }

    /**
     * @throws MapExceptions
     * @throws MenuExceptions
     * @throws GraphExceptions
     * @throws IOException
     */
    public void mainMenu() throws MapExceptions, MenuExceptions, GraphExceptions, IOException {
        boolean exit = false;

        while (!exit) {

            System.out.println("1 - Jogar");
            System.out.println("2 - Consultar Classificações");
            System.out.println("3 - Sair");
            opt = keyboard.nextInt();

            switch (opt) {
                case 1:
                    chooseGameMenu(askMapPath());
                    break;
                case 2:
                    System.out.println("classificações");
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("opção inválida");
                    break;
            }
        }

    }

    /**
     * @throws IOException
     */
    private Map askMapPath() throws IOException, GraphExceptions, MenuExceptions, MapExceptions {
        System.out.println("Introduza o caminho do mapa: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        loadMapFile(input);
        return createMapStructure();
    }

    /**
     * @throws IOException
     * @throws GraphExceptions
     * @throws MenuExceptions
     * @throws MapExceptions
     */
    private void chooseGameMenu(Map map){
        String gameType = "";


        System.out.println("1 - Jogo Manual");
        System.out.println("2 - Simulação");
        System.out.println("3 - Voltar");
        opt = keyboard.nextInt();

        switch (opt) {
            case 1:
               difficultyManual(map);
                break;
            case 2:
                difficultySimulation(map);
                break;
            case 3:
                break;
        }

    }


    /**
     * @param map
     * @throws MapExceptions
     * @throws MenuExceptions
     * @throws GraphExceptions
     * @throws IOException
     */
    private void difficultyManual(Map map){
        Game manual;

        System.out.println("Escolha dificuldade: ");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        opt = keyboard.nextInt();

        switch (opt) {
            case 1:
                manual = new Manual(map, Difficulty.EASY);
                manual.startGame();
                System.out.println("manual easy");
                break;
            case 2:
                manual = new Manual(map, Difficulty.MEDIUM);
                manual.startGame();
                System.out.println("manual medium");
                break;
            case 3:
                manual = new Manual(map, Difficulty.HARD);
                manual.startGame();
                System.out.println("manual hard");
                break;
            default:
                chooseGameMenu(map);
                break;
        }

    }

    /**
     * @param map
     * @throws MapExceptions
     * @throws MenuExceptions
     * @throws GraphExceptions
     * @throws IOException
     */
    private void difficultySimulation(Map map){
        Game simulation;

        System.out.println("Escolha dificuldade: ");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        opt = keyboard.nextInt();

        switch (opt) {
            case 1:
                simulation = new Simulation(map, Difficulty.EASY);
                simulation.startGame();
                System.out.println("simulação easy");
                break;
            case 2:
                simulation = new Simulation(map, Difficulty.MEDIUM);
                simulation.startGame();
                System.out.println("simulação medium");
                break;
            case 3:
                simulation = new Simulation(map, Difficulty.HARD);
                simulation.startGame();
                System.out.println("simulação hard");
                break;
            default:
                chooseGameMenu(map);
                break;
        }
    }

}
