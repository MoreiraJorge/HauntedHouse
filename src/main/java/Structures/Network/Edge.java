package Structures.Network;

public class Edge<T> {

    protected NetworkNode<T> nodeTo;
    protected double weight;

    public Edge(NetworkNode<T> nodeTo, double weight) {
        this.nodeTo = nodeTo;
        this.weight = weight;
    }
}
