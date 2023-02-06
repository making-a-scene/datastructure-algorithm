package tree;

public class Node {
    private final int data;
    private Node left;
    private Node right; 

    public Node(final int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
}
