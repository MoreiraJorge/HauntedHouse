package Structures.Network;

public class Pair<T> {

    protected Pair<T> previous;
    protected T vertex;
    protected double cost;

    public Pair(Pair<T> previous, T vertex, double cost) {
        this.previous = previous;
        this.vertex = vertex;
        this.cost = cost;
    }
}
