package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.Map;

/**
 *
 */
public class Simulation implements Game {

    private Map map;
    private int diff;
    private int points;

    /**
     *
     * @param mp
     * @param tmpDiff
     */
    public Simulation(Map mp, Difficulty tmpDiff ) {
        map = mp;
        diff = Difficulty.getDifficultyFactor(tmpDiff);
        this.points = map.getPoints();
    }


    @Override
    public void startGame() {

    }

    @Override
    public void showPlayerPoints() {

    }
}
