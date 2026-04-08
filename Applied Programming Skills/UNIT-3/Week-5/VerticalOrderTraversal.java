import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int v){ val = v; }
}

public class VerticalOrderTraversal {

    static Node build(String[] a) {
        if (a[0].equals("null")) return null;

        Node root = new Node(Integer.parseInt(a[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < a.length) {
            Node cur = q.poll();

            if (!a[i].equals("null")) {
                cur.left = new Node(Integer.parseInt(a[i]));
                q.add(cur.left);
            }
            i++;

            if (i < a.length && !a[i].equals("null")) {
                cur.right = new Node(Integer.parseInt(a[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    static List<List<Integer>> vertical(Node root) {

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        Queue<int[]> pos = new LinkedList<>();

        q.add(root);
        pos.add(new int[]{0, 0}); // col, row

        while (!q.isEmpty()) {

            Node node = q.poll();
            int[] p = pos.poll();
            int col = p[0], row = p[1];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});

            if (node.left != null) {
                q.add(node.left);
                pos.add(new int[]{col - 1, row + 1});
            }

            if (node.right != null) {
                q.add(node.right);
                pos.add(new int[]{col + 1, row + 1});
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (List<int[]> list : map.values()) {

            Collections.sort(list, (a, b) ->
                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
            );

            List<Integer> temp = new ArrayList<>();
            for (int[] x : list) temp.add(x[1]);

            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        Node root = build(input);

        List<List<Integer>> ans = vertical(root);

        for (List<Integer> list : ans)
            System.out.println(list);
    }
}