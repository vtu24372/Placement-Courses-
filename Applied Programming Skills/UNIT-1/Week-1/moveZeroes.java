class moveZeroes {
    public void move(int[] nums) {
        int lastNonZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != lastNonZero) {
                    int temp = nums[i];
                    nums[i] = nums[lastNonZero];
                    nums[lastNonZero] = temp;
                }
                lastNonZero++;
            }
        }
    }

    
    public static void main(String[] args) {
        moveZeroes sol = new moveZeroes();

        int[] nums1 = {0, 1, 0, 3, 12};
        sol.move(nums1);
        System.out.print("Output 1: ");
        for (int x : nums1) {
            System.out.print(x + " ");
        }
        System.out.println();
        

        int[] nums2 = {0};
        sol.move(nums2);
        System.out.print("Output 2: ");
        for (int x : nums2) {
            System.out.print(x + " ");
        }
        System.out.println();
    
    }
}
