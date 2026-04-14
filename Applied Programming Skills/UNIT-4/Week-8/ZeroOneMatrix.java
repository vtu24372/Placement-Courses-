import java.util.*;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0) q.add(new int[]{i, j});
                else mat[i][j] = Integer.MAX_VALUE;

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int r = cur[0]+d[0], c = cur[1]+d[1];
                if (r>=0 && r<m && c>=0 && c<n && mat[r][c] > mat[cur[0]][cur[1]]+1) {
                    mat[r][c] = mat[cur[0]][cur[1]]+1;
                    q.add(new int[]{r, c});
                }
            }
        }

        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}