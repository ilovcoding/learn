package tree_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        display(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preStackOrder(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            display(node);
            if (node.right != null) {
                stack.addFirst(node.right);
            }
            if (node.left != null) {
                stack.addFirst(node.left);
            }
        }
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        display(root);
        inOrder(root.right);
    }

    public void inStackOrder(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.addFirst(node);
                node = node.left;
            } else {
                node = stack.removeFirst();
                display(node);
                node = node.right;
            }
        }
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        display(root);
    }

    public void postOrderStack(Node root) {

    }

    private void display(Node node) {
        System.out.print(" " + node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node oneNode = new Node(1);
        Node twelveNode = new Node(12);
        Node nineNode = new Node(9);
        Node fiveNode = new Node(5);
        Node sixNode = new Node(6);
        oneNode.left = twelveNode;
        oneNode.right = nineNode;
        twelveNode.left = fiveNode;
        twelveNode.right = sixNode;
        tree.root = oneNode;
        System.out.println("--- preorder ---");
        tree.preOrder(tree.root);
        System.out.println("\n--- preorder  stack---");
        tree.preStackOrder(tree.root);
        System.out.println("\n--- inorder ---");
        tree.inOrder(tree.root);
        System.out.println("\n--- inorder stack ---");
        tree.inStackOrder(tree.root);
        System.out.println("\n--- postorder ---");
        tree.postOrder(tree.root);
        System.out.println("\n--- postorder stack---");
        tree.postOrderStack(tree.root);
    }
}
