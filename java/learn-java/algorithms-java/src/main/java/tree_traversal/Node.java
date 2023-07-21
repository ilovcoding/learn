package tree_traversal;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public int height;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
        height = 1;
    }
}
