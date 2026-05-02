import java.util.*;

class FindMax {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) if (c=='0') zeros++; else ones++;
            for (int i = m; i >= zeros; i--)
                for (int j = n; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String[] strs = new String[k];
        for (int i = 0; i < k; i++) strs[i] = sc.next();
        int m = sc.nextInt(), n = sc.nextInt();
        System.out.println(new FindMax().findMaxForm(strs, m, n));
    }
}