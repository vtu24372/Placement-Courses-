import java.util.*;
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));       // true
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}})); // false
    }
    static boolean canFinish(int n, int[][] pre) {
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] p : pre) { adj.get(p[1]).add(p[0]); indegree[p[0]]++; }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) q.offer(i);
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll(); count++;
            for (int next : adj.get(cur)) if (--indegree[next] == 0) q.offer(next);
        }
        return count == n;
    }
}