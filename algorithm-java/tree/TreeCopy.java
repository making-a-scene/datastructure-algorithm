package tree;

public class TreeCopy {
    public static void main(String[] args) {
        Node root = new Node(50);

        BstNodeInsertion.insertNode(root, 24);
        BstNodeInsertion.insertNode(root, 42);
        BstNodeInsertion.insertNode(root, 33);
        BstNodeInsertion.insertNode(root, 22);

        BstNodeInsertion.insertNode(root, 55);
        BstNodeInsertion.insertNode(root, 52);
        BstNodeInsertion.insertNode(root, 57);

        TreeTraversal.traverseInOrder(root);

        System.out.println("--------------------------");

        Node rootCopy = copyRecursive(root);

        TreeTraversal.traverseInOrder(rootCopy);

        System.out.println("--------------------------");

        root.getLeft().setData(100);
        TreeTraversal.traverseInOrder(root);

        System.out.println("--------------------------");

        TreeTraversal.traverseInOrder(rootCopy);

        root.getLeft().setData(24);

        System.out.println("--------------------------");

        BstNodeInsertion.insertNode(root, 15);

        TreeTraversal.traverseInOrder(root);

        System.out.println("--------------------------");

        TreeTraversal.traverseInOrder(rootCopy);
        
    }

    public static Node copyRecursive(Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.getData());
        newNode.setLeft(copyRecursive(node.getLeft()));
        newNode.setRight(copyRecursive(node.getRight()));

        return newNode;
    }
}
