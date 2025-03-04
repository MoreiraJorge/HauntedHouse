package Structures.Network;

/**
 * Edge class that defines graph edges
 * @param <T> the type for the edge
 */
public class Edge<T> {

    protected NetworkNode<T> nodeTo;
    protected double weight;

    public Edge(NetworkNode<T> nodeTo, double weight) {
        this.nodeTo = nodeTo;
        this.weight = weight;
    }
}
