package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.Map;

/**
 *
 */
public class Manual implements Game {

    private Map map;
    private int diff;

    /**
     *
     * @param mp
     * @param tmpDiff
     */
    public Manual(Map mp, Difficulty tmpDiff ) {
        map = mp;
        diff = Difficulty.getDifficultyFactor(tmpDiff);
    }

    @Override
    public void startGame() {
    }

    @Override
    public void showPlayerPoints() {
    }
}
