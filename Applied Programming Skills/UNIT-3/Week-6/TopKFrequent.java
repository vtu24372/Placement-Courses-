import java.util.*;
public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(find(new int[]{1}, 1)));           // [1]
    }
    static int[] find(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.merge(n, 1, Integer::sum);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int n : map.keySet()) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.stream().mapToInt(i -> i).toArray();
    }
}