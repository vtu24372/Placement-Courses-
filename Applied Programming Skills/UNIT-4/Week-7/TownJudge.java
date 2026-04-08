public class TownJudge {
    public static void main(String[] args) {
        System.out.println(find(2, new int[][]{{1,2}}));           
        System.out.println(find(3, new int[][]{{1,3},{2,3}}));     
        System.out.println(find(3, new int[][]{{1,3},{2,3},{3,1}})); 
    }
    static int find(int n, int[][] trust) {
        int[] score = new int[n + 1];
        for (int[] t : trust) { score[t[0]]--; score[t[1]]++; }
        for (int i = 1; i <= n; i++) if (score[i] == n - 1) return i;
        return -1;
    }
}