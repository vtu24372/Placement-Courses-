public class KthSmallestInBST {
    static int count, result;

    static void inorder(int[] tree, int i) {
        if (i >= tree.length || tree[i] == -1) return;
        inorder(tree, 2 * i + 1);
        if (--count == 0) result = tree[i];
        inorder(tree, 2 * i + 2);
    }

    public static void main(String[] args) {
        int[] tree = {3, 1, 4, -1, 2};
        count = 1;
        inorder(tree, 0);
        System.out.println(result); // 1

        tree = new int[]{5, 3, 6, 2, 4, -1, -1, 1};
        count = 3;
        inorder(tree, 0);
        System.out.println(result); // 3
    }
}