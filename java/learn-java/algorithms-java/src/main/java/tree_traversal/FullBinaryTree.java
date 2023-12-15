package tree_traversal;

public class FullBinaryTree {
    Node root;

    public FullBinaryTree() {
    }

    public static boolean isFullBinaryTree(Node root) {
        if (root == null) {
//            空数也是满二叉树
            return true;
        }
//        如果左孩子和右孩子都为空也是
        if (root.left == null && root.right == null) {
            return true;
        }
//       如果都不为空继续判断左子树和右子树
        if (root.left != null && root.right != null) {
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        }
//        子节点一个为空另一个不为空
        return false;
    }

    public static void main(String[] args) {
        FullBinaryTree tree = new FullBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        if (tree.isFullBinaryTree(tree.root))
            System.out.print("The tree is a full binary tree");
        else
            System.out.print("The tree is not a full binary tree");
    }
}
