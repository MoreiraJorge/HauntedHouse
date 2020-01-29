package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.Map;
import HauntedHouse.MapDefinitions.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    public void startGame(){

    }

    @Override
    public void showPlayerPoints() {
    }
}
