public class NumberOfProvinces {
    static boolean[] visited;
    static int[][] g;

    public static void main(String[] args) {
        System.out.println(find(new int[][]{{1,1,0},{1,1,0},{0,0,1}})); // 2
        System.out.println(find(new int[][]{{1,0,0},{0,1,0},{0,0,1}})); // 3
    }
    static int find(int[][] grid) {
        g = grid; int n = g.length, count = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            if (!visited[i]) { dfs(i); count++; }
        return count;
    }
    static void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < g.length; j++)
            if (g[i][j] == 1 && !visited[j]) dfs(j);
    }
}