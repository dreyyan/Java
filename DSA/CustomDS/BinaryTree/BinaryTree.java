package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // Attributes
    Node root;
    private int counter = 2;

    // Constructor
    public BinaryTree() { root = null; }

    // Methods
    public void createChildrenNodes(Node parent, int value1, int value2) {
        parent.left = new Node(value1);
        parent.right = new Node(value2);
    }

    public void extendTree(Node parent, int depth) {
        if (depth <= 0 || parent == null) return;

        if (parent.left == null)
            parent.left = new Node(counter++);
        if (parent.right == null)
            parent.right = new Node(counter++);

        // Recursion
        extendTree(parent.left, depth - 1);
        extendTree(parent.right, depth - 1);
    }

    public void breadthFirstTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);            
            preOrderTraversal(node.right);
        }
    }
    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);            
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);            
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}