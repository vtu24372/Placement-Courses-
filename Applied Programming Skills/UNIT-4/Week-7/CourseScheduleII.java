import java.util.*;
public class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1,0}})));                    // [0,1]
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));  // [0,1,2,3]
        System.out.println(Arrays.toString(findOrder(1, new int[][]{})));                         // [0]
    }
    static int[] findOrder(int n, int[][] pre) {
        int[] indegree = new int[n], res = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] p : pre) { adj.get(p[1]).add(p[0]); indegree[p[0]]++; }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) q.offer(i);
        int idx = 0;
        while (!q.isEmpty()) {
            int cur = q.poll(); res[idx++] = cur;
            for (int next : adj.get(cur)) if (--indegree[next] == 0) q.offer(next);
        }
        return idx == n ? res : new int[]{};
    }
}