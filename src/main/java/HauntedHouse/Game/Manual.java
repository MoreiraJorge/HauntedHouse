package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.MapExceptions;
import HauntedHouse.MapDefinitions.Room;
import HauntedHouse.Menu.Ratings;
import HauntedHouse.Menu.Result;
import Structures.Lists.ListExceptions;
import Structures.Stack.EmptyCollectionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Manual Gamemode class
 *
 * @author Jorge, Miguel
 */
public class Manual implements Game {

    private Map map;
    private int diff;
    private Player player;

    /**
     * Manual Gamemode constructor
     *
     * @param mp
     * @param tmpDiff
     */
    public Manual(Map mp, Difficulty tmpDiff) throws IOException {
        map = mp;
        diff = Difficulty.getDifficultyFactor(tmpDiff);
        System.out.println("Introduza o nome do jogador: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Room entrance = map.getEntrance();
        player = new Player(input, map.getPoints(), entrance);
    }

    @Override
    public void startGame() throws EmptyCollectionException, IOException, MapExceptions, ListExceptions {
        Room currentRoom = player.getCurrentRoom();

        System.out.println("------------------------------------------------");
        System.out.println("Começo do Jogo : \n");
        while (true) {
            map.printMapFromRoom(currentRoom.toString(), true);
            System.out.println();
            this.showPlayerPoints();
            System.out.println("------------------------------------------------");
            askNextRoom();
            currentRoom = player.getCurrentRoom();
            if (currentRoom.getRoomName().equalsIgnoreCase(Map.EXIT)) {
                break;
            }
            System.out.println("------------------------------------------------");
        }

        System.out.println("\nFinal do jogo. Pontuação Final : " + this.player.getPlayerPoints() + "\n");

        Result result = new Result(player.getName(),player.getPlayerPoints());
        Ratings.addResult(result);
        Ratings.writeToRatingsFile(map.getTitle(),diff);
    }

    /**
     * Method to ask the player for their next move
     *
     * @throws IOException
     * @throws EmptyCollectionException
     */
    private void askNextRoom() throws IOException, EmptyCollectionException {
        System.out.println("Introduza o nome da sala onde deseja ir: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Iterator<Room> connectedRoomsItr = player.getCurrentRoom().getConnectionsIterator();
        Room selectedRoom = null;
        boolean found = false;

        while (connectedRoomsItr.hasNext() && !found) {
            Room tmpRoom = connectedRoomsItr.next();
            if (tmpRoom.getRoomName().equalsIgnoreCase(input)) {
                selectedRoom = tmpRoom;
                found = true;
            }
        }

        if (found) {
            player.makeMove(selectedRoom);
            player.setPlayerPoints(player.getPlayerPoints() - (diff * selectedRoom.getGhostCost()));
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    @Override
    public void showPlayerPoints() {
        System.out.println("Pontuação Atual: " + player.getPlayerPoints());
    }
}
