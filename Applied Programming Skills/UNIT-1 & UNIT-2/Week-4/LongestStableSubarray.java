import java.util.*;

public class LongestStableSubarray {

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();
        int left = 0, ans = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxD.isEmpty() && nums[right] > maxD.peekLast())
                maxD.pollLast();
            while (!minD.isEmpty() && nums[right] < minD.peekLast())
                minD.pollLast();

            maxD.add(nums[right]);
            minD.add(nums[right]);

            while (maxD.peek() - minD.peek() > limit) {
                if (nums[left] == maxD.peek()) maxD.poll();
                if (nums[left] == minD.peek()) minD.poll();
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {8,2,4,7};
        System.out.println(longestSubarray(nums1, 4)); // 2

        int[] nums2 = {10,1,2,4,7,2};
        System.out.println(longestSubarray(nums2, 5)); // 4

        int[] nums3 = {4,2,2,2,4,4,2,2};
        System.out.println(longestSubarray(nums3, 0)); // 3
    }
}
