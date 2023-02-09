package tree;

import java.util.Stack;

public class TreeTraversal {

    public static void main(String[] args) {
        Node root = new Node(50);

        BstNodeInsertion.insertNode(root, 24);
        BstNodeInsertion.insertNode(root, 42);
        BstNodeInsertion.insertNode(root, 33);
        BstNodeInsertion.insertNode(root, 22);
        
        BstNodeInsertion.insertNode(root, 55);
        BstNodeInsertion.insertNode(root, 52);
        BstNodeInsertion.insertNode(root, 57);

        traversePreOrderRecursive(root);
        System.out.println("=======================");
        traversePreOrderNonRecursive(root);       
    }

    public static void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.getLeft());
        System.out.println(node.getData());
        traverseInOrder(node.getRight());
    }

    public static void traversePreOrderRecursive(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getData());
        traversePreOrderRecursive(node.getLeft());
        traversePreOrderRecursive(node.getRight());
    }

    public static void traversePreOrderNonRecursive(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> nodes = new Stack<>();

        nodes.push(root);

        while (!nodes.empty()) {
            Node node = nodes.pop();
            System.out.println(node.getData());

            if (node.getRight() != null) {
                nodes.push(node.getRight());
            }
            if (node.getLeft() != null) {
                nodes.push(node.getLeft());
            }

        }

    }


}