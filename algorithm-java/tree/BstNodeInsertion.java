package tree;

public class BstNodeInsertion {

    public static void main(String args[]) {
        Node root = new Node(50);

        insertNode(root, 24);
        insertNode(root, 42);
        insertNode(root, 33);
        insertNode(root, 22);

        insertNode(root, 55);
        insertNode(root, 52);
        insertNode(root, 57);

        printNode(root);
    }
	
	public static Node insertNode(Node node, int data) {
		if (node == null) {
            return new Node(data);
		}
		
		if (node.getData() > data) {
			node.setLeft(insertNode(node.getLeft(), data));
		} else {
            node.setRight(insertNode(node.getRight(), data));
        }
        return node;
	}

    private static void printNode(Node root) {
        System.out.println(root.getData());

        System.out.print(root.getLeft().getData());

        System.out.print(" ");

        System.out.print(root.getRight().getData());

        System.out.println();

        System.out.print(root.getLeft().getLeft().getData());

        System.out.print(" ");

        System.out.print(root.getLeft().getRight().getData());

        System.out.print(" ");

        System.out.print(root.getRight().getLeft().getData());

        System.out.print(" ");

        System.out.print(root.getRight().getRight().getData());

        System.out.println();

        System.out.print(root.getLeft().getRight().getLeft().getData());

        System.out.println();
    }
}