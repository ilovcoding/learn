package tree_traversal;

public class CompleteBinaryTree {
    public CompleteBinaryTree() {
    }

    public int countTreeNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countTreeNodes(root.left) + countTreeNodes(root.right);
    }

    boolean isCompleteBinaryTree(Node node, int index, int nodesCount) {
        if (node == null) {
            return true;
        }
        if (index >= nodesCount) {
            return false;
        }
        return isCompleteBinaryTree(node.left, 2 * index + 1, nodesCount) && isCompleteBinaryTree(node.right, 2 * index + 2, nodesCount);
    }

    public static void main(String[] args) {
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
//        root.left.right = new Node(5);
        boolean isCompleteTree = completeBinaryTree.isCompleteBinaryTree(root, 0, completeBinaryTree.countTreeNodes(root));
        System.out.println(isCompleteTree);
    }
}
