import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v){ val = v; }
}

class SimplePostorder {

    public static List<Integer> postorder(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) st.push(cur.left);
            if (cur.right != null) st.push(cur.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorder(root)); // [3,2,1]
    }
}
