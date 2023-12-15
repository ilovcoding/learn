package graph;

import java.util.ArrayList;

public class Node {
    public int value;
    // 入度
    public int in;
    // 出度
    public int out;
    // 节点出发的下一个节点的集合
    public ArrayList<Node> nexts;
    // 节点出发的的边的集合
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}
