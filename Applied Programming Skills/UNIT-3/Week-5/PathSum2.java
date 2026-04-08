import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class PathSum2 {

    static Node build(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null")) return null;

        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            Node cur = q.poll();

            if (!arr[i].equals("null")) {
                cur.left = new Node(Integer.parseInt(arr[i]));
                q.add(cur.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("null")) {
                cur.right = new Node(Integer.parseInt(arr[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    static void find(Node root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;

        path.add(root.val);

        if (root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<>(path));

        find(root.left, sum - root.val, path, res);
        find(root.right, sum - root.val, path, res);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int target = sc.nextInt();

        Node root = build(arr);

        List<List<Integer>> res = new ArrayList<>();
        find(root, target, new ArrayList<>(), res);

        System.out.println(res);
    }
}