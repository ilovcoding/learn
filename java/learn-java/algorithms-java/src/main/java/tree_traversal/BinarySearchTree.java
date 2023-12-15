package tree_traversal;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
    }

    public void insert(int data) {
        root = insertKey(root, data);
    }

    public Node insertKey(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
//       节点值小于当前值
        if (data < root.data) {
            root.left = insertKey(root.left, data);
        } else if (data > root.data) {
            root.right = insertKey(root.right, data);
        }
//        相等什么都不操作
        return root;
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
//        中序遍历
        inorder(root.left);
        System.out.print(" " + root.data + " ");
        inorder(root.right);
    }

    public void delete(int data) {
        root = deleteKey(root, data);
    }

    public Node deleteKey(Node root, int data) {
        if (root == null) {
            return null;
        }
        // 如果当前数据比根节点小
        if (data < root.data) {
            root.left = deleteKey(root.left, data);
        } else if (data > root.data) {
            root.right = deleteKey(root.right, data);
        } else {
//        相等执行删除操作
//            如果左节点为空直接返回右节点
            if (root.left == null) {
                return root.right;
            }
            //            如果右节点为空直接返回左节点
            if (root.right == null) {
                return root.left;
            }
//            左右节点都不为空，使用有子树的最小值代替当前节点。
            root.data = minValue(root.right);
//            删除右子树最小值节点
            root.right = deleteKey(root.right, root.data);
        }
        return root;
    }

    public int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            root = root.left;
            min = root.data;
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);
        binarySearchTree.insert(4);
        binarySearchTree.inorder(binarySearchTree.root);
        binarySearchTree.delete(4);
        binarySearchTree.delete(6);
        System.out.println("\n---");
        binarySearchTree.inorder(binarySearchTree.root);

    }
}
