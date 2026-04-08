import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int x : nums2) {
            while (!st.isEmpty() && x > st.peek()) {
                map.put(st.pop(), x);
            }
            st.push(x);
        }

        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));  // [-1, 3, -1]
    }
}
