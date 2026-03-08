import java.util.Arrays;

class getSumAbsolute {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long total = prefix[n - 1];

        for (int i = 0; i < n; i++) {
            
            long leftSum = (long) nums[i] * i - (i > 0 ? prefix[i - 1] : 0);

            
            long rightSum = (total - prefix[i]) - (long) nums[i] * (n - i - 1);

            res[i] = (int) (leftSum + rightSum);
        }

        return res;
    }


    public static void main(String[] args) {
        getSumAbsolute s = new getSumAbsolute();

        int[] nums1 = {2, 3, 5};
        System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(nums1)));
        

        int[] nums2 = {1, 4, 6, 8, 10};
        System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(nums2)));
        
    }
}
