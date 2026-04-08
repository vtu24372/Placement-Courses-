import java.util.*;
public class RottingOranges {
    public static void main(String[] args) {
        System.out.println(rot(new int[][]{{2,1,1},{1,1,0},{0,1,1}})); 
        System.out.println(rot(new int[][]{{2,1,1},{0,1,1},{1,0,1}})); 
        System.out.println(rot(new int[][]{{0,2}}));                   
    }
    static int rot(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, mins = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i,j});
                if (grid[i][j] == 1) fresh++;
            }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!q.isEmpty() && fresh > 0) {
            mins++;
            for (int s = q.size(); s-- > 0;)
                for (int[] d : dirs) {
                    int[] cur = q.poll();
                    int r = cur[0]+d[0], c = cur[1]+d[1];
                    if (r>=0 && c>=0 && r<m && c<n && grid[r][c]==1) {
                        grid[r][c]=2; fresh--; q.offer(new int[]{r,c});
                    }
                }
        }
        return fresh == 0 ? mins : -1;
    }
}