public class ValidPath {
    static int[] parent;

    static int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
    static void union(int a, int b) { parent[find(a)] = find(b); }

    public static void main(String[] args) {
        // Test 1
        parent = new int[]{0,1,2};
        int[][] edges = {{0,1},{1,2},{2,0}};
        for (int[] e : edges) union(e[0], e[1]);
        System.out.println(find(0) == find(2)); // true

        // Test 2
        parent = new int[]{0,1,2,3,4,5};
        edges = new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
        for (int[] e : edges) union(e[0], e[1]);
        System.out.println(find(0) == find(5)); // false
    }
}