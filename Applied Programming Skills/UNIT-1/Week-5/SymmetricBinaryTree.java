import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class SymmetricBinaryTree {

    // Recursive
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val
            && isMirror(a.left, b.right)
            && isMirror(a.right, b.left);
    }

    // Iterative
    public static boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();

            if (a == null && b == null) continue;
            if (a == null || b == null || a.val != b.val) return false;

            q.offer(a.left);
            q.offer(b.right);
            q.offer(a.right);
            q.offer(b.left);
        }
        return true;
    }

    public static void main(String[] args) {
        // Tree: [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));           // true
        System.out.println(isSymmetricIterative(root));  // true
    }
}
