package tree_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NavigableMap;

public class AVLTree {
    Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // 左旋是将右边的节点旋转到左边，即 node 放入右树的左孩子中
    private Node leftRotate(Node node) {
//        找到右节点
        Node rightNode = node.right;
//       右节点的左孩子
        Node rightNodeLeft = rightNode.left;
//        当前节点变成右节点的左孩子
        rightNode.left = node;
//        原本右节点的左孩子变成当前节点的右孩子。
        node.right = rightNodeLeft;
        return rightNode;
    }

    // 右旋是将左节点转入右边，当前节点变成左节点的右孩子
    private Node rightRotate(Node node) {
        Node leftNode = node.left;
//        左节点右孩子
        Node leftRightChild = leftNode.right;
//        交换
        leftNode.right = node;
//        左节点的右孩子变成当前节点左孩子
        node.left = leftRightChild;
        return leftNode;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
//        左树高度-右树高度
        return height(node.left) - height(node.right);
    }

    public Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data > node.data) {
            node.right = insertNode(node.right, data);
        } else if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balanceFactor = getBalanceFactor(node);
//    左子树高
        if (balanceFactor > 1) {
//            需要右旋，或者先左旋再右旋转
            if (data > node.left.data) {
//                需要先左旋
                node.left = leftRotate(node.left);
            }
//            data < node.left.data 直接右旋不需要左旋
            return rightRotate(node);
        }
//    右子树高
        if (balanceFactor < -1) {
//            需要左旋，或者先右旋再左旋
            if (data < node.right.data) {
//                需要右旋
                node.right = rightRotate(node.right);
            }
//            左旋
            return leftRotate(node);
        }
        return node;
    }

    public Node nodeWithMinValue(Node node) {
        Node cur = node;
        while (node.left != null) {
            node = node.left;
            cur = node;
        }
        return cur;
    }

    Node deleteNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = deleteNode(node.right, data);
        } else if (data < node.data) {
            node.left = deleteNode(node.left, data);
        } else {
            //        相等了 执行删除操作
//       如果右节点为空 直接返回左节点
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                // 左右节点都不为空
                // 左右节点都不为空 先找到右子树的最小值
                node.data = nodeWithMinValue(node.right).data;
                node.right = deleteNode(node.right, node.data);
            }
        }

        if (node == null) {
            return null;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);
//        左树高 需要右旋转
        if (balanceFactor > 1) {
//            左子树有右孩子没有左孩子
            if (getBalanceFactor(node.left) < 0) {
//               先左旋
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
//   右树高
        if (balanceFactor < -1) {
//            需要左旋转
//            右子树有左孩子没有右孩子
            if (getBalanceFactor(node.right) > 0) {
//               先右旋
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    public void preOrder(Node node) {

        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void printTree(Node root, String indent, boolean last) {

        if (root == null) {
            return;
        }

        System.out.print(indent);
        if (last) {
            System.out.print("R----");
            indent += "   ";
        } else {
            System.out.print("L----");
            indent += "|  ";
        }
        System.out.println(root.data);
        printTree(root.left, indent, false);
        printTree(root.right, indent, true);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insertNode(tree.root, 33);
        tree.root = tree.insertNode(tree.root, 13);
        tree.root = tree.insertNode(tree.root, 53);
        tree.root = tree.insertNode(tree.root, 9);
        tree.root = tree.insertNode(tree.root, 21);
        tree.root = tree.insertNode(tree.root, 61);
        tree.root = tree.insertNode(tree.root, 8);
        tree.root = tree.insertNode(tree.root, 11);
        tree.printTree(tree.root, "", true);
        tree.preOrder(tree.root);
        System.out.println("\n----in order----");
        tree.inOrder(tree.root);
        tree.root = tree.deleteNode(tree.root, 13);
        System.out.println("\n----pre order----");
        tree.preOrder(tree.root);
        System.out.println("\n----in order----");
        tree.inOrder(tree.root);
//        tree.printTree(tree.root, "", true);

    }
}
