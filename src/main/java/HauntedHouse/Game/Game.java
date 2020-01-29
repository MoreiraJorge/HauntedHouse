package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.MapExceptions;
import Structures.BinaryTree.BinaryTreeExceptions;
import Structures.Graph.GraphExceptions;
import Structures.Lists.ListExceptions;

import java.io.IOException;

/**
 * interface with methods that are used in both
 * Manual and Simulation
 *
 * @author Jorge , Miguel
 */
public interface Game {

    /**
     * Method used to start the game
     */
    public void startGame() throws BinaryTreeExceptions, GraphExceptions, ListExceptions, IOException, MapExceptions;

    /**
     * method used to show the current player
     * points
     */
    public void showPlayerPoints();
}
