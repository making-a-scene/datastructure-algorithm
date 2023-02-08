package tree;

public class TreeTraversal {

    public static void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.getLeft());
        System.out.println(node.getData());
        traverseInOrder(node.getRight());
    }
}