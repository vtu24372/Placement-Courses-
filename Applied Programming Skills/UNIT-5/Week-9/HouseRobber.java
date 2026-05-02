import java.util.Scanner;

class HouseRobber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        
        int prev = 0, curr = 0;
        for (int x : nums) {
            int temp = curr;
            curr = Math.max(prev + x, curr);
            prev = temp;
        }
        System.out.println(curr);
        sc.close();
    }
}