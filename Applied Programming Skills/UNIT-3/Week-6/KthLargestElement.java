import java.util.PriorityQueue;
public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println(find(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(find(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
    }
    static int find(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}