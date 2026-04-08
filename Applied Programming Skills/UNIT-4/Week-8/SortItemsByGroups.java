import java.util.*;
public class SortItemsByGroups {
    public static void main(String[] args) {
        int[] group = {-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> before = Arrays.asList(
            List.of(), List.of(6), List.of(5), List.of(6),
            List.of(3,6), List.of(), List.of(), List.of()
        );
        System.out.println(Arrays.toString(solve(8, 2, group, before)));
    }

    static int[] solve(int n, int m, int[] g, List<List<Integer>> b) {
        for (int i = 0; i < n; i++) if (g[i] == -1) g[i] = m++;

        int[] iDeg = new int[n], gDeg = new int[m];
        List<List<Integer>> iAdj = new ArrayList<>(), gAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) iAdj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) gAdj.add(new ArrayList<>());

        for (int i = 0; i < n; i++)
            for (int x : b.get(i)) {
                iAdj.get(x).add(i); iDeg[i]++;
                if (g[x] != g[i]) { gAdj.get(g[x]).add(g[i]); gDeg[g[i]]++; }
            }

        List<Integer> items = topo(n, iDeg, iAdj);
        List<Integer> grps  = topo(m, gDeg, gAdj);
        if (items.isEmpty() || grps.isEmpty()) return new int[]{};

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : items) map.computeIfAbsent(g[i], k -> new ArrayList<>()).add(i);

        List<Integer> res = new ArrayList<>();
        for (int x : grps) res.addAll(map.getOrDefault(x, List.of()));
        return res.stream().mapToInt(i -> i).toArray();
    }

    static List<Integer> topo(int n, int[] deg, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (deg[i] == 0) q.offer(i);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int c = q.poll(); res.add(c);
            for (int x : adj.get(c)) if (--deg[x] == 0) q.offer(x);
        }
        return res.size() == n ? res : new ArrayList<>();
    }
}