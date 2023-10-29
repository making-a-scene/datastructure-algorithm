package tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}

public class DfsRecursive {

    public void dfs(TreeNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");

        for (TreeNode child : node.children) {
            dfs(child);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(new TreeNode(4));
        child1.addChild(new TreeNode(5));
        child2.addChild(new TreeNode(6));
        
        new DfsRecursive().dfs(root); // 1 2 4 5 3 6
    }
}
