package tree_traversal;

import java.util.Map;

public class PerfectBinaryTree {

    public PerfectBinaryTree() {
    }

    class TreeNodeInfo {
        //        当前节点的高度
        public int height;
        public boolean isPrefectBinaryTree;

        public TreeNodeInfo(int height, boolean isPrefectBinaryTree) {
            this.height = height;
            this.isPrefectBinaryTree = isPrefectBinaryTree;
        }
    }


    public TreeNodeInfo process(Node node) {
        if (node == null) {
            return new TreeNodeInfo(0, true);
        }
        if (node.left == null && node.right == null) {
            return new TreeNodeInfo(0, true);
        }
        if (node.left != null && node.right != null) {
            TreeNodeInfo leftInfo = process(node.left);
            TreeNodeInfo rightInfo = process(node.right);
            int leftHeight = leftInfo.height + 1;
            int rightHeight = rightInfo.height + 1;
            boolean isPrefectBinaryTree = leftHeight == rightHeight && leftInfo.isPrefectBinaryTree && rightInfo.isPrefectBinaryTree;
            return new TreeNodeInfo(Math.max(leftHeight, rightHeight), isPrefectBinaryTree);
        } else {
            return new TreeNodeInfo(0, false);
        }
    }

    public boolean isPrefectBinaryTree(Node root) {
        return process(root).isPrefectBinaryTree;
    }

    public static void main(String[] args) {
        PerfectBinaryTree perfectBinaryTree = new PerfectBinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
//        root.right.left = new Node(6);
        root.right.right = new Node(7);
        if (perfectBinaryTree.isPrefectBinaryTree(root) == true)
            System.out.println("The tree is a perfect binary tree");
        else
            System.out.println("The tree is not a perfect binary tree");
    }
}
