import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];


            if (lastIndex.containsKey(value)) {
                int prevIndex = lastIndex.get(value);
                if (i - prevIndex <= k) {
                    return true;
                }
            }

            lastIndex.put(value, i);
        }

        return false;
    }
}
