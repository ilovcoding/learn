package tree_traversal;

public class BalancedBinaryTree {

    class TreeNodeInfo {
        //        当前节点的高度
        public int height;
        public boolean isBalanceBinaryTree;

        public TreeNodeInfo(int height, boolean isBalanceBinaryTree) {
            this.height = height;
            this.isBalanceBinaryTree = isBalanceBinaryTree;
        }
    }

    public TreeNodeInfo process(Node node) {
        if (node == null) {
            return new TreeNodeInfo(-1, true);
        }
        TreeNodeInfo left = process(node.left);
        TreeNodeInfo right = process(node.right);
        // 当前节点的高度是子节点的高度最大值 +1
        int treeHeight = Math.max(left.height, right.height) + 1;
//        需要左子树和右子树都是平衡数，而且左子树和右子树的高度差不超过1
        boolean isBalancedTree = left.isBalanceBinaryTree && right.isBalanceBinaryTree && Math.abs(left.height - right.height) <= 1;
        return new TreeNodeInfo(treeHeight, isBalancedTree);
    }

    public boolean isBalanceBinaryTree(Node root) {
        return process(root).isBalanceBinaryTree;
    }

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
//        root.right.right = new Node(5);
        root.left.left.left = new Node(6);
        boolean res = balancedBinaryTree.isBalanceBinaryTree(root);
        System.out.println(res);
    }
}
