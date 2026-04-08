import java.util.*;

class BinaryTreeLevelOrder {
    // Simple tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // Zigzag level order
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }

            if (!leftToRight) Collections.reverse(level);
            ans.add(level);
            leftToRight = !leftToRight;
        }
        return ans;
    }

    public static void main(String[] args) {
        // Build sample tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = zigzagLevelOrder(root);

        // Print output
        for (List<Integer> level : res) {
            System.out.println(level);
        }
        // Output:
        // [3]
        // [20, 9]
        // [15, 7]
    }
}
