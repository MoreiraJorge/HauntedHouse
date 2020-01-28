package HauntedHouse.Game;

import HauntedHouse.MapDefinitions.MapExceptions;
import Structures.BinaryTree.BinaryTreeExceptions;
import Structures.Graph.GraphExceptions;
import Structures.Lists.ListExceptions;

import java.io.IOException;

/**
 *
 */
public interface Game {

    /**
     *
     */
    public void startGame() throws BinaryTreeExceptions, GraphExceptions, ListExceptions, IOException, MapExceptions;

    /**
     *
     */
    public void showPlayerPoints();
}
