package HauntedHouse.Game;

/**
 *
 */
public enum Difficulty {
    EASY, MEDIUM, HARD;

    /**
     * @param diff
     * @return
     */
    public static int getDifficultyFactor(Difficulty diff) {
        int factor = 0;
        switch (diff) {
            case EASY:
                factor = 1;
                break;

            case MEDIUM:
                factor = 2;
                break;

            case HARD:
                factor = 3;
                break;
        }
        return factor;
    }
}