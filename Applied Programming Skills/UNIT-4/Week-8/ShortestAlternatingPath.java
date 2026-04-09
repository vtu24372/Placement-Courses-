import java.util.*;
public class ShortestAlternatingPath {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(3, new int[][]{{0,1},{1,2}}, new int[][]{})));  // [0,1,-1]
        System.out.println(Arrays.toString(solve(3, new int[][]{{0,1}}, new int[][]{{2,1}})));   // [0,1,-1]
    }
    static int[] solve(int n, int[][] red, int[][] blue) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : red)  adj[e[0]].add(new int[]{e[1], 0});
        for (int[] e : blue) adj[e[0]].add(new int[]{e[1], 1});
        int[] res = new int[n]; Arrays.fill(res, -1);
        boolean[][] vis = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0}); q.offer(new int[]{0,1});
        vis[0][0] = vis[0][1] = true; res[0] = 0; int dist = 0;
        while (!q.isEmpty()) { dist++;
            for (int s=q.size(); s-->0;) for (int[] nb:adj[q.poll()[0]])
                if (!vis[nb[0]][nb[1]]) { vis[nb[0]][nb[1]]=true; if(res[nb[0]]==-1) res[nb[0]]=dist; q.offer(nb); }
        }
        return res;
    }
}