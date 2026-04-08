import java.util.*;

public class BinaryTreePaths {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    void dfs(TreeNode node, String path, List<String> res) {
        if (node == null) return;
        path += node.val;
        if (node.left == null && node.right == null) res.add(path);
        else {
            dfs(node.left, path + "->", res);
            dfs(node.right, path + "->", res);
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths bt = new BinaryTreePaths();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(bt.binaryTreePaths(root)); 
    }
}