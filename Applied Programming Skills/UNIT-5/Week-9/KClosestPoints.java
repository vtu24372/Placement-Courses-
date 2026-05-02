import java.util.PriorityQueue;
import java.util.Scanner;

class KClosestPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for(int i=0;i<n;i++) {
            points[i][0]=sc.nextInt();
            points[i][1]=sc.nextInt();
        }
        int k = sc.nextInt();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->(a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1])
        );
        for(int[] p:points) pq.add(p);
        
        for(int i=0;i<k;i++) {
            int[] p = pq.poll();
            System.out.print("["+p[0]+","+p[1]+"] ");
        }
        sc.close();
    }
}