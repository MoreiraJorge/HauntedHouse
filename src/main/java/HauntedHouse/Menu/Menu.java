package HauntedHouse.Menu;

import HauntedHouse.Game.Difficulty;
import HauntedHouse.Game.Game;
import HauntedHouse.Game.Manual;
import HauntedHouse.Game.Simulation;
import HauntedHouse.Generated;
import HauntedHouse.MapDefinitions.Map;

import java.io.*;
import java.util.Scanner;

/**
 * Class with menu operations
 *
 * @author Jorge, Miguel
 */
@Generated
public class Menu {

    Scanner keyboard = new Scanner(System.in);
    private String opt = "";

    /**
     * Game main menu
     *
     * @throws IOException
     */
    public void mainMenu() throws IOException {
        boolean exit = false;
        Map map;


        while (!exit) {

            System.out.println("1 - Jogar");
            System.out.println("2 - Consultar Classificações");
            System.out.println("3 - Sair");

            opt = keyboard.nextLine();

            switch (opt) {
                case "1":
                    map = askMapPath();
                    if (map != null) {
                        chooseGameMenu(map);
                    }
                    break;
                case "2":
                    chooseDifficultyRatings(askMapRatings());
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    System.out.println("opção inválida");
                    break;
            }
        }
    }

    /**
     * Asks the user the game map path
     *
     * @return the game map
     */
    private Map askMapPath() {
        try {
            System.out.println("Introduza o caminho do mapa: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            MapFile mapFile = new MapFile();
            mapFile.loadMapFile(input);
            return mapFile.createMapStructure();
        } catch (Exception e) {
            System.out.println("Mapa Inválido");
            return null;
        }
    }

    /**
     * Asks the user what game type
     * he/she wants
     *
     * @param map the game map
     */
    private void chooseGameMenu(Map map) {
        boolean exit = false;

        try {
            while (!exit) {

                System.out.println("1 - Jogo Manual");
                System.out.println("2 - Simulação");
                System.out.println("3 - Voltar");
                opt = keyboard.nextLine();

                switch (opt) {
                    case "1":
                        difficultyManual(map);
                        break;
                    case "2":
                        difficultySimulation(map);
                        break;
                    case "3":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * Asks the user the difficulty of
     * the game in manual and starts
     *
     * @param map
     */
    private void difficultyManual(Map map) {
        Game manual;
        boolean exit = false;

        try {
            while (!exit) {
                System.out.println("Escolha dificuldade: ");
                System.out.println("1 - Fácil");
                System.out.println("2 - Médio");
                System.out.println("3 - Difícil");
                System.out.println("4 - Voltar");
                opt = keyboard.nextLine();

                switch (opt) {
                    case "1":
                        manual = new Manual(map, Difficulty.EASY);
                        manual.startGame();
                        break;
                    case "2":
                        manual = new Manual(map, Difficulty.MEDIUM);
                        manual.startGame();
                        break;
                    case "3":
                        manual = new Manual(map, Difficulty.HARD);
                        manual.startGame();
                        break;
                    case "4":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Asks the user the difficulty of
     * the game in simulation and starts
     *
     * @param map game map
     */
    private void difficultySimulation(Map map) {
        Game simulation;
        boolean exit = false;

        try {
            while (!exit) {

                System.out.println("Escolha dificuldade: ");
                System.out.println("1 - Fácil");
                System.out.println("2 - Médio");
                System.out.println("3 - Difícil");
                System.out.println("4 - Voltar");
                opt = keyboard.nextLine();

                switch (opt) {
                    case "1":
                        simulation = new Simulation(map, Difficulty.EASY);
                        simulation.startGame();
                        break;
                    case "2":
                        simulation = new Simulation(map, Difficulty.MEDIUM);
                        simulation.startGame();
                        break;
                    case "3":
                        simulation = new Simulation(map, Difficulty.HARD);
                        simulation.startGame();
                        break;
                    case "4":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Asks the map name which will be used to check ratings
     */
    private String askMapRatings() throws IOException {
        System.out.println("Introduza o nome do mapa: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        return input;
    }

    /**
     * Asks the user the ratings from various game
     * difficulties of the map
     */
    private void chooseDifficultyRatings(String name) {
        String path = "ratings/" + name;
        boolean exit = false;

        while (!exit) {

            System.out.println("Escolha a tabela de resultados da dificuldade que deseja: ");
            System.out.println("1 - Fácil");
            System.out.println("2 - Médio");
            System.out.println("3 - Difícil");
            System.out.println("4 - Voltar");
            opt = keyboard.nextLine();

            switch (opt) {
                case "1":
                    Ratings.PrintRatingFile(path, 1);
                    break;
                case "2":
                    Ratings.PrintRatingFile(path, 2);
                    break;
                case "3":
                    Ratings.PrintRatingFile(path, 3);
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

}
