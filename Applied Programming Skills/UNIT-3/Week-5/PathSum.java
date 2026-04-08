import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class PathSum {

    static Node buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null")) return null;

        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (!arr[i].equals("null")) {
                current.left = new Node(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("null")) {
                current.right = new Node(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    static boolean hasPath(Node root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null)
            return sum == root.val;

        return hasPath(root.left, sum - root.val) ||
               hasPath(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println(false);
            return;
        }

        String[] arr = line.split(" ");
        int target = sc.nextInt();

        Node root = buildTree(arr);

        System.out.println(hasPath(root, target));
    }
}