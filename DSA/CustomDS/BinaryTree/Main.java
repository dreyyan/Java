package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(1);
        binaryTree.extendTree(binaryTree.root, 3);

        System.out.println("[ Pre-order Traversal ]");
        binaryTree.preOrderTraversal(binaryTree.root);

        System.out.println();
        System.out.println("[ In-order Traversal ]");
        binaryTree.inOrderTraversal(binaryTree.root);

        System.out.println();
        System.out.println("[ Post-order Traversal ]");
        binaryTree.postOrderTraversal(binaryTree.root);
        
        System.out.println();
        System.out.println("[ Breadth-first Traversal ]");
        binaryTree.breadthFirstTraversal(binaryTree.root);

        System.out.println();
        System.out.println("[ Binary Tree ]");
        binaryTree.printTree(binaryTree.root, "", false);
    }
    
}