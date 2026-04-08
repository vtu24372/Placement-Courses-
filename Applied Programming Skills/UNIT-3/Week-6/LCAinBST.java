public class LCAinBST {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode lca(TreeNode root, int p, int q) {
        if (p < root.val && q < root.val) return lca(root.left, p, q);
        if (p > root.val && q > root.val) return lca(root.right, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        System.out.println(lca(root, 2, 8).val); // 6
        System.out.println(lca(root, 2, 4).val); // 2
    }
}