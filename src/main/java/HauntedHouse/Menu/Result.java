package HauntedHouse.Menu;

/**
 *
 */
public class Result implements Comparable {

    /**
     *
     */
    String playerName;

    /**
     *
     */
    int playerPoints;

    /**
     *
     * @param playerName
     * @param playerPoints
     */
    public Result(String playerName, int playerPoints) {
        this.playerName = playerName;
        this.playerPoints = playerPoints;
    }

    @Override
    public int compareTo(Object o) {
        try{
            Result tmp = (Result) o;
            if(this.playerPoints > tmp.playerPoints){
                return -1;
            } else if(this.playerPoints < tmp.playerPoints){
                return 1;
            }
           return 0;
        } catch (Exception e){
            throw new ClassCastException();
        }
    }
}
