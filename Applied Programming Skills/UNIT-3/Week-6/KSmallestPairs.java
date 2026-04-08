import java.util.*;
public class KSmallestPairs {
    public static void main(String[] args) {
        System.out.println(find(new int[]{1,7,11}, new int[]{2,4,6}, 3)); // [[1,2],[1,4],[1,6]]
        System.out.println(find(new int[]{1,1,2}, new int[]{1,2,3}, 2)); // [[1,1],[1,1]]
    }
    static List<List<Integer>> find(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int n : nums1) pq.offer(new int[]{n, nums2[0], 0});
        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] + 1 < nums2.length) pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}