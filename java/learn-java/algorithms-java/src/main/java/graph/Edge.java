package graph;

public class Edge {
    public int weight;
    public Node from;
    public  Node t0;

    public Edge(int weight, Node from, Node t0) {
        this.weight = weight;
        this.from = from;
        this.t0 = t0;
    }
}
