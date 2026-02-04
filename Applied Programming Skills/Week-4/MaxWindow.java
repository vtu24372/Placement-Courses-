import java.util.*;

class MaxWindow {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length, j = 0;
        int[] r = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() <= i - k) q.pollFirst();
            while (!q.isEmpty() && a[q.peekLast()] <= a[i]) q.pollLast();
            q.addLast(i);
            if (i >= k - 1) r[j++] = a[q.peekFirst()];
        }
        return r;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9};
        int k = 3;

        MaxWindow obj = new MaxWindow();           
        int[] x = obj.maxSlidingWindow(a, k);      

        System.out.println(Arrays.toString(x));    
    }
}
