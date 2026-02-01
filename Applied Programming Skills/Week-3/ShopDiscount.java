import java.util.*;

public class ShopDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int d = 0;
            for (int j = i + 1; j < n; j++) {
                if (p[j] <= p[i]) { d = p[j]; break; }
            }
            p[i] -= d;
        }

        for (int x : p) System.out.print(x + " ");
        sc.close();
    }
}
